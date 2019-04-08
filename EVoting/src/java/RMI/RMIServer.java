/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author afrin
 */
public class RMIServer {
    private static final int PORT = 5500;
    public static void main(String[] args) throws RemoteException{
        SystemInterfaceImpl skeleton = new SystemInterfaceImpl();
        Registry registry = LocateRegistry.createRegistry(PORT);
        registry.rebind("rmi://localhost:5500/Enter", registry);
        
    }
    
}
