package com.example.dogapps.adapter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.dogapps.DogRepository
import com.example.dogapps.local.DogDatabase
import com.example.dogapps.local.DogEntity
import kotlinx.coroutines.launch

class DogViewModel (application: Application): AndroidViewModel(application){

    private val repository : DogRepository
    var allDog = LiveData<List<DogEntity>>

    init {
        val DogDao = DogDatabase.getDataBase(application).getDogDao()
        repository = DogRepository(DogDao)
        allDog = repository.DogInternet
        viewModelScope.launch {
            repository.fechDataFromInternetCoroutines()
        }

    }
    fun getDogById(id: String) : LiveData<DogEntity> {
        return repository.getDogById(id)
    }

}