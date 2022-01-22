package com.ndt.jetpack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ndt.jetpack.databinding.ItemStudentBinding
import com.ndt.jetpack.model.Student

class StudentAdapter(private val students: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student){
            binding.s=student
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ViewHolder {
        return ViewHolder(
            ItemStudentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount(): Int = students.size
}