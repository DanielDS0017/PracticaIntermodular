

package com.mycompany.practica.intermodular;


public class Videojuego {
    private int idVideojuego;
    private String titulo;
    private Genero genero;           // Asociación con Genero
    private int idPlataforma;        // FK que indica a qué plataforma pertenece

    public Videojuego(int idVideojuego, String titulo, Genero genero, int idPlataforma) {
        this.idVideojuego = idVideojuego;
        this.titulo = titulo;
        this.genero = genero;
        this.idPlataforma = idPlataforma;
    }

    public int getIdVideojuego() { return idVideojuego; }
    public String getTitulo() { return titulo; }
    public Genero getGenero() { return genero; }
    public int getIdPlataforma() { return idPlataforma; }

    @Override
    public String toString() {
        return idVideojuego + ". " + titulo + " (" + genero.getNombre() + ")";
    }
}