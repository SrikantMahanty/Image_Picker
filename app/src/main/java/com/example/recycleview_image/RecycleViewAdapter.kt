package com.example.recycleview_image

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.recycleview_image.databinding.ItemLayoutBinding

class RecycleViewAdapter(var list: ArrayList<String>) :
    RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {
    fun setDatalist(list: ArrayList<String>) {
        this.list = list
        notifyDataSetChanged()
    }
    class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding=ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem=list[position]
        Glide.with(holder.binding.imgview.context.applicationContext).load(currentItem)
            .into(holder.binding.imgview)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}



