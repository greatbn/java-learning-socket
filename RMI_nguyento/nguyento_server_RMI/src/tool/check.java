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
public class check {
    public static void main(String[] args) {
        nguyento nt = new nguyento();
        if(nt.check_nguyento(5)){
            System.out.println("nguyen to");
        }
        else{
            System.out.println("khong la nguyen to");
        }
    }
}
