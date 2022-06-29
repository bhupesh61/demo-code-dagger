package com.example.democodedagger.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.democodedagger.repository.Repository
import javax.inject.Inject

class UsersListViewModelFactory @Inject constructor(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(UsersListViewModel::class.java)) {
            UsersListViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}