package com.example.democodedagger.retrofit

import com.example.democodedagger.models.UsersDataModel
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("v1/cbd40712-ed28-44b4-9987-231d11974809")
    suspend fun getUsersListData(): Response<List<UsersDataModel>>
}