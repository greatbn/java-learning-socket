/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author SaPhi
 */
public class server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 2000;
        // init 10 file
//        for (int i = 0; i < 10; i++) {
//            File file = new File("./share_file/file"+i+".txt");
//            try {
//                FileWriter fw= new FileWriter(file);
//                fw.write("Data file "+i);
//                fw.close();
//            } catch (IOException ex) {
//                Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        }            
        File folder = new File("./share_file");
        File[] listFile = folder.listFiles();
//        for (int i = 0; i < listFile.length; i++) {
//            if(listFile[i].isFile()){
//                System.out.println("Filename: "+listFile[i].getName());
//            }
//        }
        try {
            ServerSocket ss = new ServerSocket (port);
            System.out.println("Đang chạy tại: "+ss.getInetAddress().getHostAddress()+" và Cổng: "+ss.getLocalPort());
            while(true){
                Socket s = ss.accept();
                System.out.println("Client kết nối đến: "+s.getInetAddress().getHostAddress()+"Tại port: "+s.getPort());
                System.out.println("Gửi danh sách file đến cho client");
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(listFile);
                
                
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String filename = br.readLine();
                System.out.println("Client muốn download file: "+filename);
                File f = new File("./share_file/"+filename);
                BufferedReader readFile = new BufferedReader(new FileReader(f));
                String line;
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                while((line= readFile.readLine())!= null){                                    
                    bw.write(line+"\n");
                    bw.flush();                                         
                }
                
                System.out.println("Sent");
                bw.close();
                readFile.close();
                br.close();
                oos.close();
                s.close();                
            }
            
        } catch (IOException ex) {
            System.out.println("Lỗi rồi");
        }
    }
    
}
