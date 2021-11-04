package me.inassar.cryptocurrency.presentation.coinList

import me.inassar.cryptocurrency.domain.model.Coin

/**
 * @author Nassar
 * Coin list state
 * This data model is used as data state wrapper to be exposed from ViewModel to UI.
 * @property isLoading
 * @property coins
 * @property error
 * @constructor Create empty Coin list state
 */
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
