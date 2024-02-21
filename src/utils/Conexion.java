package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    public  static Connection getConnection() {
        Connection conn = null;
        String host = "roundhouse.proxy.rlwy.net";
        String user = "root";
        String password = "BDd1g555hF2FcHe3A4Gcagb6bh566FHa";
        String port = "40166";
        String db = "railway";
        String dbURL = "jdbc:mysql://" + host + ":" + port + "/" + db;

        try {
            // Cargar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establecer la conexión
            conn = DriverManager.getConnection(dbURL, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }


}
