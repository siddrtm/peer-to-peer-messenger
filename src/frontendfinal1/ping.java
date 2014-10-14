/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontendfinal1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author siddharth
 */
public  class ping {
    
    InetAddress ip;
    int port = 1000;
    int buffersize = 1024;
    DatagramSocket ds;
    byte buffer[] = new byte[buffersize];
    DatagramPacket packet;
    MulticastSocket msocket;
    InetAddress group;
    
    ping(String ip,String message) throws Exception {
        ds = new DatagramSocket(port,InetAddress.getLocalHost());
        buffer = message.getBytes();
        packet = new DatagramPacket(buffer,buffer.length,InetAddress.getByName(ip),1001);
        for(int i = 0 ; i < 5 ; i++){
            ds.send(packet);
        
        }
        ds.close();
    }
    
    ping(int ip,String message) throws Exception{
        ds = new DatagramSocket(port,InetAddress.getLocalHost());
        buffer = message.getBytes();
        packet = new DatagramPacket(buffer,buffer.length);
        packet.setPort(1001);
        for(int i = 0 ; i < 255 ; i++){
            packet.setAddress(InetAddress.getByName("172.22." + ip + "." + i));
            ds.send(packet);
            ds.send(packet);
            ds.send(packet);
        }
        ds.close();
        
    }

    ping(String message){
        try {
            msocket = new MulticastSocket(port);
            msocket.setBroadcast(true);
            group = InetAddress.getByName("235.1.1.1");
            msocket.joinGroup(group);
            buffer = message.getBytes();
            packet = new DatagramPacket(buffer,buffer.length);
            packet.setPort(1001);
            packet.setAddress(group);
            msocket.send(packet);
            msocket.send(packet);
            
        } catch (IOException ex) {
            Logger.getLogger(ping.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                msocket.leaveGroup(group);
                msocket.close();
            } catch (IOException ex) {
                Logger.getLogger(ping.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
   
    
    
}
