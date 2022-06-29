package com.example.democodedagger.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.democodedagger.models.UsersDataModel
import com.example.democodedagger.repository.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class UsersListViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val usersList = MutableLiveData<List<UsersDataModel>>()

    fun getUsersListData() {
        viewModelScope.launch {
            val response = repository.getUsersListData()
            if (response.isSuccessful && response.body() != null)
                usersList.postValue(response.body())
        }

    }
}