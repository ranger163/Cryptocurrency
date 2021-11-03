package me.inassar.cryptocurrency.common

/**
 * @author Nassar
 * Constants
 * This class is used to hold static values to be used across the app when needed.
 * @constructor Create empty Constants
 */
object Constants {

    const val BASE_URL = "https://api.coinpaprika.com/"

    const val PARAM_COIN_ID = "coinId"

    const val ENDPOINT_GET_COINS_LIST = "/v1/coins"
    const val ENDPOINT_GET_COIN_DETAIL = "/v1/coins/{$PARAM_COIN_ID}"
}
