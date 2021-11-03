package me.inassar.cryptocurrency.domain.model

import me.inassar.cryptocurrency.data.remote.dto.CoinDetailResponseDto

/**
 * @author Nassar
 * Coin detail
 * This data class is used to map values coming from remote represented in [CoinDetailResponseDto]
 * and then we map it here and use it into app UI layer.
 * @property coinId
 * @property name
 * @property description
 * @property symbol
 * @property rank
 * @property isActive
 * @property tags
 * @property team
 * @constructor Create empty Coin detail
 */
data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<CoinDetailResponseDto.TeamMember>
)
