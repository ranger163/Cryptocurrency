package me.inassar.cryptocurrency.data.remote.mappers

import me.inassar.cryptocurrency.data.remote.dto.CoinDetailResponseDto
import me.inassar.cryptocurrency.domain.model.CoinDetail

/**
 * To coin detail
 * Mapping needed values from [CoinDetailResponseDto] to [CoinDetail]
 * to be used into app UI
 */
fun CoinDetailResponseDto.toCoinDetail() = CoinDetail(
    coinId = id,
    name = name,
    description = description,
    symbol = symbol,
    rank = rank,
    isActive = isActive,
    tags = tags.map { it.name },
    team = team
)
