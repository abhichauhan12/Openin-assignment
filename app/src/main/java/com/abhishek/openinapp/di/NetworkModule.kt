package com.abhishek.openinapp.di

import com.abhishek.openinapp.data.network.APIService
import com.abhishek.openinapp.data.network.apiservice.DataApi
import com.abhishek.openinapp.utils.BASE_URL
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }

    @Provides
    fun provideAPIService(retrofit: Retrofit) : APIService {
        return APIService(retrofit = retrofit)
    }

    @Provides
    fun provideWeatherAPI(apiService: APIService) : DataApi {
        return apiService.createAPI(DataApi::class.java)
    }


}