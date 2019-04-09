/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Voter;
import Utils.DbHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author afrin
 */
public class VoterDao {
       private Connection conn;
    
    public VoterDao() throws SQLException{
        conn = DbHandler.getConnection();
    }
    
    public  List<String> getSecurityQues(int voterId,String name) {
        List<String> query = new ArrayList<String>();
        Voter voter = new Voter();
        try {
            PreparedStatement preparedStatement = conn.
                    prepareStatement("SELECT voter_sQuestion,voter_sAnswer FROM Voter WHERE voter_nid=?");
            preparedStatement.setInt(1, voterId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                
                voter.setVoterSecurityQues(rs.getString("voter_sQuestion"));
                voter.setVoterSecurityAns(rs.getString("voter_sAnswer"));
                System.out.println("Voter question " + rs.getString("voter_sAnswer"));
                
            }
            query.add(voter.getVoterSecurityQues());
            query.add(voter.getVoterSecurityAns());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }
    
}
