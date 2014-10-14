/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontendfinal1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siddharth
 */
public class mfilereciever implements Runnable {

    @Override
    public void run() {
        while(true){
            try {
                filereciever fr = new filereciever( 4445 , "E:/originalFile12");
                
            } catch (Exception ex) {
                Logger.getLogger(mfilereciever.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
