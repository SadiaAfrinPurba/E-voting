/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Database;

import java.sql.Connection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author afrin
 */
public class DbHandler {
    private static Connection conn = null;
    
    public static Connection getConnection() throws SQLException{
        if(conn != null) return conn;
        else{
            try{
               
                String driver="com.mysql.jdbc.Driver";
                String url="jdbc:mysql://localhost:3306/e_voting";
                //String url = "jdbc:mysql://localhost:3306/e_voting?zeroDateTimeBehavior=convertToNull";
                String user="root";
                String password="root";
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
                

            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
                
            } 
            return conn;
        }
    }
    
    
}
