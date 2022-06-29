package com.example.democodedagger.di

import com.example.democodedagger.retrofit.RetrofitService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofitInstance() : Retrofit{
        return Retrofit.Builder()
                    .baseUrl("https://mocki.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
    }

    @Singleton
    @Provides
    fun getRetrofitServiceInstance(retrofit: Retrofit) : RetrofitService{
        return retrofit.create(RetrofitService::class.java)
    }


}