/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tool;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author SaPhi
 */
public interface InterfacesumOfPrime extends Remote{
    public int sum(int n) throws RemoteException;
}
