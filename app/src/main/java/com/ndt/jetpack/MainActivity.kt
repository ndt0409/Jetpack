package com.ndt.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ndt.jetpack.base.BaseActivity
import com.ndt.jetpack.databinding.ActivityMainBinding
import com.ndt.jetpack.viewmodel.MainViewModel

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.number.observe(this, {
            //update ui
            binding.tvNumber.text = it.toString()
        })
        binding.btnUp.setOnClickListener {
            viewModel.increaseNumber()
        }
    }
}