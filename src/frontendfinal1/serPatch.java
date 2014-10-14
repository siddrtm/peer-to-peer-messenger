/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontendfinal1;
import difflib.*;
import java.io.Serializable;
/**
 *
 * @author siddharth
 */
public class serPatch implements Serializable{
    Patch p;
    
    serPatch(Patch p){
        this.p = p;
    }
    
    
    public Patch getPatch(){
        return p;
    }
}
