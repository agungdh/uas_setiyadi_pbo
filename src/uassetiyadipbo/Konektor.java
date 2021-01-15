/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uassetiyadipbo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author asus
 */
public class Konektor {
    static final String DB = "perpustakaan";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn = null;
    
    public static Connection init() {
       if (conn != null) return conn;
       String database = DB;
       String Username = USER;
       String password = PASS;
       return init(database, Username, password);
    }
    
    private static Connection init(String databaseName, String UserName, String password) {
       try {
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?user=" + UserName + "&password=" + password);
       } catch (Exception e) {
          e.printStackTrace();
       }
       return conn;
    }
}
