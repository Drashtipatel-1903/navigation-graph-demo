package com.crm.navigationcomponentwithrecycvlerviewdemo.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.crm.navigationcomponentwithrecycvlerviewdemo.databinding.ChildRawLayoutBinding
import com.crm.navigationcomponentwithrecycvlerviewdemo.modal.MovieData

class ChildAdapter(private val ImageList:ArrayList<MovieData> ,
                   private val imageClickListner: ImageClickListner)
    : RecyclerView.Adapter<ChildAdapter.ChildViewHolder>()
{
    interface ImageClickListner
    {
        fun onImageClick(position: Int)
    }
    inner class ChildViewHolder(private val childRecyclerItemBinding: ChildRawLayoutBinding) :
        RecyclerView.ViewHolder(childRecyclerItemBinding.root) {

        val image = childRecyclerItemBinding.childimageview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val binding = ChildRawLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ChildViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        var alldata = ImageList[position]
        Glide.with(holder.itemView.context)
            .load(ImageList[position].movieUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.image)
        Log.e("ImageList",ImageList.toString())

        holder.image.setOnClickListener {
            imageClickListner.onImageClick(position)
        }

    }

    override fun getItemCount(): Int {
        return ImageList.size
    }
}