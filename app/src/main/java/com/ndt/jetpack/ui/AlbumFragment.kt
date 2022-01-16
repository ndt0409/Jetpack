package com.ndt.jetpack.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ndt.jetpack.databinding.FragmentAlbumBinding
import com.ndt.jetpack.viewmodel.MusicViewModel

class AlbumFragment : Fragment() {
    private lateinit var viewModel: MusicViewModel
    private lateinit var binding: FragmentAlbumBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MusicViewModel::class.java)
        //viewModel = ViewModelProvider(requireActivity()).get(MusicViewModel::class.java) //dung chung context cua music viewmodel
        binding.btnUp.setOnClickListener {
            viewModel.increaseNumber()
        }
        viewModel.number.observe(viewLifecycleOwner, {
            binding.tvNumber.text = it.toString()
        })
        return binding.root
    }
}