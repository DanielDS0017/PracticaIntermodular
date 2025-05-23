

package com.mycompany.practica.intermodular;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaInformativo { //Clase contenedor de informacion 
    private List<Plataforma> plataformas;
    private List<Genero> generos;

    public SistemaInformativo(List<Plataforma> plataformas, List<Genero> generos) {
        this.plataformas = plataformas;
        this.generos = generos;
    }

    public List<Plataforma> getPlataformas() {
        return plataformas;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public List<Videojuego> getTodosLosVideojuegos() {
        List<Videojuego> todos = new ArrayList<>();
        for (Plataforma plataforma : plataformas) {
            todos.addAll(plataforma.getVideojuegos());
        }
        return todos;
    }

    public List<Videojuego> getVideojuegosPorGenero(int idGenero) {
        return getTodosLosVideojuegos().stream()
                .filter(v -> v.getGenero().getIdGenero() == idGenero)
                .collect(Collectors.toList());
    }

    public Plataforma getPlataformaPorId(int id) {
        for (Plataforma p : plataformas) {
            if (p.getIdPlataforma() == id) return p;
        }
        return null;
    }

    public Genero getGeneroPorId(int id) {
        for (Genero g : generos) {
            if (g.getIdGenero() == id) return g;
        }
        return null;
    }
}
