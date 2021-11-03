package me.inassar.cryptocurrency.domain.repository

import kotlinx.coroutines.flow.Flow
import me.inassar.cryptocurrency.common.Resource
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

    fun getCoins(): Flow<Resource<List<CoinResponseDto>>>

    fun getCoinDetail(coinId: String): Flow<Resource<CoinDetailResponseDto>>
}
