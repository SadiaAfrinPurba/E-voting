package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afrin
 */
public class SystemInterfaceImpl extends UnicastRemoteObject implements SystemInterface{
    private Connection connect = null;
    
    SystemInterfaceImpl() throws RemoteException{
        super();
    }

    @Override
    public boolean enter(String nId, String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean register(String nId, String name, String email, String phoneNo, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean login(String nId, String name, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Connection dbHandler() {
        //throw new UnsupportedOperationException("Not supported yet.");
         try {

            String dbName = "e_voting";
            String user = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost/" + dbName;

            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);

            System.out.println("Successfully Connected..");
          

        } catch (Exception e) {
            
        }
        return connect;
  
    }
    
}
