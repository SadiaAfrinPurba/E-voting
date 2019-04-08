package RMI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.rmi.Remote;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afrin
 */
public interface SystemInterface extends Remote {
    
    //public Connection dbHandler();
    public boolean enter(String nId, String name);
    public boolean register(String nId, String name, String email, String phoneNo, String password);
    public boolean login(String nId,String name, String password);
    
}
