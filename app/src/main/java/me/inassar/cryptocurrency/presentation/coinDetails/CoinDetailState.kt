package me.inassar.cryptocurrency.presentation.coinDetails

import me.inassar.cryptocurrency.domain.model.CoinDetail

/**
 * @author Nassar
 * Coin detail state
 * This data model is used as data state wrapper to be exposed from ViewModel to UI.
 * @property isLoading
 * @property coinDetail
 * @property error
 * @constructor Create empty Coin detail state
 */
data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
)
