package com.ndt.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.ndt.jetpack.adapter.StudentAdapter
import com.ndt.jetpack.base.BaseActivity
import com.ndt.jetpack.databinding.ActivityBindingBinding
import com.ndt.jetpack.model.Student
import com.ndt.jetpack.viewmodel.BindingViewModel

class BindingActivity : BaseActivity() {

    private lateinit var binding: ActivityBindingBinding
    private val viewModel: BindingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vm = viewModel
        binding.lifecycleOwner = this

//        binding.btnLoad.setOnClickListener {
//            Glide.with(this)
//                .load(binding.edtLink.text.toString())
//                .into(binding.imgAvatar)
//        }
        val students = arrayListOf(
            Student(1, "Tu1", "HN"),
            Student(2, "Tu2", "HN"),
            Student(3, "Tu3", "HN"),
            Student(4, "Tu4", "HN"),
        )
        val adapter = StudentAdapter(students)
        binding.rvData.adapter = adapter
        binding.rvData.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}