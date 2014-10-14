package frontendfinal1;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class Application extends Thread 
{
	JFrame frame=new JFrame();
	JProgressBar ps;
	static JProgressBar pg=new JProgressBar();
	Application()
	{
		
	}
	Application(JProgressBar pp)
	{
		super("Demo Thread");
		ps=pp;
		start();
	}
	public void gui()
	{
		frame.setLayout(null);
		
		
		Color c=new Color(145, 70, 244);
		//frame.getContentPane().setBackground(c);
		frame.setLocation(400, 150);
		frame.setSize(500, 400);
		
		

		
		JLabel l1=new JLabel("Peer2Peer");
		
		l1.setBounds(150, 20, 590, 110);
		Font font=new Font("serif",Font.BOLD,50);
		l1.setFont(font);
		//l1.setVerticalTextPosition(JLabel.TOP);
		//l1.setHorizontalTextPosition(JLabel.CENTER);
		frame.add(l1);
		//frame.add(l);
		frame.add(pg);
		pg.setBounds(180, 350, 180, 20);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
		
			
	public void start()
	{
		for(int i=0;Application.pg.getValue()<100;i++)
		
		try 
		{
						
			ps.setValue(ps.getValue()+10);
			sleep(200);
		} 
		catch (InterruptedException e) 
		{
						
			e.printStackTrace();
		}
		
		
				
				
				
				//FirstPage12 fp =new FirstPage12(ps);
				//fp.setVisible(false);
				//.setVisible(true);
		
	}
	
	public void disp()
	{
		frame.dispose();
	}
	
	public static void main(String args[])
	{
		Application obj=new Application();
		obj.gui();
		Application ob=new Application(pg);
		//obj.publicFirstpage(pg);
		
		obj.disp();
		Frontendfinal1 wel = new Frontendfinal1() ;
		wel.setVisible(true);
	}
	
	
	
}
 

