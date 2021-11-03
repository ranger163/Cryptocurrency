package me.inassar.cryptocurrency.data.remote.source

import me.inassar.cryptocurrency.common.Resource
import me.inassar.cryptocurrency.data.remote.CoinPaprikaApi
import me.inassar.cryptocurrency.data.remote.dto.CoinDetailResponseDto
import me.inassar.cryptocurrency.data.remote.dto.CoinResponseDto
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * @author
 * Coins remote impl
 * This class is used only to deal with remote calls
 * and pass returned values to the repository
 * @property api
 * @constructor Create empty Coins remote impl
 */
class CoinsRemoteImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinsRemote {

    override suspend fun getCoins():
            Resource<List<CoinResponseDto>> = runCatching {
        val response = api.getCoins()
        when (response.isNotEmpty()) {
            true -> Resource.Success(response)
            else -> Resource.error("Response is Null or Empty $response")
        }
    }.getOrElse {
        Resource.Error(getError(it))
    }

    override suspend fun getCoinDetail(coinId: String):
            Resource<CoinDetailResponseDto> = runCatching {
        val response = api.getCoinDetails(coinId)
        when (response.id.isNotEmpty()) {
            true -> Resource.success(response)
            else -> Resource.error("Response is Null or Empty $response")
        }
    }.getOrElse {
        Resource.Error(getError(it))
    }

    private fun getError(throwable: Throwable): String = when (throwable) {
        is HttpException -> throwable.message.orEmpty()
        is IOException -> throwable.message.orEmpty()
        else -> throwable.message.orEmpty()
    }
}
