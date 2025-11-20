/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorigudang.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import inventorigudang.gudang.ReadDbData;
/**
 *
 * @author ASUS
 */
public class DBConnection {
    private static final String URL;
    private static final String USER;
    private static final String PASS;
    
    private static Connection conn;
    static {
        ReadDbData reader = new ReadDbData(); 
        
        URL = reader.getProperty("DB_URL");
        USER = reader.getProperty("DB_USER");
        PASS = reader.getProperty("DB_PASS");
        
        conn = null;
    }
    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
