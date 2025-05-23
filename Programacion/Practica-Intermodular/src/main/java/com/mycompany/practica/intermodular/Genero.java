

package com.mycompany.practica.intermodular;


public class Genero {
    private int idGenero;
    private String nombre;

    public Genero(int idGenero, String nombre) {
        this.idGenero = idGenero;
        this.nombre = nombre;
    }

    public int getIdGenero() { return idGenero; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return idGenero + ". " + nombre;
    }
}
