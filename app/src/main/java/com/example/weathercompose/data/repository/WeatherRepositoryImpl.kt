package com.example.weathercompose.data.repository

import android.util.Log
import com.example.weathercompose.data.remote.WeatherApi
import com.example.weathercompose.data.remote.dto.WeatherResponse
import com.example.weathercompose.domain.model.forecast.Item
import com.example.weathercompose.domain.repository.WeatherRepository
import com.example.weathercompose.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/*
 * Author: Shivang Yadav
 * Created: 6/26/25
 * Description: [Add description here]
 */


class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    private val TAG = "WeatherRepositoryImpl"

    override suspend fun getCurrentWeather(
        lat: Double,
        lon: Double
    ): Flow<Resource<WeatherResponse>> {

        return flow {
            emit(Resource.Loading())

            try {
                val result = api.getCurrentWeather(
                    lat= lat,
                    lon= lon
                )

                if(result.isSuccessful){
                    emit(Resource.Success(result.body()!!))
                    Log.d(TAG, "Success in currentWeather: ${result.message()}")
                }else{
                    emit(Resource.Error(result.errorBody().toString()))
                    Log.e(TAG, "Error in currentWeather: ${result.errorBody().toString()}")
                }

            }catch (e: Exception){
                emit(Resource.Error(e.message.toString()))
                Log.e(TAG, "Error in currentWeather: ${e.message.toString()}")
            }
        }
    }

    override suspend fun getFiveDaysForecast(
        lat: Double,
        lon: Double
    ): Flow<Resource<List<Item>>> {

        return flow {
            emit(Resource.Loading())

            try {
                val result = api.getFiveDaysForecast(
                    lat= lat,
                    lon= lon
                )

                if(result.isSuccessful){
                    emit(Resource.Success(result.body()?.list!!))
                    Log.d(TAG, "Success in fiveDaysForecast: ${result.message()}")
                }else{
                    emit(Resource.Error(result.errorBody().toString()))
                    Log.e(TAG, "Error in fiveDaysForecast: ${result.errorBody().toString()}")
                }

            }catch (e: Exception){
                emit(Resource.Error(e.message.toString()))
                Log.e(TAG, "Error in fiveDaysForecast: ${e.message.toString()}")
            }
        }
    }
}