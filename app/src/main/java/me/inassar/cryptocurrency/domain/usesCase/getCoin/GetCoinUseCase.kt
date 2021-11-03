package me.inassar.cryptocurrency.domain.usesCase.getCoin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import me.inassar.cryptocurrency.common.Resource
import me.inassar.cryptocurrency.data.remote.mappers.toCoinDetail
import me.inassar.cryptocurrency.domain.model.CoinDetail
import me.inassar.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

/**
 * @author Nassar
 * Get coin use case
 * This use case class it used to operate logic related to getCoinDetail functionality only
 * and it should not hold any other logic related to any other functionalities
 * @property coinRepository
 * @constructor Create empty Get coin use case
 */
class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        coinRepository.getCoinDetail(coinId).collect { coinDetailDto ->
            val resource = when (coinDetailDto) {
                is Resource.Error -> Resource.error(coinDetailDto.errorMessage)
                is Resource.Success -> Resource.success(coinDetailDto.data.toCoinDetail())
            }
            emit(resource)
        }
    }
}
