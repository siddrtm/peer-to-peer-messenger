/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontendfinal1;

/**
 *
 * @author siddharth
 */

import java.awt.Component;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFileChooser;

/**
 *
 * @author siddharth
 */
public class filereciever {
    ServerSocket server;
    Socket s;
    ObjectInputStream ois;
    InetAddress ip;
    int filesize=602238600;
    int bytesRead;
    int current = 0;
    serPatch sp ;
    filereciever(int port,String original) throws Exception {
        
        try {
             server = new ServerSocket(port);
             s = server.accept();
           /*  ois = new ObjectInputStream(s.getInputStream());
             Object o = ois.readObject();
                if(o instanceof serPatch) {
                    
                    serPatch p = (serPatch) o;
                    
                    fileToLines f = new fileToLines();
                    List result = DiffUtils.patch(f.filetolines(original), p.getPatch());
                try (PrintWriter writer = new PrintWriter( original + ".txt")) {
                    writer.print("");
                }
                    
                    String r = result.toString();
                try (PrintWriter out = new PrintWriter( original + ".txt")) {
                    out.println(r);
                }
             
             
             */
                 byte [] mybytearray  = new byte [filesize];
                InputStream is = s.getInputStream();
                
                
                
                
                
             // /*  
                Component a = new Component() {
                
                
                };
                a.setVisible(true);
                JFileChooser choose = new JFileChooser();
                     
                   
                   int choice;
                       choice = choose.showSaveDialog(a);

                   if (choice != JFileChooser.APPROVE_OPTION) 
                   {return;
                   }
                   

                    File chosenFile = choose.getSelectedFile();
                    System.out.print(chosenFile);
                
               //    */          
                
                
                    
                    
                    
                    
                
                FileOutputStream fos = new FileOutputStream(original);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                bytesRead = is.read(mybytearray,0,mybytearray.length);
                current = bytesRead;
                do {
                        bytesRead =
                           is.read(mybytearray, current, (mybytearray.length-current));
                        if(bytesRead >= 0) {
                        current += bytesRead;
                    }
                     } while(bytesRead > -1);

                     bos.write(mybytearray, 0 , current);
                     bos.flush();
                     long end = System.currentTimeMillis();
                     //System.out.println(end-start);
                     bos.close();
                     s.close();

             
             
                    
        }   
        catch (IOException E){
            
            System.out.println(E);
        }
        finally{
            server.close();
           // ois.close();
            s.close();
        }
        
    }
}
