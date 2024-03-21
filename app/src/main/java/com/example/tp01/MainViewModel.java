package com.example.tp01;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<Palabra> palabraActual = new MutableLiveData<>();
    private static final Palabra[] diccionario = new Palabra[]{

            new Palabra("gato", "cat", R.drawable.gato),
            new Palabra("perro", "dog", R.drawable.perro),
            new Palabra("auto", "car", R.drawable.auto),
            new Palabra("caminar", "walk", R.drawable.caminar),
            new Palabra("pelado", "bare", R.drawable.pelado),
            new Palabra("pelota", "ball", R.drawable.pelota),

    };

    public LiveData<Palabra> getPalabraActual() {
        return palabraActual;
    }

    public void buscarPalabra(String palabraEnEspanol) {
        for (Palabra palabra : diccionario) {
            if (palabra.getEspanol().equalsIgnoreCase(palabraEnEspanol)) {
                palabraActual.setValue(palabra);
                return;
            }
        }
        palabraActual.setValue(null);
    }
}
