package com.example.dogapps.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DogEntity::class, ImageDogEntity::class], version = 1)
abstract class DogDatabase : RoomDatabase(){

    abstract fun getDogDao() : DogDao
    companion object{
        @Volatile
        private var Instance : DogDatabase? = null

        fun getDataBase (context : Context) : DogDatabase {
            val tempInstance = Instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    DogDatabase::class.java, "dog_db").build()
                Instance = instance
                return instance
            }
        }
    }
}