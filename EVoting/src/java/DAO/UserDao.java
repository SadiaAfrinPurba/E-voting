/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.User;
import Utils.DbHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author afrin
 */
public class UserDao {
    
    private Connection conn;
    
    public UserDao() throws SQLException{
        conn = DbHandler.getConnection();
    }
    
    //For registration
    
    public boolean registerUser(User user){
        boolean success = false;
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("INSERT INTO User(user_name,user_phoneNo,user_email,user_password) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhoneNo());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
            
            success = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return success;
    }
    
    public boolean loginUser(String username, String password){
        boolean success = false;
        User user = new User();
        try{
            
            PreparedStatement preparedStatement = conn
                    .prepareStatement("SELECT user_name,user_password FROM User WHERE user_name=?");
             preparedStatement.setString(1,username);
             ResultSet rs = preparedStatement.executeQuery();
             String userName = "",userPassword = "";
             if (rs.next()) {
                 userName = rs.getString("user_name");
                 userPassword = rs.getString("user_password");
             }
             if((userName.equals(username.trim())) && (userPassword.equals(password.trim()))){
                 success = true;
             }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        return success;
    }
    
    public boolean forgetPassword(String username, String password){
        boolean success = false;
        User user = new User();
        try{
            
            PreparedStatement preparedStatement = conn
                    .prepareStatement("SELECT user_password FROM User WHERE user_id=?");
             preparedStatement.setString(1,password);
             preparedStatement.setString(2,username);
             preparedStatement.executeUpdate();
             success = true;
             
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        return success;
        
    }
    
}
