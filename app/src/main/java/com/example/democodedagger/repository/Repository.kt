package com.example.democodedagger.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.democodedagger.models.UsersDataModel
import com.example.democodedagger.retrofit.RetrofitService
import javax.inject.Inject

class Repository @Inject constructor(private val retrofitService: RetrofitService) {

    suspend fun getUsersListData() = retrofitService.getUsersListData()
}