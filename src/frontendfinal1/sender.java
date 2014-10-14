/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package frontendfinal1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


import difflib.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sender implements Runnable
{
    Socket s;
    ObjectOutputStream oos;
    InetAddress ip;
    int port;
    String original;
   // sender(String ip,int port,String original,String revised) throws Exception
    
        sender(String ip,int port,String original) throws Exception 
        {
        	this.ip = InetAddress.getByName(ip);
        	this.port = port;
                this.original = original;
        }
        
    @Override
        public void run(){
        
         
     //   calculatediff diff = new calculatediff(original,revised);
        try
        {           s = new Socket(this.ip,port);
        	//	oos = new ObjectOutputStream(s.getOutputStream()); 
        	//	Patch pp = diff.getpatch();
        	//	serPatch ser = new serPatch(pp);
        		//Object o = pp;
        	/*	 FileOutputStream fileOut =  new FileOutputStream("C:/Users/Lenovo/workspace/P2P/src/patch.txt");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(o);
                    out.close();
                    fileOut.close();*/
                    File myFile = new File (original);
                    byte [] mybytearray  = new byte [(int)myFile.length()];
                    FileInputStream fis = new FileInputStream(myFile);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    bis.read(mybytearray,0,mybytearray.length);
                    OutputStream os =  s.getOutputStream();
                    System.out.println("Sending...");
                    os.write(mybytearray,0,mybytearray.length);
                    os.flush();
                   s.close();
        		//oos.writeObject(ser);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally
        {
                try {
                    // oos.close();
                          
                      s.close();
                      System.out.println("Done");
                } catch (IOException ex) {
                    Logger.getLogger(sender.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        
        }
}
