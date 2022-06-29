package com.example.democodedagger

import com.example.democodedagger.retrofit.RetrofitService
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitTest {

    lateinit var mockWebServer: MockWebServer
    lateinit var retrofitService: RetrofitService
    lateinit var gson: Gson

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        gson = Gson()
        mockWebServer = MockWebServer()
        retrofitService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(RetrofitService::class.java)
    }

    @Test
    fun retrofitServiceTest() {
        runBlocking {
            val mockResponse = MockResponse()
            mockWebServer.enqueue(mockResponse.setBody("[]"))
            val response = retrofitService.getUsersListData()
            val request = mockWebServer.takeRequest()
            Assert.assertEquals("/v1/cbd40712-ed28-44b4-9987-231d11974809", request.path)
            Assert.assertEquals(true, response.body()?.isEmpty() == true)
        }
    }
}