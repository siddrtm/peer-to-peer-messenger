/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontendfinal1;

/**
 *
 * @author siddharth
 */

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

// Extends JFrame so it can create frames

public class Frontendfinal1 extends JFrame{
	
	JButton button1,button2,button,button3;
        JComboBox user,user1;
	JTextField textField1;
	JTextArea textArea1,textArea2;
	int buttonClicked;
        String str = "";
        String  str1;
        String [] users;
        JPanel thePanel;
        String msg;
	
	 Frontendfinal1 (){
            try {      
                
                mfilereciever mfr = new mfilereciever();
                Thread t0 = new Thread(mfr);
                t0.start();
                
                //peerRegisterServer prs = new peerRegisterServer();
                peerRegisterServer1 prs = new peerRegisterServer1();
                
                Thread t1 = new Thread(prs);
                t1.start();

                mping mp = new mping(29,InetAddress.getLocalHost().getHostName());
                Thread t2 = new Thread(mp);
                t2.start();

                multimreciever m = new multimreciever(5000);
                Thread t = new Thread(m);
                t.start();

                //Thread.sleep(1000);
                //msender ms = new msender("localhost",5000,"test");

                Frontendfinal1 lesson21 = new Frontendfinal1("");
                lesson21.fun1();
            } catch (Exception ex) {
                System.out.println("Connection cannot be established");
                //Logger.getLogger(Frontendfinal1.class.getName()).log(Level.SEVERE, null, ex);
            }


        }

        
        
        Frontendfinal1(String msg){
                this.msg = msg;
        }
        
        
        
        public void fun1() throws Exception{
            this.setSize(400,400);
		
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.setTitle("P2P NETWORK");
		
		thePanel = new JPanel();
		
		// Create an array that will be added to the combo box
		//ArrayList<String> peers = new ArrayList<>();
               // peers.add("localhost");
               // peers.add("172.22.29.194");
                global.users = new String [global.peers.size()];
		global.users  = global.peers.toArray(global.users);
		
		// Create a combo box and add the array of shows
		
		user = new JComboBox(global.users);
		
		// Add an item to the combo box
		
		//user.addItem("diwakar");
		
		thePanel.add(user);
		
		// Create a button
		
		button2 = new JButton("messege");
                button3 = new JButton("send file");
		
		ListenForButton lForButton = new ListenForButton();
                lForButton.soccer(this);
		ListenForButton lForButton1 = new ListenForButton();
		button2.addActionListener(lForButton);
                lForButton1.soccer(this);
		
		thePanel.add(button2);
                
                button = new JButton("refresh");
		
	
		
		button.addActionListener(lForButton1);
                
                thePanel.add(button);
                
                button3.addActionListener(lForButton1);
                
                thePanel.add(button3);
                
                
                
                textArea2 = new JTextArea(15,25);
				
		// Set the default text for the text area
				
				
		// If text doesn't fit on a line, jump to the next
		
		textArea2.setLineWrap(true);
		
		// Makes sure that words stay intact if a line wrap occurs
				
		textArea2.setWrapStyleWord(true);
                textArea2.setText(msg);
                JScrollPane scrollbar2 = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				
		// Other options: VERTICAL_SCROLLBAR_ALWAYS, VERTICAL_SCROLLBAR_NEVER
				
		thePanel.add(scrollbar2);
		
				
		
		this.add(thePanel);
		
		this.setVisible(true);		
		
	}
	
        
	
	public void fun() throws Exception{
		
		// Define the size of the frame
		this.setSize(400, 400);
		
		// Toolkit is the super class for the Abstract Window Toolkit
		// It allows us to ask questions of the OS
				
		Toolkit tk = Toolkit.getDefaultToolkit();
				
		// A Dimension can hold the width and height of a component
		// getScreenSize returns the size of the screen
				
		Dimension dim = tk.getScreenSize();
				
		// dim.width returns the width of the screen
		// this.getWidth returns the width of the frame you are making
				
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
				 
		// You could also define the x, y position of the frame
				 
		this.setLocation(xPos, yPos);
		
		// Define how the frame exits (Click the Close Button)
		// Without this Java will eventually close the app
				
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
		// Define the title for the frame
				
		this.setTitle("MESSAGE");
				
		// The JPanel contains all of the components for your frame
				
		JPanel thePanel1 = new JPanel();
		
		// Create a button with Click Here on it
		
		button1 = new JButton("Send");
		
		// Create an instance of ListenForEvents to handle events
		
		ListenForButton lForButton = new ListenForButton();
		
		// Tell Java that you want to be alerted when an event
		// occurs on the button
		
		button1.addActionListener(lForButton);
		
		thePanel1.add(button1);
		
		// How to add a text field ----------------------
		
		//textField1 = new JTextField("Type Here", 15);
		
		//ListenForKeys lForKeys = new ListenForKeys();
		
		//textField1.addKeyListener(lForKeys);
				
		//thePanel.add(textField1);
		
		// How to add a text area ----------------------
		
		textArea1 = new JTextArea(15, 20);
				
		// Set the default text for the text area
				
				
		// If text doesn't fit on a line, jump to the next
		
		textArea1.setLineWrap(true);
		
		// Makes sure that words stay intact if a line wrap occurs
				
		textArea1.setWrapStyleWord(true);
				
		// Adds scroll bars to the text area ----------
				
		JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				
		// Other options: VERTICAL_SCROLLBAR_ALWAYS, VERTICAL_SCROLLBAR_NEVER
				
		thePanel1.add(scrollbar1);
		
		this.add(thePanel1);
		
		
		this.setVisible(true);
		
		// Track the mouse if it is inside of the panel
		
		
		
		
	}
	
	// Implements ActionListener so it can react to events on components
	
	private class ListenForButton implements ActionListener{
	
	Frontendfinal1 a;
	public void soccer(Frontendfinal1 o){
            a=o;
        }
       
        @Override
               public void actionPerformed  (ActionEvent e) {
		
		// Check if the source of the event was the button
		
		if(e.getSource() == button2){
                      global.Selectedindex = user.getSelectedIndex();
                      Frontendfinal1 lesson2 = new Frontendfinal1("");
                      System.out.println("d");
                try {
                    lesson2.fun();
                } catch (Exception ex) {
                    Logger.getLogger(Frontendfinal1.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                if(e.getSource()== button){
                    Frontendfinal1 l = new Frontendfinal1("");
                   
                    try {
                        l.fun1();
                    } catch (Exception ex) {
                        Logger.getLogger(Frontendfinal1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    a.dispose();
                    
                }
                
                if(e.getSource() == button3){
                       try {
                           /* Frontendfinal1 lesson2 = new Frontendfinal1("");
                            System.out.println("r");
                      try {
                          lesson2.fun();
                      } catch (Exception ex) {
                          Logger.getLogger(Frontendfinal1.class.getName()).log(Level.SEVERE, null, ex);
                      }*/
                          JFileChooser choose = new JFileChooser();

                         
                         int choice;
                             choice = choose.showOpenDialog(a);

                         if (choice != JFileChooser.APPROVE_OPTION) 
                         {return;
                         }
                   

                          File chosenFile = choose.getSelectedFile();
                        sender sendfile = new sender(global.users[global.Selectedindex],4445,chosenFile.getPath());
                        Thread s1 = new Thread(sendfile);
                        s1.start();
                       } catch (Exception ex) {
                           Logger.getLogger(Frontendfinal1.class.getName()).log(Level.SEVERE, null, ex);
                       }
                }
                
                if(e.getSource() == button1){
                    
                    try{
                    //System.out.println(global.Selectedindex);
                    //msender ms = new msender(( String ) user.getItemAt(user.getSelectedIndex()) ,  5000  ,  textArea1.getText()); 
                    //System.out.println(global.users[global.Selectedindex]);
                    
                    msender ms = new msender(global.users[global.Selectedindex],5000,textArea1.getText());
                    ms.run();
                }
       
               catch(Exception ex){
            System.out.println(ex);
        }
                }
            
        }
	}
	
}
