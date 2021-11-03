package me.inassar.cryptocurrency.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.inassar.cryptocurrency.common.Constants
import me.inassar.cryptocurrency.data.remote.CoinPaprikaApi
import me.inassar.cryptocurrency.data.remote.source.CoinsRemote
import me.inassar.cryptocurrency.data.remote.source.CoinsRemoteImpl
import me.inassar.cryptocurrency.data.repository.CoinRepositoryImpl
import me.inassar.cryptocurrency.domain.repository.CoinRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Nassar
 * App module
 * This class is used to help at easily make our
 * dependencies replaceable as we don't hardcode then into classes.
 * @constructor Create empty App module
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)

    @Provides
    @Singleton
    fun provideRemoteCalls(api: CoinPaprikaApi): CoinsRemote =
        CoinsRemoteImpl(api = api)

    @Provides
    @Singleton
    fun provideCoinRepository(remote: CoinsRemote): CoinRepository =
        CoinRepositoryImpl(remote = remote)
}
