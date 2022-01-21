package com.ndt.jetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.ndt.jetpack.base.BaseActivity;
import com.ndt.jetpack.databinding.ActivitySampleBinding;
import com.ndt.jetpack.viewmodel.SampleViewModel;

public class SampleActivity extends BaseActivity {

    private ActivitySampleBinding binding;
    private SampleViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySampleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(SampleViewModel.class);
        viewModel.getNumber().observe(this, interger -> {
            //update ui
            binding.tvNumber.setText(interger.toString());
        });
        binding.btnUp.setOnClickListener(v -> {
            viewModel.increaseNumber();
        });
    }
}