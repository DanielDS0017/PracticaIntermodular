/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica.intermodular;

import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

public class PracticaIntermodular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        String urlWeb = "http://ec2-44-203-198-69.compute-1.amazonaws.com/pagina_intermodular/index.html"; 
        DataBaseManager DB = new DataBaseManager(); //Abrir base de datos
        SistemaInformativo SI=new SistemaInformativo(); //Cargar el sistema informativo
        
        //Sirve para cargar los datos desde la base de datos
        DB.mostrarDatos(SI);
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ver plataformas");
            System.out.println("2. Ver videojuegos");
            System.out.println("3. Ver generos");
            System.out.println("4. Abrir página web del proyecto");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- LISTA DE PLATAFORMAS ---");
                    if (SI.getPlataformas().isEmpty()) {
                        System.out.println("No hay plataformas disponibles.");
                    } else {
                        for (Plataforma p : SI.getPlataformas()) {
                            System.out.println("ID: " + p.getIdPlataforma() + " - Nombre: " + p.getNombre());
                        }
                    }
                    sc.nextLine();
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE VIDEOJUEGOS ---");
                    if (SI.getVideojuegos().isEmpty()) {
                        System.out.println("No hay videojuegos disponibles.");
                    } else {
                        for (Videojuego v : SI.getVideojuegos()) {
                            System.out.println("ID: " + v.getIdVideojuego() 
                                + " - Título: " + v.getTitulo() 
                                + " - Plataforma ID: " + v.getIdPlataforma() 
                                + " - Género ID: " + v.getIdGenero() 
                                + " - Fecha creación: " + v.getFechaCreacion());
                        }
                    }
                    sc.nextLine();
                    break;

                case 3:
                    System.out.println("\n--- LISTA DE GÉNEROS ---");
                    if (SI.getGeneros().isEmpty()) {
                        System.out.println("No hay géneros disponibles.");
                    } else {
                        for (Genero g : SI.getGeneros()) {
                            System.out.println("ID: " + g.getIdGenero() + " - Nombre: " + g.getNombre());
                        }
                    }
                    sc.nextLine();
                    break;
                case 4:
                    abrirPaginaWeb(urlWeb);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    DB.cerrarConexion();
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);

        sc.close();
    }

    public static void abrirPaginaWeb(String url) { //Desktop sirve para abrir el navegador y URI para integrar urls
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            System.out.println("Error al abrir la página web: " + e.getMessage());
        }
    }
}

    

