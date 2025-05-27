

package com.mycompany.practica.intermodular;


import java.util.ArrayList;
import java.util.List;

public class SistemaInformativo {

    private List<Videojuego> videojuegos;
    private List<Plataforma> plataformas;
    private List<Genero> generos;

    public SistemaInformativo() {
        this.videojuegos = new ArrayList<>();
        this.plataformas = new ArrayList<>();
        this.generos = new ArrayList<>();
    }

    // Métodos para agregar datos
    public void agregarVideojuego(Videojuego videojuego) {
        videojuegos.add(videojuego);
    }

    public void agregarPlataforma(Plataforma plataforma) {
        plataformas.add(plataforma);
    }

    public void agregarGenero(Genero genero) {
        generos.add(genero);
    }

    // Métodos de obtención
    public List<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public List<Plataforma> getPlataformas() {
        return plataformas;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    // Métodos de búsqueda simples
    public Plataforma buscarPlataformaPorId(int id) {
        for (Plataforma p : plataformas) {
            if (p.getIdPlataforma() == id) {
                return p;
            }
        }
        return null;
    }

    public Genero buscarGeneroPorId(int id) {
        for (Genero g : generos) {
            if (g.getIdGenero() == id) {
                return g;
            }
        }
        return null;
    }

    public Videojuego buscarVideojuegoPorId(int id) {
        for (Videojuego v : videojuegos) {
            if (v.getIdVideojuego() == id) {
                return v;
            }
        }
        return null;
    }

    // Método para imprimir todo el contenido
    public void mostrarInformacion() {
        System.out.println("=== Plataformas ===");
        for (Plataforma p : plataformas) {
            System.out.println(p);
        }

        System.out.println("\n=== Géneros ===");
        for (Genero g : generos) {
            System.out.println(g);
        }

        System.out.println("\n=== Videojuegos ===");
        for (Videojuego v : videojuegos) {
            System.out.println(v);
        }
    }
}
