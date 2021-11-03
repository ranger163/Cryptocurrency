package me.inassar.cryptocurrency.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import me.inassar.cryptocurrency.common.Resource
import me.inassar.cryptocurrency.data.remote.dto.CoinDetailResponseDto
import me.inassar.cryptocurrency.data.remote.dto.CoinResponseDto
import me.inassar.cryptocurrency.data.remote.source.CoinsRemote
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
    private val remote: CoinsRemote
) : CoinRepository {

    /**
     * Get coins
     * Making a remote call and requesting for a list of coins.
     * @return
     */
    override fun getCoins(): Flow<Resource<List<CoinResponseDto>>> = flow {
        when (val response = remote.getCoins()) {
            is Resource.Error -> emit(Resource.error(response.errorMessage))
            is Resource.Success -> emit(Resource.success(response.data))
        }
    }.catch {
        it.localizedMessage?.let { errorMessage ->
            emit(Resource.error(errorMessage))
        }
    }

    /**
     * Get coin detail
     * Making a remote call and requesting for a coin details using coin id
     * @param coinId
     * @return
     */
    override fun getCoinDetail(coinId: String): Flow<Resource<CoinDetailResponseDto>> = flow {
        when (val response = remote.getCoinDetail(coinId)) {
            is Resource.Error -> emit(Resource.error(response.errorMessage))
            is Resource.Success -> emit(Resource.success(response.data))
        }
    }.catch {
        it.localizedMessage?.let { errorMessage ->
            emit(Resource.error(errorMessage))
        }
    }
}
