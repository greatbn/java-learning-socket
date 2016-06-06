/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author SaPhi
 */
public class client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6969);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Connected  to " + socket.getInetAddress() + "on port: " + socket.getPort());
            int num1 = 0;
            int num2 = 0;
            boolean check = true;
            while (check) {
                System.out.print("Please input first number(integer): ");
                try{
                    num1 = Integer.parseInt(br.readLine());
                    System.out.print("Please input second number: ");
                    try{
                        num2 = Integer.parseInt(br.readLine());
                        check = false;                        
                    }catch(NumberFormatException e){
                        
                    }
                }   catch(NumberFormatException e){
                    
                }     
            }
            
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(num1+"\n");
            bw.flush();
            bw.write(num2+"\n");
            bw.flush();
            
            BufferedReader brS = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            int bscnn = Integer.parseInt(brS.readLine());
            System.out.println("Boi so chung nho nhat cua "+num1+" va "+num2+"la: "+bscnn);
            
            
            
        } catch (IOException ex) {
            System.out.println("Server loi");
        }
    }
}
