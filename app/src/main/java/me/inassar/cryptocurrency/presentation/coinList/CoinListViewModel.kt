package me.inassar.cryptocurrency.presentation.coinList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.inassar.cryptocurrency.common.Resource
import me.inassar.cryptocurrency.domain.usesCase.getCoins.GetCoinsUseCase
import javax.inject.Inject

/**
 * @author Nassar
 * Coin list view model
 * This ViewModel class is responsible for preparing
 * and managing coin list data for UI
 * @property getCoinsUseCase
 * @constructor Create empty Coin list view model
 */
@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _coinListState = mutableStateOf(CoinListState())
    val coinListState: State<CoinListState> = _coinListState

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach {
            _coinListState.value = CoinListState(isLoading = true)
            when (it) {
                is Resource.Error -> _coinListState.value = CoinListState(error = it.errorMessage)
                is Resource.Success -> _coinListState.value = CoinListState(coins = it.data)
            }
        }.launchIn(viewModelScope)
    }
}
