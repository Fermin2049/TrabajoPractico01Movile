package com.example.tp01;

public class Palabra {
    private String espanol;
    private String ingles;
    private int imagenResId;

    public Palabra(String espanol, String ingles, int imagenResId) {
        this.espanol = espanol;
        this.ingles = ingles;
        this.imagenResId = imagenResId;
    }

    public String getEspanol() {
        return espanol;
    }

    public String getIngles() {
        return ingles;
    }

    public int getImagenResId() {
        return imagenResId;
    }
}
