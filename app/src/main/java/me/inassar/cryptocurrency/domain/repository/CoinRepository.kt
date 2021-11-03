package me.inassar.cryptocurrency.domain.repository

import me.inassar.cryptocurrency.data.remote.dto.CoinDetailResponseDto
import me.inassar.cryptocurrency.data.remote.dto.CoinResponseDto

/**
 * @author Nassar
 * Coin repository
 * This interface will be helpful when we need to test CoinRepository
 * to implement our test cases separately from real implementation
 * @constructor Create empty Coin repository
 */
interface CoinRepository {

    suspend fun getCoins(): List<CoinResponseDto>

    suspend fun getCoinDetail(coinId: String): CoinDetailResponseDto
}
