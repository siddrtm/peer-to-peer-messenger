/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontendfinal1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siddharth
 */
public class mreciever implements Runnable{
    private ServerSocket server;
    private Socket s;
    private InputStream is;
    private String message;
    private String hostname,hostip;
    private String formattedmessage;
    mreciever(ServerSocket server)  throws ClassNotFoundException, IOException{
        this.server = server;
        s = server.accept();
        server.setSoTimeout(0);
    }
    
    
    public String getmessage(){
        return this.message;
    }
    
    public String getsenderhostname(){
        return this.hostname;
    }
    public String getsenderip(){
        return this.hostip;
    }
    public String getformattedmessage(){
        return this.hostname +" ("+ this.hostip +")      : "+ this.message ;
    }

    @Override
    public void run() {
        try {
            
            is = s.getInputStream();
            ObjectInputStream o;
//            byte b [] = null;
            o = new ObjectInputStream(is);
            //is.read(b);
            message = (String) o.readObject();
            System.out.println(message);
            hostname =  s.getInetAddress().getHostName();
            hostip = s.getInetAddress().getHostAddress();
            //System.out.println(message);
            //global.messages.add(getformattedmessage());        // global
            System.out.print("\007");
            Frontendfinal1 lesson = new Frontendfinal1(getformattedmessage());
            lesson.fun1();
            
        } catch (Exception  ex) {
            Logger.getLogger(mreciever.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                is.close();
                s.close();
                
            } catch (IOException ex) {
                Logger.getLogger(mreciever.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
}
