/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.DbHandler;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author afrin
 */
public class CandidateDao {
        private Connection conn;
    
    public CandidateDao() throws SQLException{
        conn = DbHandler.getConnection();
    }
}
