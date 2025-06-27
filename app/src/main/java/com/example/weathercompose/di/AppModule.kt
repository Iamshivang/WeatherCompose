package com.example.weathercompose.di

import com.example.weathercompose.data.remote.WeatherApi
import com.example.weathercompose.data.repository.WeatherRepositoryImpl
import com.example.weathercompose.domain.repository.WeatherRepository
import com.example.weathercompose.utils.Contstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
 * Author: Shivang Yadav
 * Created: 6/26/25
 * Description: [Add description here]
 */


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideWeatherApi(): WeatherApi=
        Retrofit.Builder()
            .baseUrl(Contstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)

    @Singleton
    @Provides
    fun provideWeatherRepository(
        api: WeatherApi
    ): WeatherRepository = WeatherRepositoryImpl(api = api)
}