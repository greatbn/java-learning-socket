/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SaPhi
 */
public class sender {

    public static void main(String[] args) {

        try {
            int MCPort = 9999;
            InetAddress MCAddress = InetAddress.getByName("224.0.0.2");
            byte[] sendData = new byte[1024];

            DatagramSocket DGSocket = new DatagramSocket();
            while (true) {
                System.out.print("Send data to multicast address 224.0.0.1: ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                sendData = br.readLine().getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,MCAddress,MCPort);
                DGSocket.send(sendPacket);
            }

        } catch (UnknownHostException ex) {
            Logger.getLogger(sender.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(sender.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
