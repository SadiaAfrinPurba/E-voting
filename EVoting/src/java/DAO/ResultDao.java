/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Candidate;
import Models.Result;
import Utils.DbHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ResultDao {
    
    private Connection conn;
    
    public ResultDao() throws SQLException{
        conn = DbHandler.getConnection();
    }
    
    public boolean countVote(int cID,int vote,List<Candidate> candidateList){
        
        boolean success=false;
        String candidateName = "";
        String electionName = "";
        for(Candidate candidate : candidateList){
            if(candidate.getCandidateID() == cID){
                candidateName = candidate.getCandidateName();
                electionName = candidate.getElectioName();
                break;
            }
            
        }
        
        try {
            PreparedStatement preparedStatement = conn.
                    prepareStatement("SELECT candidate_name,candidate_id FROM Candidate candidate_id=?");
   
            preparedStatement.setInt(1, cID);
        
            ResultSet rs = preparedStatement.executeQuery();

            String cNameFromDB = "";
            int cIDFromDB = 0;
            boolean alreadyExist = false;
            while (rs.next()) {
                
                cNameFromDB = rs.getString("candidate_name");
                cIDFromDB = rs.getInt("candidate_id");
            }
            if(cID == cIDFromDB && candidateName.equals(cNameFromDB.trim())){
                alreadyExist = true;
            }
            if(alreadyExist){
                 updateResult(cID,vote);
                 success = true;
            }
                
            else{
               addNewResult(cID,candidateName,electionName,vote);
               success = true;
            }
            
            
    }catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    
}
public void addNewResult(int cID,String candidateName,String electionName,int vote) throws SQLException{
        
         PreparedStatement preparedStatement = conn
                    .prepareStatement("INSERT INTO Result(election_name,candidate_name,candidate_id,result_vote) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, electionName);
            preparedStatement.setString(2, candidateName);
            preparedStatement.setInt(3, cID);
            preparedStatement.setInt(4, vote);
            preparedStatement.executeUpdate();
    }
    
    public void updateResult(int cID, int vote) throws SQLException{
            
            //to get the vote count of a candidate
            PreparedStatement preparedStatement = conn
                    .prepareStatement("SELECT result_vote FROM Result WHERE result_id=?");
             preparedStatement.setInt(1, cID);
             ResultSet rs = preparedStatement.executeQuery();
             int previousVote = rs.getInt("result_vote");
             previousVote = previousVote + vote;
             
             PreparedStatement UpdatePreparedStatement = conn
                    .prepareStatement("UPDATE Result set result_vote=?" +
                            "where candidate_id=?");
             
             UpdatePreparedStatement.setInt(1,previousVote);
             UpdatePreparedStatement.setInt(2,cID);
             previousVote = 0;
        
    }
    
     public List<Result> getAllResult() throws SQLException, IOException {
        List<Result> resultList = new ArrayList<Result>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Result");
            while (rs.next()) {
                Result result = new Result();
                result.setResultID(rs.getInt("result_id"));
                result.setCandidateName(rs.getString("candidate_name"));
                result.setCandidateID(rs.getInt("candidate_id"));
                result.setVoteCount(rs.getInt("result_vote"));
               
                result.setElectionName(rs.getString("election_name"));
                
             
                resultList.add(result);
                
           
          }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }
     
    
}
