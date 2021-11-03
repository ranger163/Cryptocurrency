package me.inassar.cryptocurrency.domain.usesCase.getCoins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import me.inassar.cryptocurrency.common.Resource
import me.inassar.cryptocurrency.data.remote.mappers.toCoin
import me.inassar.cryptocurrency.domain.model.Coin
import me.inassar.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

/**
 * @author Nassar
 * Get coins use case
 * This use case class it used to operate logic related to getCoins functionality only
 * and it should not hold any other logic related to any other functionalities.
 * @property coinRepository
 * @constructor Create empty Get coins use case
 */
class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        coinRepository.getCoins().collect { listOfCoinsDto ->
            val resource = when (listOfCoinsDto) {
                is Resource.Error -> Resource.error(listOfCoinsDto.errorMessage)
                is Resource.Success -> Resource.success(listOfCoinsDto.data.map { it.toCoin() })
            }
            emit(resource)
        }
    }
}
