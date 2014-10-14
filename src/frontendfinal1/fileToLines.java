/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontendfinal1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author siddharth
 */
public class fileToLines {
    /**
     *
     * @param filename
     * @return
     */
    List<String> lines;
    public  List<String> filetolines(String filename)  {
                lines = new LinkedList<>();
                String line;
                try {
                        BufferedReader in = new BufferedReader(new FileReader(filename));
                        while ((line = in.readLine()) != null) {
                                lines.add(line);
                        }
                } catch (IOException e) {
                        System.out.print(e);
                }
                return lines;
        }

}
