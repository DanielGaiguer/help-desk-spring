
package com.main.help_desk.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static final String url = "jdbc:mysql://localhost:3306/help_desk";
    public static final String user = "root";
    public static final String senha = "Daniboy2@";
    private static Connection conn = null;
    
    private Conexao(){
    }
    
    public static synchronized Connection conectar() {
        try {
            if(conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, senha);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
}
