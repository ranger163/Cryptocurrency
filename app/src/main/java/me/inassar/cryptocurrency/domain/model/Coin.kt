package me.inassar.cryptocurrency.domain.model

import me.inassar.cryptocurrency.data.remote.dto.CoinResponseDto

/**
 * @author Nassar
 * Coin
 * This data class is used to map values coming from remote represented in [CoinResponseDto]
 * and then we map it here and use it into app UI layer.
 * @property id
 * @property isActive
 * @property name
 * @property rank
 * @property symbol
 * @constructor Create empty Coin
 */
data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
