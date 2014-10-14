/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontendfinal1;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siddharth
 */
public class msender implements Runnable{
    Socket s;
    OutputStream os;
    InetAddress ip;
    String message;
    int port;
    msender(String ipaddr,int port,String message) throws Exception{
        ip = InetAddress.getByName(ipaddr);
        this.port = port;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            s = new Socket(ip,port);
            os = s.getOutputStream();
            try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
                oos.writeObject(message);
            }
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(msender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
