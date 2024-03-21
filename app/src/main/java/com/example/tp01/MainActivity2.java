package com.example.tp01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp01.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    private SecondViewModel viewModel;
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SecondViewModel.class);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String traducida = intent.getStringExtra("palabraTraducida");
        int imagenResId = intent.getIntExtra("imagenResId", 0); // Usar un valor por defecto que sepas que no existe

        viewModel.setPalabraTraducida(traducida);

        if (imagenResId != 0) {
            binding.imagen.setImageResource(imagenResId);
        } else {
            binding.imagen.setVisibility(View.GONE);
        }

        viewModel.getPalabraTraducida().observe(this, palabra -> {
            binding.palabraTraducida.setText(palabra);
        });
    }
}