package me.inassar.cryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName

/**
 * @author Nassar
 * Coin detail response dto
 * This data class is used to map data received from Api.
 * @property description
 * @property developmentStatus
 * @property firstDataAt
 * @property hardwareWallet
 * @property hashAlgorithm
 * @property id
 * @property isActive
 * @property isNew
 * @property lastDataAt
 * @property links
 * @property linksExtended
 * @property message
 * @property name
 * @property openSource
 * @property orgStructure
 * @property proofType
 * @property rank
 * @property startedAt
 * @property symbol
 * @property tags
 * @property team
 * @property type
 * @property whitepaper
 * @constructor Create empty Coin detail response dto
 */
data class CoinDetailResponseDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
    @SerializedName("message")
    val message: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("tags")
    val tags: List<Tag>,
    @SerializedName("team")
    val team: List<TeamMember>,
    @SerializedName("type")
    val type: String,
    @SerializedName("whitepaper")
    val whitepaper: Whitepaper
) {
    data class Links(
        @SerializedName("explorer")
        val explorer: List<String>,
        @SerializedName("facebook")
        val facebook: List<String>,
        @SerializedName("reddit")
        val reddit: List<String>,
        @SerializedName("source_code")
        val sourceCode: List<String>,
        @SerializedName("website")
        val website: List<String>,
        @SerializedName("youtube")
        val youtube: List<String>
    )

    data class LinksExtended(
        @SerializedName("stats")
        val stats: Stats,
        @SerializedName("type")
        val type: String,
        @SerializedName("url")
        val url: String
    ) {
        data class Stats(
            @SerializedName("contributors")
            val contributors: Int,
            @SerializedName("followers")
            val followers: Int,
            @SerializedName("stars")
            val stars: Int,
            @SerializedName("subscribers")
            val subscribers: Int
        )
    }

    data class Tag(
        @SerializedName("coin_counter")
        val coinCounter: Int,
        @SerializedName("ico_counter")
        val icoCounter: Int,
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String
    )

    data class TeamMember(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("position")
        val position: String
    )

    data class Whitepaper(
        @SerializedName("link")
        val link: String,
        @SerializedName("thumbnail")
        val thumbnail: String
    )
}
