package com.example.dogapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dogapps.local.DogEntity
import java.text.FieldPosition

class DogAdapter : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    private var dogList = empyList<DogEntity>()
    private val selectedDogDatabase = MutableList<DogEntity>()
    fun selectedItem(): MutableList<DogEntity> = selectedDogDatabase

    fun update(list: List<DogEntity>) {
        dogList = list
        notifyDataSetChanged()
    }

    inner class DogViewHolder(private val binding: DogItemListBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(dog: DogEntity) {
            Glide.with(binding.textView).load(dog.breed).into(binding.textView)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            selectedDogDatabase.value = dogList[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder(DogItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = dogList.size{
    }

    override fun onBindViewHolder(holder: DogAdapter.DogViewHolder, position: Int) {
        val dog = dogList[position]
        holder.bind(dog)
    }
}
