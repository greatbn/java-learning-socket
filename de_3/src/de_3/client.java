/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.xml.crypto.Data;

/**
 *
 * @author SaPhi
 */
public class client {
    public static void main(String[] args) {
        try {
            
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            
            
            
            DatagramSocket socket = new DatagramSocket();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            DatagramPacket sendPacket;
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
           
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
            
            
            sendData = date.getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("localhost"), 6969);
            socket.send(sendPacket);
            
            socket.receive(receivePacket);
            
            String result = new String(receivePacket.getData());
            
            System.out.println("Thang "+month + " nam "+year+" co "+result+" ngay ");
            
            
        } catch (IOException ex) {
            System.out.println("Server loi");
        }
    }
}
