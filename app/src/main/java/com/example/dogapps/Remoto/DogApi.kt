package com.example.dogapps.Remoto

import com.example.dogapps.local.DogEntity
import com.example.dogapps.local.ImageDogEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface DogApi {
    @GET("breeds/list/")
    suspend fun fetchDogDataCoroutines(): Response<List<DogEntity>>

    @GET("breed/{breed}/images")
    suspend fun imageDogsCoroutines(@Path("breed")breed:String): Response<List<ImageDogEntity>>
}
