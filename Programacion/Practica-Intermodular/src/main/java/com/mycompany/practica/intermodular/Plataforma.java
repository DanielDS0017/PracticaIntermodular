

package com.mycompany.practica.intermodular;



public class Plataforma {
    private int idPlataforma;
    private String nombre;

    

    public Plataforma(int idPlataforma, String nombre) {
        this.idPlataforma = idPlataforma;
        this.nombre = nombre;
    }

    public int getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(int idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "idPlataforma=" + idPlataforma +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
