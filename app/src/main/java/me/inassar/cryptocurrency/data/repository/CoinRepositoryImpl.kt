package me.inassar.cryptocurrency.data.repository

import me.inassar.cryptocurrency.data.remote.CoinPaprikaApi
import me.inassar.cryptocurrency.data.remote.dto.CoinDetailResponseDto
import me.inassar.cryptocurrency.data.remote.dto.CoinResponseDto
import me.inassar.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

/**
 * @author Nassar
 * Coin repository impl
 * This repository class it used to be our data source for the presentation layer
 * as it hold calls Api and do it's logic, also it could hold database business if needed.
 * @property remote
 * @constructor Create empty Coin repository impl
 */
class CoinRepositoryImpl @Inject constructor(
    private val remote: CoinPaprikaApi
) : CoinRepository {
    /**
     * Get coins
     * Making a remote call and requesting for a list of coins.
     * @return
     */
    override suspend fun getCoins(): List<CoinResponseDto> =
        remote.getCoins()

    /**
     * Get coin detail
     * Making a remote call and requesting for a coin details using coin id
     * @param coinId
     * @return
     */
    override suspend fun getCoinDetail(coinId: String): CoinDetailResponseDto =
        remote.getCoinDetails(coinId)
}
