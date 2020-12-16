package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static String user = "root";
    public static String password = "";
    public static String ip = "localhost";
    public static String port = "3306";
    public static String name = "redis_ex";
    
    public static Connection getConnection() throws SQLException {      
        
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://" +
                ip + ":" + port + "/", user, password);
        
        conn.setCatalog(name);
        System.out.println("Conectado com o Banco de Dados!\n");
            
        return conn;
    }
    
}