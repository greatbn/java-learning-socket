/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tool;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author SaPhi
 */
public class tool extends UnicastRemoteObject implements toolInterface{
    public tool() throws RemoteException{
        
    };
    @Override
    public ArrayList generate(int n) throws RemoteException {
        ArrayList<Integer> list = new ArrayList<>();
        if( n < 2)
            return list;
        nguyento nt = new nguyento();
        for(int i =2;i< n;i++){
            if(nt.check_nguyento(i)){
                list.add(i);
            }
        }        
        return list;
    }


    
    
}
