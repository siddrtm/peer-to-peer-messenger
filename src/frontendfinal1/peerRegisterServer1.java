/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontendfinal1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siddharth
 */
public class peerRegisterServer1 implements Runnable{
    int port = 1001;
    int buffersize = 1024;
    //DatagramSocket ds;
    byte buffer[] = new byte[buffersize];
    DatagramPacket message;
    InetAddress ip,group; 
    MulticastSocket msocket;
    //ArrayList<String> peers = new ArrayList<>();
    
    @Override
    public void run(){
        try {
            ip = InetAddress.getLocalHost();
            
            //ds = new DatagramSocket(port,ip);
            msocket = new MulticastSocket(port);
            msocket.setBroadcast(true);
            group = InetAddress.getByName("235.1.1.1");
            msocket.joinGroup(group);
            
            
            message = new DatagramPacket(buffer,buffersize);
            while(true){
                //ds.receive(message);
                msocket.receive(message);
                
                
                System.out.println(new String(message.getData() , 0 , message.getLength()));
                if ( !global.peers.contains(message.getAddress().getHostAddress()))       //  global 
                {
                    global.peers.add(message.getAddress().getHostAddress());
                
                    message.setAddress(message.getAddress());
                    message.setPort(1001);
                    for(int i = 0 ; i < 5 ;i++){
                        //ds.send(message);
                        msocket.send(message);
                        
                    }
                
                }
            }
        } catch (IOException ex) {
            System.out.println("peer register server error");
            Logger.getLogger(peerRegisterServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
