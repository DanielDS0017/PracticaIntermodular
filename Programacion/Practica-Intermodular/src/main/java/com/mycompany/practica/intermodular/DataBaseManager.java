

package com.mycompany.practica.intermodular;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Scanner;
public class DataBaseManager {
    
    private String url;
    private String user;
    private String password;
    private Connection conn;

    public DataBaseManager() {
        
        try {
            this.url = "jdbc:mysql://proyecto-intermodular.czpatkpp3lc2.us-east-1.rds.amazonaws.com/VideojuegosDB";
            this.user = "root";
            this.password = "rootMedac";
            conn= DriverManager.getConnection(url, user, password); //Se introducen los parametros para acceder a la base de datos
            System.out.println("Conexion establecida correctamente");
            
        }   catch(SQLException e){
            System.out.println("Imposible acceder a la base de datos" + e.getMessage());
        }
    }
    //Metodo para cerrar conexion
    public void cerrarConexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    // Método  para ejecutar un SELECT
    public ResultSet ejecutarConsulta(String sql) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
            return null;
        }
    }
    
    // Método para ejecutar una actualización (INSERT, UPDATE, DELETE)
    public int ejecutarActualizacion(String sql) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la actualización: " + e.getMessage());
            return -1;
        }
    }
    
    // Método para ejecutar consultas personalizadas 
    public ResultSet ejecutarConsultaPreparada(String sql, String parametro) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, parametro);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error en consulta preparada: " + e.getMessage());
            return null;
        }
    }
    
    public void mostrarDatos(SistemaInformativo sistema){
        try {
        // Cargar plataformas
        ResultSet rsPlataformas = ejecutarConsulta("SELECT * FROM Plataforma");
        while (rsPlataformas != null && rsPlataformas.next()) {
            Plataforma p = new Plataforma(
                rsPlataformas.getInt("id_plataforma"),
                rsPlataformas.getString("nombre")
            );
            sistema.agregarPlataforma(p);
        }

        // Cargar géneros
        ResultSet rsGeneros = ejecutarConsulta("SELECT * FROM Genero");
        while (rsGeneros != null && rsGeneros.next()) {
            Genero g = new Genero(
                rsGeneros.getInt("id_genero"),
                rsGeneros.getString("nombre")
            );
            sistema.agregarGenero(g);
        }

        // Cargar videojuegos
        ResultSet rsVideojuegos = ejecutarConsulta("SELECT * FROM Videojuego");
        while (rsVideojuegos != null && rsVideojuegos.next()) {
            int idPlataforma = rsVideojuegos.getInt("id_plataforma");
            int idGenero = rsVideojuegos.getInt("id_genero");

            Plataforma plataforma = sistema.buscarPlataformaPorId(idPlataforma);
            Genero genero = sistema.buscarGeneroPorId(idGenero);

            Timestamp timestamp = rsVideojuegos.getTimestamp("fecha_creacion");
            LocalDateTime fecha = (timestamp != null)
                    ? timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                    : null;

            Videojuego videojuego = new Videojuego(
                rsVideojuegos.getInt("id_videojuego"),
                rsVideojuegos.getString("titulo"),
                idPlataforma,
                idGenero,
                fecha
            );
            sistema.agregarVideojuego(videojuego);
        }

    } catch (SQLException e) {
        System.out.println("Error al cargar datos desde la base de datos: " + e.getMessage());
    }
    }
}
