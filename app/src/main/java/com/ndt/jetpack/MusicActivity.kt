package com.ndt.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.ndt.jetpack.adapter.MusicPagerAdapter
import com.ndt.jetpack.databinding.ActivityMusicBinding

class MusicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMusicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabs = arrayOf("Song", "Album")
        binding.vpMusic.adapter = MusicPagerAdapter(this)
        TabLayoutMediator(binding.tabMusic, binding.vpMusic) { tab, index ->
            tab.text = tabs[index]
        }.attach()
    }
}