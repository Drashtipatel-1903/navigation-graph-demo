package com.crm.navigationcomponentwithrecycvlerviewdemo.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.crm.navigationcomponentwithrecycvlerviewdemo.fragments.*

private const val NUM_TABS = 10


class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TvShowFragment()
            1 -> NewReleaseMovieFragment()
            2 -> KidsShowFragment()
            3 -> ComedyMovieFragment()
            4 -> DramaMovieFragment()
            5 -> SportsFragment()
            6 -> HorrorMovieFragment()
            7 -> ThrillerMovieFragment()
            8 -> PopularMovies()
            else -> DocumentoryMovieFragment()
        }
    }
}