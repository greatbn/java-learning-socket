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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SaPhi
 */
public class server {
    
    
    public static int uscln(int a,int b){
        if(a == 0 || b == 0)
            return a+b;
        while(a != b){
            if(a>b)
                a = a-b;
            else 
                b = b-a;
        }
        return a;
    }
    public static void main(String[] args) {
        int port = 6969;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            
            while(true){
                Socket socket = serverSocket.accept();
                
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String num1 = br.readLine();
                String num2 = br.readLine();
                int n1 = Integer.parseInt(num1);
                int n2 = Integer.parseInt(num2);
                
                //System.out.println(n1);
                
                int bscnn = n1/uscln(n1, n2)*n2;
                
                //System.out.println(n2);
                //System.out.println(bscnn);
                bw.write(bscnn+"\n");
                bw.flush();
                
                
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
