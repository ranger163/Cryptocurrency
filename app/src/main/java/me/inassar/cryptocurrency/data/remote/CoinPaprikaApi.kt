package me.inassar.cryptocurrency.data.remote

import me.inassar.cryptocurrency.common.Constants
import me.inassar.cryptocurrency.data.remote.dto.CoinDetailResponseDto
import me.inassar.cryptocurrency.data.remote.dto.CoinResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Nassar
 * Coin paprika api
 * This interface is used to define routs and endpoints
 * that we need to have access to from the server into our app.
 * @constructor Create empty Coin paprika api
 */
interface CoinPaprikaApi {

    @GET(Constants.ENDPOINT_GET_COINS_LIST)
    suspend fun getCoins(): List<CoinResponseDto>

    @GET(Constants.ENDPOINT_GET_COIN_DETAIL)
    suspend fun getCoinDetails(
        @Path(Constants.PARAM_COIN_ID) coinId: String
    ): CoinDetailResponseDto
}
