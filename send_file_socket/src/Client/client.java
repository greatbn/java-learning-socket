/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SaPhi
 */
public class client {

    public static void main(String[] args) {
        try {
            /// ket noi den server
            Socket s = new Socket("localhost", 2000);

            /// nhan danh sach cac file tren server publish
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            File[] listFile = null;
            try {
                listFile = (File[]) ois.readObject();
                System.out.println("Danh sách file từ server gửi về ");
                for (int i = 0; i < listFile.length; i++) {

                    System.out.println("filename: " + listFile[i].getName());
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            }

            /// nhap ten file muon download
            Boolean check_filename = false;
            String filename = null;
            while (!check_filename) {
                System.out.print("Nhập tên file muốn download sau đó nhấn enter: ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                filename = br.readLine();

                for (int i = 0; i < listFile.length; i++) {
                    if (filename.equals(listFile[i].getName())) {
                        check_filename = true;
                        System.out.println("Đang download file: " + filename);
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                        
                        // gui ten file len server
                        
                        bw.write(filename + "\n");
                        bw.flush();
                        
                        BufferedReader br_server = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        // tao folder download de luu
                        
                        File folder = new File("./download");
                        if(!folder.exists()){
                            if(folder.mkdir()){
                                System.out.println("Chưa có thư mục download đang tạo.");
                            }
                        }
                        
                        File file = new File("./download/"+filename);
                        //FileWriter fw = new FileWriter(file);
                        BufferedWriter bw_file = new BufferedWriter(new FileWriter(file));
                        String line;
                        
                        while((line = br_server.readLine()) != null){
                           bw_file.write(line);
                           bw_file.newLine();
                        }
                        System.out.println("Downloaded");
                        bw_file.close();
                        br_server.close();
                        br.close();
                        s.close();
                        
                        break;
                    }
                }
               if(check_filename)
                   break;
                System.out.println("Nhập lại");
            }

        } catch (IOException ex) {
            System.out.println("Server bị lỗi rồi nhé");
        }

    }
}
