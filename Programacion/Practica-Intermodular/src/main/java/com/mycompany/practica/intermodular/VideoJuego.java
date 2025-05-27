

package com.mycompany.practica.intermodular;

import java.time.LocalDateTime;


public class Videojuego {
    private int idVideojuego;
    private String titulo;
    private int idPlataforma;
    private int idGenero;
    private LocalDateTime fechaCreacion;      

    public Videojuego(int idVideojuego, String titulo, int idPlataforma, int idGenero, LocalDateTime fechaCreacion) {
        this.idVideojuego = idVideojuego;
        this.titulo = titulo;
        this.idPlataforma = idPlataforma;
        this.idGenero = idGenero;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters
    public int getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(int idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(int idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "idVideojuego=" + idVideojuego +
                ", titulo='" + titulo + '\'' +
                ", idPlataforma=" + idPlataforma +
                ", idGenero=" + idGenero +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}