package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    public DatabaseConfig(){

    }
    public Connection getConnection() {
        Connection conn = null;
        try {
            //charger le pilote
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/crud", "root", "87467942");
            System.out.println("connected");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
        return conn;
    }
}
