package com.example.democodedagger

import android.graphics.Movie
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.democodedagger.models.UsersDataModel
import com.example.democodedagger.repository.Repository
import com.example.democodedagger.retrofit.RetrofitService
import com.example.democodedagger.viewmodels.UsersListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher

import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class UsersListViewModelTest {


    private val testDispatcher = TestCoroutineDispatcher()
    lateinit var usersListViewModel: UsersListViewModel
    lateinit var repository: Repository

    @Mock
    lateinit var retrofitService: RetrofitService

    @get:Rule
    val instantTaskExecutionRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
        repository = Repository(retrofitService)
        usersListViewModel = UsersListViewModel(repository)
    }

    @Test
    fun getAllUsersListTest() {
        runBlocking {
            Mockito.`when`(repository.getUsersListData())
                .thenReturn(
                    Response.success(
                        listOf<UsersDataModel>(
                            UsersDataModel(
                                "Charles",
                                "Manager",
                                "41 Riverside",
                                "6792474939",
                                "charlestest382@hmy.com"
                            )
                        )
                    )
                )
            usersListViewModel.getUsersListData()
            val result = usersListViewModel.usersList.getOrAwaitValue()
            assertEquals(
                listOf<UsersDataModel>(
                    UsersDataModel(
                        "Charles",
                        "Manager",
                        "41 Riverside",
                        "6792474939",
                        "charlestest382@hmy.com"
                    )
                ), result
            )
        }
    }


    @Test
    fun emptyUsersListTest() {
        runBlocking {
            Mockito.`when`(repository.getUsersListData())
                .thenReturn(Response.success(listOf<UsersDataModel>()))
            usersListViewModel.getUsersListData()
            val result = usersListViewModel.usersList.getOrAwaitValue()
            assertEquals(listOf<UsersDataModel>(), result)
        }
    }

}

