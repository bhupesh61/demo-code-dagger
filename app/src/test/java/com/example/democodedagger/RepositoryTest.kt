package com.example.democodedagger

import com.example.democodedagger.models.UsersDataModel
import com.example.democodedagger.repository.Repository
import com.example.democodedagger.retrofit.RetrofitService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

@RunWith(JUnit4::class)
class RepositoryTest {


    lateinit var repository: Repository

    @Mock
    lateinit var retrofitService: RetrofitService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = Repository(retrofitService)
    }

    @Test
    fun repositoryMethodTest() {
        val userDataModel = listOf(
            UsersDataModel(
                "Charles",
                "Manager",
                "41 Riverside",
                "6792474939",
                "charlestest382@hmy.com"
            )
        )
        runBlocking {
            Mockito.`when`(retrofitService.getUsersListData())
                .thenReturn(Response.success(userDataModel))

            val response = repository.getUsersListData()
            assertEquals(userDataModel, response.body())
        }
    }


}