package com.example.tp01;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SecondViewModel extends ViewModel {
    private final MutableLiveData<String> palabraTraducida = new MutableLiveData<>();

    public LiveData<String> getPalabraTraducida() {
        return palabraTraducida;
    }

    public void setPalabraTraducida(String palabra) {
        palabraTraducida.setValue(palabra);
    }
}
