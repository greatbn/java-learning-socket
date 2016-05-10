/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SaPhi
 */
public class receiver {

    /**
     * @param args the command line arguments
     */
   public String getDate(){
        try {
            InetAddress MCAddr = InetAddress.getByName("224.0.0.2");
            int MCPort = 9999;
            MulticastSocket MCSocket = new MulticastSocket(MCPort);
            System.out.println("Receiver is running at "+MCSocket.getLocalAddress()+"Port: "+MCSocket.getLocalPort());
            
            MCSocket.joinGroup(MCAddr);
            System.out.println("Joinning group: "+MCAddr.toString());
            System.out.println("Waiting for data..... ");
            while(true){
                 DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
                MCSocket.receive(receivePacket);
                String data = new String(receivePacket.getData());
                System.out.println("Received: "+data);
                return data;
            }
//           MCSocket.leaveGroup(MCAddr);
//           MCSocket.close();
            
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(receiver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;

    }

}
