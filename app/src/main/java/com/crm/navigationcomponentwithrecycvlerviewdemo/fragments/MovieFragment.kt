package com.crm.navigationcomponentwithrecycvlerviewdemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.crm.navigationcomponentwithrecycvlerviewdemo.R
import com.crm.navigationcomponentwithrecycvlerviewdemo.adapters.ViewPagerAdapter
import com.crm.navigationcomponentwithrecycvlerviewdemo.databinding.FragmentMovieBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MovieFragment : Fragment() {

    private var _binding:FragmentMovieBinding ?= null
    private val binding get() =_binding!!

    private val movieArray = arrayOf(
        "TV Shows",
        "New Release",
        "Kids",
        "Comedy",
        "Drama" ,
        "Sports" ,
        "Horror" ,
        "Thriller" ,
        "Popular Movies" ,
        "Documentory"

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater , R.layout.fragment_movie, container , false)
        var mytabs = binding.tabLayout
        var viewpager = binding.viewPager

        val adapter = ViewPagerAdapter(fragmentManager =childFragmentManager,lifecycle)
        viewpager.adapter = adapter

        mytabs.tabMode = TabLayout.MODE_SCROLLABLE
        mytabs.tabGravity = TabLayout.GRAVITY_FILL

        TabLayoutMediator(mytabs,viewpager,true, true){tab,position->
            tab.text = movieArray[position]
        }.attach()

        return binding.root
    }
}