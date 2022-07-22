package com.crm.navigationcomponentwithrecycvlerviewdemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.crm.navigationcomponentwithrecycvlerviewdemo.databinding.FragmentMovieDescriptionBinding
import com.crm.navigationcomponentwithrecycvlerviewdemo.modal.MovieData


class MovieDescriptionFragment : Fragment() {

    private var _binding: FragmentMovieDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDescriptionBinding.inflate(inflater, container, false)
        var data = arguments?.getSerializable("data") as MovieData
        var image = data.movieUrl
        var title = data.movieTitle
        var des = data.movieDescription

//        var image : String = arguments?.getString("image")!!
//        var title : String = arguments?.getString("title")!!
//        var des : String = arguments?.getString("des")!!

        Glide.with(requireContext())
            .load(image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.detailImage)
        binding.movieTitle.text = title.toString()
        binding.movieDes.text = des.toString()
        return binding.root
    }
}