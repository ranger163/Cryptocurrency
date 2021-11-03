package me.inassar.cryptocurrency.data.remote.mappers

import me.inassar.cryptocurrency.data.remote.dto.CoinResponseDto
import me.inassar.cryptocurrency.domain.model.Coin

/**
 * To coin
 * Mapping needed values from [CoinResponseDto] to [Coin]
 * to be used into app UI
 */
fun CoinResponseDto.toCoin() = Coin(
    id = id,
    isActive = isActive,
    name = name,
    rank = rank,
    symbol = symbol
)
