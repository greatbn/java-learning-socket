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
import java.net.Socket;

/**
 *
 * @author SaPhi
 */
public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket ("localhost",6969);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader brS = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            System.out.println("Connected to server");
            String date =null;
            boolean check = true;
            int month = 0;
            int year = 0;
            String[] data;
            while(check){
                 System.out.print("Please input month and yeader (in form mm/yyyy): ");
                 date  = br.readLine();
                 data = date.split("/");
                 if(data.length != 2)
                     continue;
                 else{
                     try{
                         month = Integer.parseInt(data[0]);
                         year = Integer.parseInt(data[1]);
                         
                         if(month <= 12 && month >= 1)
                         {
                            check = false;                            
                         }else{
                             System.out.println("Nhap loi");
                             continue;
                         }
                         
                     }catch (NumberFormatException e){
                         System.out.println("Nhap lai");
                         continue;
                     }
                 }
                 
            }
            bw.write(date+"\n");
            bw.flush();
            
            String rec = brS.readLine();
            System.out.println("Thang "+month + " nam "+year+" co "+rec+" ngay ");
            
            
        } catch (IOException ex) {
            System.out.println("Server loi");
        }
        
    }
}
