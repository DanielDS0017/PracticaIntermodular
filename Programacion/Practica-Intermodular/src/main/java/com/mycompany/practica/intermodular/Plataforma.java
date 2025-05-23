

package com.mycompany.practica.intermodular;

import java.util.List;

import java.util.List;

public class Plataforma {
    private int idPlataforma;
    private String nombre;
    private List<Videojuego> videojuegos; // Relación 1:N

    public Plataforma(int idPlataforma, String nombre, List<Videojuego> videojuegos) {
        this.idPlataforma = idPlataforma;
        this.nombre = nombre;
        this.videojuegos = videojuegos;
    }

    public int getIdPlataforma() { return idPlataforma; }
    public String getNombre() { return nombre; }
    public List<Videojuego> getVideojuegos() { return videojuegos; }

    @Override
    public String toString() {
        return idPlataforma + ". " + nombre;
    }
}
