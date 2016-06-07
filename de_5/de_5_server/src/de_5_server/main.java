/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de_5_server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import tool.sumOfPrime;

/**
 *
 * @author SaPhi
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 6969;
        try {
            Registry registry = LocateRegistry.createRegistry(port);
            sumOfPrime sumPrime = new sumOfPrime();
            registry.rebind("sum", sumPrime);
            
            
            
            
        } catch (RemoteException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
