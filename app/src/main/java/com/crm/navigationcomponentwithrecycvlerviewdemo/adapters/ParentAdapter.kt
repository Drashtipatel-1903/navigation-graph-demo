package com.crm.navigationcomponentwithrecycvlerviewdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crm.navigationcomponentwithrecycvlerviewdemo.databinding.MainRawLayoutBinding
import com.crm.navigationcomponentwithrecycvlerviewdemo.modal.MovieData

class ParentAdapter(private val ImageList:ArrayList<MovieData> ,
                   private val imageClickListner: ChildAdapter.ImageClickListner) :
    RecyclerView.Adapter<ParentAdapter.MyParentClass>()
{
    inner class MyParentClass(recyclerItemLayoutBinding: MainRawLayoutBinding) :
        RecyclerView.ViewHolder(recyclerItemLayoutBinding.root) {
        val childRecyler = recyclerItemLayoutBinding.childRecyclerView
        val parentCardLayout = recyclerItemLayoutBinding.reyclerItemCard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyParentClass {
        val binding = MainRawLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyParentClass(binding)
    }

    override fun onBindViewHolder(holder: MyParentClass, position: Int) {
        holder.childRecyler.layoutManager = LinearLayoutManager(holder.itemView.context,LinearLayoutManager.HORIZONTAL,false)
        val childAdapter = ChildAdapter(ImageList , imageClickListner)
        holder.childRecyler.adapter = childAdapter
    }

    override fun getItemCount(): Int {
        return 20
    }


}