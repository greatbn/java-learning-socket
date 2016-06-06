/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author saphi
 */
public class BinSearch extends UnicastRemoteObject implements InterfacebinSearch {
    public BinSearch() throws RemoteException{};
    @Override
    public int binSearch(int[] a, int searchNum) throws RemoteException {
        int low = 0;
        int hi = a.length - 1;
        while (low <= hi) {
            int mid = low + (hi - low)/ 2;
            
            if (searchNum < a[mid]) {
                hi = mid - 1;
            } else if (searchNum > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Override
    public int[] arrange(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i] > a[j])
                {
                    int temp;
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

}
