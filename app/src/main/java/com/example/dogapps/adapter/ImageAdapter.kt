package com.example.dogapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dogapps.local.DogEntity
import com.example.dogapps.local.ImageDogEntity

class ImageAdapter : RecyclerView.Adapter<DogAdapter.ImageDogViewHolder>() {

    private var imageList = emptyList<ImageDogEntity>()
    private val selectedImageDogDatabase = MutableList<ImageDogEntity>()
    fun selectedItem():LiveData<ImageDogEntity> = selectedImageDogDatabase


    fun update (list : List<ImageDogEntity>){
        imageList = list
        notifyDataSetChanged()
    }

        inner class ImageDogViewHolder(private val binding: ImageDogListBinding):
        RecyclerView.ViewHolder(binding.root), View.OnClickListener{
            fun bind(image : ImageDogEntity){
                Glide.with(binding.imageView).load(image.image).into(binding.imageView)
                itemView.setOnClickListener(this)
            }

            override fun onClick(v: View?) {
                selectedImageDogDatabase.value = imageList[adapterPosition]
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ImageDogViewHolder {
        return ImageDogViewHolder(ImageDogListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ImageAdapter.ImageDogViewHolder, position: Int) {
        val image = imageList[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int = dogList.size {

    }


}