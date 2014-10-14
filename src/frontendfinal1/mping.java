/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontendfinal1;

/**
 *
 * @author siddharth
 */
public class mping implements Runnable{
    int ip;
    String message;
    mping(int ip,String message){
        this.ip = ip;
        this.message = message;
    }
    @Override
    public void run() {
        try {
            while(true){
               // ping ping = new ping(ip,message);
                ping ping = new ping(message);
                
                
                Thread.sleep(10000);
            }
        } catch (Exception ex) {
            System.out.println("tcp mping cannot establish connection");
        }
    }
    
}
