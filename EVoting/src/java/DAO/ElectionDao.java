/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Election;
import Utils.Database.DbHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author afrin
 */
public class ElectionDao {
    private Connection conn;
    
    public ElectionDao() throws SQLException{
        conn = DbHandler.getConnection();
    }
    
    public Election getAllElectionInfo(){
        
        Election election = new Election();
         try {
            PreparedStatement preparedStatement = conn.
                    prepareStatement("SELECT * FROM Election");
        
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                
                election.setElectionName(rs.getString("election_name"));
                election.setElectionStart(rs.getString("election_start"));
                election.setElectionEnd(rs.getString("election_start"));
                
            }
       
    }catch (SQLException e) {
            e.printStackTrace();
        }
         return election;
    
}
}
