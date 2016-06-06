/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de_3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SaPhi
 */
public class server {

    public static void main(String[] args) {
        int port = 6969;
        try {
            DatagramSocket socket = new DatagramSocket(port);

            while (true) {
                byte[] receiveData = new byte[1024];
                byte[] sendData = new byte[1024];

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                DatagramPacket sendPacket;

                socket.receive(receivePacket);

                String data = new String(receivePacket.getData()).trim();
                String[] date = data.split("/");
                System.out.println(date[0]);
                System.out.println(date[1]);
                int month = Integer.parseInt(date[0]);
                int year = Integer.parseInt(date[1]);
                int days = 0;
                switch (month) {
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
                    case 2: {
                        if (year % 4 == 0) {
                            days = 29;
                        } else {
                            days = 28;
                        }
                        break;
                    }

                }
                String result = days +"";
                sendData = result.getBytes();
                sendPacket  = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
                
                
                
                
                
                

            }

        } catch (SocketException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
