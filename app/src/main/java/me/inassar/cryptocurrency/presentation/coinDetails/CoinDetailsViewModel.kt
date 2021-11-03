package me.inassar.cryptocurrency.presentation.coinDetails

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.inassar.cryptocurrency.common.Constants
import me.inassar.cryptocurrency.common.Resource
import me.inassar.cryptocurrency.common.ViewState
import me.inassar.cryptocurrency.domain.model.CoinDetail
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

    private val _coinDetailState = MutableLiveData<ViewState<CoinDetail>>()
    val coinDetailState: LiveData<ViewState<CoinDetail>> = _coinDetailState

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            getCoinDetail(it)
        }
    }

    private fun getCoinDetail(coinId: String) {
        getCoinUseCase(coinId).onEach {
            _coinDetailState.value = ViewState.loading()
            when (it) {
                is Resource.Error -> _coinDetailState.value = ViewState.error(it.errorMessage)
                is Resource.Success -> _coinDetailState.value = ViewState.success(it.data)
            }
        }.launchIn(viewModelScope)
    }
}
