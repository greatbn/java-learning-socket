/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tool;

/**
 *
 * @author SaPhi
 */
public class nguyento {
    public boolean check_nguyento(int n){
        if(n <= 1)
            return false;
        if(n == 2)
            return true;
        for(int i = 2; i< n ;i++){
            if(n%i == 0)
                return false;
        }
        return true;
        
    }
}
