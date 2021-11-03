package me.inassar.cryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

/**
 * @author Nassar
 * Coin dto
 * This data class is used to map data received from Api.
 * @property id
 * @property isActive
 * @property isNew
 * @property name
 * @property rank
 * @property symbol
 * @property type
 * @constructor Create empty Coin dto
 */
data class CoinResponseDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("type")
    val type: String
)
