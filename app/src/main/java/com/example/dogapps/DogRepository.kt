package com.example.dogapps

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.dogapps.Remoto.RetrofitClient
import com.example.dogapps.local.DogDao
import com.example.dogapps.local.DogEntity
import com.example.dogapps.local.ImageDogEntity

class DogRepository(private val dogDao: DogDao) {

    val DogInternet = dogDao.getAllDogs()
    val imageDogInternet = dogDao.getAllImages()

    private val retrofitClient = RetrofitClient.getRetrofit()

    //datos courutinas
    suspend fun fechDataFromInternetCoroutines() {
        try {
            val response = retrofitClient.fetchDogDataCoroutines()
            when (response.code()) {
                in 200..299 -> response.body()?.let { dogDao.insertAllDog(it) }
                in 300..399 -> Log.d("REPO", "${response.code()} --- ${response.errorBody()}")
                else -> Log.d("REPO", "${response.code()} --- ${response.errorBody().toString()}")
            }
        } catch (t: Throwable) {
            Log.e("REPO", "${t.message}")


            suspend fun imageDogCoroutines() {
                try {
                    val response = retrofitClient.imageDogsCoroutines("id")
                    when (response.code()) {
                        in 200..299 -> response.body()?.let { dogDao.insertAllImageDog(it) }
                        in 300..399 -> Log.d(
                            "REPO",
                            "${response.code()} --- ${response.errorBody()}"
                        )
                        else -> Log.d(
                            "REPO",
                            "${response.code()} --- ${response.errorBody().toString()}"
                        )
                    }
                } catch (t: Throwable) {
                    Log.e("REPO", "${t.message}")
                }
            }
        }

    }
    fun getDogById(id: String): LiveData<DogEntity> {
        return dogDao.getDogById(id)
    }
}


