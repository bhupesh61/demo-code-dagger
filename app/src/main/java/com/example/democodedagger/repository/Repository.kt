package com.example.democodedagger.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.democodedagger.models.UsersDataModel
import com.example.democodedagger.retrofit.RetrofitService
import javax.inject.Inject

class Repository @Inject constructor(private val retrofitService: RetrofitService) {

//    private val usersDataList = MutableLiveData<List<UsersDataModel>>()
//
//    val usersList: LiveData<List<UsersDataModel>> = usersDataList
//
//    suspend fun getUsersListData() {
//        val result = retrofitService.getUsersListData()
//        if (result.isSuccessful && result.body() != null) {
//            usersDataList.postValue(result.body())
//        }
//    }

    suspend fun getUsersListData() = retrofitService.getUsersListData()
}