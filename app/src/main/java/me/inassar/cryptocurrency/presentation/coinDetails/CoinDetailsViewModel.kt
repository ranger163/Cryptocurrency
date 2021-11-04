package me.inassar.cryptocurrency.presentation.coinDetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.inassar.cryptocurrency.common.Constants
import me.inassar.cryptocurrency.common.Resource
import me.inassar.cryptocurrency.domain.usesCase.getCoin.GetCoinUseCase
import javax.inject.Inject

/**
 * @author Nassar
 * Coin details view model
 * This ViewModel class is responsible for preparing
 * and managing coin details data for UI
 * @property getCoinUseCase
 * @constructor
 *
 * @param savedStateHandle
 */
@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _coinDetailState = mutableStateOf(CoinDetailState())
    val coinDetailState: State<CoinDetailState> = _coinDetailState

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            getCoinDetail(it)
        }
    }

    private fun getCoinDetail(coinId: String) {
        getCoinUseCase(coinId).onEach {
            _coinDetailState.value = CoinDetailState(isLoading = true)
            when (it) {
                is Resource.Error -> _coinDetailState.value =
                    CoinDetailState(error = it.errorMessage)
                is Resource.Success -> _coinDetailState.value =
                    CoinDetailState(coinDetail = it.data)
            }
        }.launchIn(viewModelScope)
    }
}
