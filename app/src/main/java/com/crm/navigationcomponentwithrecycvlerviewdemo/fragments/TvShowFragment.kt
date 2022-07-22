package com.crm.navigationcomponentwithrecycvlerviewdemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.crm.navigationcomponentwithrecycvlerviewdemo.R
import com.crm.navigationcomponentwithrecycvlerviewdemo.adapters.ChildAdapter
import com.crm.navigationcomponentwithrecycvlerviewdemo.adapters.ParentAdapter
import com.crm.navigationcomponentwithrecycvlerviewdemo.databinding.FragmentTvShowBinding
import com.crm.navigationcomponentwithrecycvlerviewdemo.modal.MovieData

class TvShowFragment : Fragment()  , ChildAdapter.ImageClickListner
{

    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding!!
    private var ImgUrl = ArrayList<MovieData>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTvShowBinding.inflate(inflater, container, false)

        val parentAdopter = ParentAdapter(ImgUrl , this)
        binding.movierecycler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.movierecycler.adapter = parentAdopter

        ImgUrl.add(MovieData("https://images.hindustantimes.com/rf/image_size_960x540/HT/p2/2017/10/26/Pictures/_c291b404-ba22-11e7-8fe3-8a4365deb777.jpg" , "Jab We Met" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))
        ImgUrl.add(MovieData("https://i.ytimg.com/vi/9tAuKWmfGfw/hqdefault.jpg" , "Kal Ho Na Ho" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))
        ImgUrl.add(MovieData("https://moviedash.com/wp-content/uploads/2020/04/Kabhi-Khushi-Kabhie-Gham-3-450x300.jpg" , "Kabhi Khushi Kabhi Gham" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))
        ImgUrl.add(MovieData("https://circle.youthop.com/wp-content/uploads/2021/07/3_Idiots.jpg" , "3 Idiots" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "))
        ImgUrl.add(MovieData("https://images.hungama.com/c/1/501/533/2561313/2561313_1280x800.jpg" , "Hum Apke Hai Koun" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))
        ImgUrl.add(MovieData("https://images.hindustantimes.com/img/2022/03/18/550x309/The_Kashmir_Files_1647606022504_1647606022704.jpg" , "The Kashmir Files" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))
        ImgUrl.add(MovieData("https://static.toiimg.com/photo/msid-91439350/91439350.jpg" , "Nadi Dosh" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))
        ImgUrl.add(MovieData("https://blog.instube.com/wp-content/uploads/2019/03/Chaal-Jeevi-Laiye-full-movie-0.jpg" , "Chaal Jivi Laie" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))
        ImgUrl.add(MovieData("https://c4.wallpaperflare.com/wallpaper/740/69/104/movies-hollywood-movies-wallpaper-preview.jpg" , "The Conjuring" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))
        ImgUrl.add(MovieData("https://images.cnbctv18.com/wp-content/uploads/2022/05/Bhool-Bhulaiyaa-2-1019x573.jpg" , "Bhool Bhulaiya" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))
        ImgUrl.add(MovieData("https://jiocinemaweb.cdn.jio.com/jioimages.cdn.jio.com/content/entry/dynamiccontent/thumbs/700/-/0/8/24/0_tr7zep8z_1531493317523_l_medium.jpg" , "Main Tera Hero" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))
        ImgUrl.add(MovieData("https://images-na.ssl-images-amazon.com/images/S/pv-target-images/d6f3befce23f9a83600ebb2e9c067986f8650e8fde6cd8ee68f88b3a6286c75c._RI_.jpg" , "Ajab Prem Ki Gajab Kahani" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))
        ImgUrl.add(MovieData("https://cdn.dnaindia.com/sites/default/files/styles/full/public/2018/10/05/739639-andhadhun.jpg" , "Andhadundh" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))
        ImgUrl.add(MovieData("https://static.toiimg.com/photo/msid-88412188/88412188.jpg" , "Welcome" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))
        ImgUrl.add(MovieData("https://images-na.ssl-images-amazon.com/images/S/pv-target-images/0aa373d1ed704c41ede1a6bc80056356f6c343c9f77d658acb656d02b91d4751._RI_.jpg" , "Tom & Jerry" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))


        return binding.root

    }

    override fun onImageClick(position: Int) {
        Toast.makeText(requireContext(), "position is : $position", Toast.LENGTH_SHORT).show()
        val fragment : MovieDescriptionFragment = MovieDescriptionFragment()
        val fragmentManager = parentFragment?.childFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()

        val bundle = Bundle()
        var data = ImgUrl[position]
        bundle.putSerializable("data" , data)


//        bundle.putString("image" , ImgUrl[position].movieUrl)
//        bundle.putString("title" , ImgUrl[position].movieTitle)
//        bundle.putString("des" , ImgUrl[position].movieDescription)

        fragment.arguments = bundle

        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.add(R.id.child_frame , fragment)
        fragmentTransaction?.commit()    }



}