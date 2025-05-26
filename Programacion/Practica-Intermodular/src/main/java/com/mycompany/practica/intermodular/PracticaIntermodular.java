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
        DataBaseManager BD = new DataBaseManager();

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ver plataformas");
            System.out.println("2. Ver videojuegos");
            System.out.println("3. Ver géneros");
            System.out.println("4. Abrir página web del proyecto");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // mostrar plataformas...
                    break;
                case 2:
                    // mostrar videojuegos...
                    break;
                case 3:
                    // mostrar géneros...
                    break;
                case 4:
                    abrirPaginaWeb(urlWeb);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
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

    

