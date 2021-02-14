package com.example.dogapps.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DogDao {
//Insertar elementos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDog(dog:DogEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageDog(dog:ImageDogEntity)

//Insertar lista de elementos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDog(listDog:List<DogEntity>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImageDog(listImages: List<ImageDogEntity>)

//borrar
    @Delete
    suspend fun deleteDog(dog: DogEntity)
    @Delete
    suspend fun deleteimageDog(dog: ImageDogEntity)


 //traer por Id

    @Query("SELECT * FROM dog_table")
    fun getDogById(id: String): LiveData<DogEntity>

    @Query("SELECT * FROM image_table WHERE id =id")
    fun getImagebyId(id: String): LiveData<ImageDogEntity>


    //traer toda la informacion

    @Query ("SELECT * FROM dog_table")
    fun getAllDogs():LiveData<List<DogEntity>>

    @Query("SELECT * FROM image_table")
    fun getAllImages() : LiveData<List<ImageDogEntity>>


}

