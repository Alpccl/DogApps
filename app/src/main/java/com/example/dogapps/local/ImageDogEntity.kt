package com.example.dogapps.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName= "image_table")
data class ImageDogEntity (
    @PrimaryKey
    @NotNull
    @SerializedName( "id")
    val id : String,
    @SerializedName( "image")
    val image : String

)