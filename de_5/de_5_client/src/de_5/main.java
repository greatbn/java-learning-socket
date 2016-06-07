/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import tool.InterfacesumOfPrime;

/**
 *
 * @author SaPhi
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Registry registry = LocateRegistry.getRegistry("localhost", 6969);
            InterfacesumOfPrime sumPrime = (InterfacesumOfPrime) registry.lookup("sum");
            System.out.println("Connected to server");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            boolean check = true;
            int num = 0;
            while(check)
            try{
                System.out.print("Nhap vao mot so: ");
                num = Integer.parseInt(br.readLine());
                check = false;
            }catch (NumberFormatException e){
                System.out.println("Nhap vao loi");
            }   catch (IOException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            System.out.println("Tong: "+sumPrime.sum(num));
            
        } catch (RemoteException ex) {
            System.out.println("Server fail");
        } catch (NotBoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
