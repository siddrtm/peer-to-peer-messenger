/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontendfinal1;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siddharth
 */
public class multimreciever implements Runnable{
    private ServerSocket server;
    private int port;
    multimreciever(int port) throws ClassNotFoundException{
        try {
            this.port = port;
            server = new ServerSocket(port);
            
        } catch (IOException ex) {
            Logger.getLogger(multimreciever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                mreciever m = new mreciever(server);
                Thread t = new Thread(m);
                t.start();
            } catch (    ClassNotFoundException | IOException ex) {
                Logger.getLogger(multimreciever.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
            }
    }
}
