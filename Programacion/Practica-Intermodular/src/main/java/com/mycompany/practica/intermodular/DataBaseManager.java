

package com.mycompany.practica.intermodular;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class DataBaseManager {
    
    private String url;
    private String user;
    private String password;
    private Connection conn;

    public DataBaseManager() {
        
        try {
            this.url = "jdbc:mysql://proyecto-intermodular.czpatkpp3lc2.us-east-1.rds.amazonaws.com/";
            this.user = "root";
            this.password = "rootMedac";
            conn= DriverManager.getConnection(url, user, password); //Se introducen los parametros para acceder a la base de datos
            System.out.println("Conexion establecida correctamente");
            
        }   catch(SQLException e){
            System.out.println("Imposible acceder a la base de datos" + e.getMessage());
        }
    }
    
    
}
