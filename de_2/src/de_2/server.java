/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de_2;

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
    public static void main(String[] args) {
        int port =6969;
        try {
            ServerSocket serversocket = new ServerSocket(port);
            while(true){
                Socket socket = serversocket.accept();
                BufferedReader br = new BufferedReader (new InputStreamReader(socket.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String date = br.readLine();
                
                System.out.println(date);
                
                int month;
                int year;
                int days = 0;
                String[] data;
                data = date.split("/");
                month = Integer.parseInt(data[0]);
                year = Integer.parseInt(data[1]);
                switch(month){
                    case 1:
                    case 3:
                    case 5: 
                    case 7:
                    case 8: 
                    case 10: 
                    case 12:
                        days = 31;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        days = 30;
                        break;
                    case 2:
                    {
                        if(year%4 == 0)
                            days = 29;
                        else 
                            days =28;
                        break;
                    }
                     
                            
                     
                }
                
                
                bw.write(days+"\n");
                bw.flush();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
