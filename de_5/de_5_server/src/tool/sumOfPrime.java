/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tool;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author SaPhi
 */
public class sumOfPrime extends UnicastRemoteObject implements InterfacesumOfPrime{
    public sumOfPrime() throws RemoteException{};
    @Override
    public int sum(int n) throws RemoteException {
        int SUM = 0;
        for (int i = 0; i <= n; i++) {
            if(check(i))
                SUM+= i;
        }
            return SUM;
    }

    public static boolean check(int n) throws RemoteException {
        if(n < 0)
            return false;
        else if (n ==1)
            return false;
        else if (n == 2)
            return true;
        for (int i = 2; i < n; i++) {
            if(n%i == 0)
                return false;
        }                
        return true;
    }
    
}
