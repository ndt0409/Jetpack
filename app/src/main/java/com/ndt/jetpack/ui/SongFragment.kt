package com.ndt.jetpack.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.ndt.jetpack.MainActivity
import com.ndt.jetpack.databinding.FragmentSongBinding
import com.ndt.jetpack.viewmodel.MusicViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.launch

class SongFragment : Fragment() {
    private lateinit var binding: FragmentSongBinding

    //private lateinit var viewModel: MusicViewModel
    //private val viewModel by viewModels<MusicViewModel>()       // No sharing data
    private val viewModel by activityViewModels<MusicViewModel>() //sharing data
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongBinding.inflate(layoutInflater)
        //viewModel = ViewModelProvider(this).get(MusicViewModel::class.java)
        //viewModel = ViewModelProvider(requireActivity()).get(MusicViewModel::class.java) //dung chung context cua music viewmodel
        viewModel.number.observe(viewLifecycleOwner, {
            binding.tvNumber.text = it.toString()
        })
        binding.btnUp.setOnClickListener {
//            viewModel.increaseNumber()
//            viewModel.showToast()
            //viewModel.startActivity()
            viewModel.showToastChannel()
        }
        viewModel.needToast.observe(viewLifecycleOwner, {
            if (it) {
                //  Toast.makeText(requireContext(), "New toast", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.nextActivity.observe(viewLifecycleOwner, {
            it.getContentIfNotHandled()?.let {
                val intent = Intent(requireActivity(), MainActivity::class.java)
                startActivity(intent)
            }
        })

        lifecycleScope.launch {
            viewModel.showToastChannel.collect {
                if (it) {
                    Toast.makeText(requireContext(), "New Toast", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding.root
    }
}