package com.example.tp01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        viewModel.getPalabraActual().observe(this, palabraActual -> {
            if (palabraActual != null) {
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra("palabraTraducida", palabraActual.getIngles());
                intent.putExtra("imagenResId", palabraActual.getImagenResId());
                startActivity(intent);
            } else {
                Toast.makeText(this, "Palabra no encontrada", Toast.LENGTH_SHORT).show();
            }
        });

        binding.botonTraducir.setOnClickListener(v -> {
            String palabra = binding.palabraEnEspanol.getText().toString();
            viewModel.buscarPalabra(palabra);

        });
    }
}