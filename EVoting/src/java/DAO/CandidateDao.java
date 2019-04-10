/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Candidate;
import Utils.DbHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 *
 * @author afrin
 */
public class CandidateDao {
        private Connection conn;
    
    public CandidateDao() throws SQLException{
        conn = DbHandler.getConnection();
    }
     public List<Candidate> getAllUsers() throws SQLException, IOException {
        List<Candidate> candidateList = new ArrayList<Candidate>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Candidate");
            while (rs.next()) {
                Candidate candidate = new Candidate();
                candidate.setCandidateID(rs.getInt("candidate_id"));
                candidate.setCandidateName(rs.getString("candidate_name"));
                candidate.setCandidateEducation(rs.getString("candidate_education"));
                candidate.setCandidateHometown(rs.getString("candidate_hometown"));
                candidate.setCandidateExp(rs.getString("candidate_experience"));
                candidate.setCandidateAgenda(rs.getString("candidate_agenda"));
                candidate.setElectioName(rs.getString("election_name"));
                
                //For image retrive from database
                Blob blob = rs.getBlob("candidate_image");
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);   
                }
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
 
        
                candidate.setBase64Image(base64Image);
                candidateList.add(candidate);
                
           
          }
            System.out.println("Candidate object "+ candidateList.get(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return candidateList;
    }
     


    
}
