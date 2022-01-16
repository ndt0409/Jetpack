package com.ndt.jetpack.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ndt.jetpack.ui.AlbumFragment
import com.ndt.jetpack.ui.SongFragment

class MusicPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SongFragment()
            1 -> AlbumFragment()
            else -> throw IllegalArgumentException("Unknown fragment")
        }
    }
}