package com.example.democodedagger.di

import com.example.democodedagger.userslist.UsersListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    fun inject(usersListActivity: UsersListActivity)
}