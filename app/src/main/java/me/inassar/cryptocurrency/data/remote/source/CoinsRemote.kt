package me.inassar.cryptocurrency.data.remote.source

import me.inassar.cryptocurrency.common.Resource
import me.inassar.cryptocurrency.data.remote.dto.CoinDetailResponseDto
import me.inassar.cryptocurrency.data.remote.dto.CoinResponseDto

interface CoinsRemote {

    suspend fun getCoins(): Resource<List<CoinResponseDto>>

    suspend fun getCoinDetail(coinId: String): Resource<CoinDetailResponseDto>
}
