/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author saphi
 */
public interface InterfacebinSearch extends Remote {

    public int binSearch(int a[],int searchNum) throws RemoteException;

    public int[] arrange(int a[]) throws RemoteException;
}
