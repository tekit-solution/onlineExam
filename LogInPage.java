package com.swingExample;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;

public class LogInPage extends JFrame implements ActionListener{
	Container container = getContentPane();
	JLabel heading=new JLabel("Online Examination");
	JLabel userLabel = new JLabel("USERNAME");
	JLabel passwordLabel = new JLabel("PASSWORD");
	JTextField userTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JCheckBox showPassword = new JCheckBox("Show Password");


	LogInPage() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		

	}
	public void setLayoutManager() {
		container.setLayout(null);

	}
	public void setLocationAndSize() {
		heading.setFont(new Font("Dialog", Font.BOLD, 30));
		heading.setForeground(new Color(92, 184, 92));
		userLabel.setFont(new Font("user", Font.BOLD, 14));
		passwordLabel.setFont(new Font("user", Font.BOLD, 14));
		heading.setBounds(500, 100, 300, 30);
		userLabel.setBounds(500, 250, 100, 30);
		passwordLabel.setBounds(500, 320, 100, 30);
		userTextField.setBounds(600, 250, 150, 30);
		passwordField.setBounds(600, 320, 150, 30);
		showPassword.setBounds(600, 350, 150, 30);
		loginButton.setBounds(500, 440, 100, 30);
		resetButton.setBounds(640, 440, 100, 30);
		getContentPane().setBackground(Color.WHITE);
		userTextField.setBackground(new Color(242, 244, 244 ));
		passwordField.setBackground(new Color(242, 244, 244 ));
		showPassword.setBackground(Color.WHITE);
		loginButton.setBackground(new Color(92, 184, 92));
		resetButton.setBackground(new Color(92, 184, 92));
		loginButton.setForeground(Color.WHITE);
		resetButton.setForeground(Color.WHITE);
	
		


	}

	public void addComponentsToContainer() {
		container.add(heading);
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(userTextField);
		container.add(passwordField);
		container.add(showPassword);
		container.add(loginButton);
		container.add(resetButton);
	}

	public void addActionEvent() {
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//Coding Part of LOGIN button
		if (e.getSource() == loginButton) {
			String userText;
			String pwdText;
			userText = userTextField.getText();
			pwdText = passwordField.getText();
			if (userText.equalsIgnoreCase("surbhi") && pwdText.equalsIgnoreCase("12345")) {

				new SecondFrame("Online Test Of Java");
				dispose();
				//JOptionPane.showMessageDialog(this, "Login Successful");
			} else {
				JOptionPane.showMessageDialog(this, "Invalid Username or Password");
			}


		}
		//Coding Part of RESET button
		if (e.getSource() == resetButton) {
			userTextField.setText("");
			passwordField.setText("");
		}
		//Coding Part of showPassword JCheckBox
		if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			} else {
				passwordField.setEchoChar('*');
			}


		}

	}
	public static void main(String[] a) {
		LogInPage frame = new LogInPage();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(false);
		frame.setTitle("Login Form");

		frame.setVisible(true);
		//frame.setBounds(10, 10, 370, 600);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}

}

class SecondFrame extends JFrame implements ActionListener{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2,submitButton;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];
	 final long THIRTY_MINUTES = 180;
	 final java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("mm : ss");
	    final JLabel clock = new JLabel(sdf.format(new Date(THIRTY_MINUTES)),JLabel.CENTER);
	    int x1 = 0;
	SecondFrame(String s)
	{
		getContentPane().setBackground(Color.WHITE);
		l=new JLabel();
		
		add(l);
		 ActionListener al = new ActionListener(){
		      long x = THIRTY_MINUTES - 1000;
		      public void actionPerformed(ActionEvent ae){
		        clock.setText(sdf.format(new Date(x)));
		        x -= 1000;
		        if(clock.getText().equals("00 : 00")){
		        	  JFrame jf=new JFrame();
					   jf.getContentPane().setBackground(Color.WHITE);
					JLabel   l1=new JLabel("ThankYou"); 
					l1.setFont(new Font("abc", Font.BOLD, 28));
					    l1.setBounds(600,320,400,30); 
					    jf.add(l1);
					   jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					   jf.setLayout(null);
					   jf.setLocation(250,100);
					   jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
					   jf.setVisible(true);
					   
					   dispose();
		        }
		        }};
		    new javax.swing.Timer(1000, al).start();
		    JPanel jp = new JPanel();
		    clock.setFont(new Font("abc", Font.BOLD, 24));
		 clock.setForeground(Color.RED);
		add(clock);
		
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();
			jb[i].setBackground(Color.WHITE);
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Previous");
		b2=new JButton("Next");
		//b1.setBackground(Color.orange);
		submitButton=new JButton("Submit Test");
		b1.addActionListener(this);
		b2.addActionListener(this);
		
         
		add(b1);add(b2);

		set();
		l.setBounds(460,200, 500, 30);
		clock.setBounds(1000,100, 100, 30);
		jb[0].setBounds(460,240,500,30);
		jb[1].setBounds(460,270,500,30);
		jb[2].setBounds(460,300,500,30);
		jb[3].setBounds(460,330, 500, 30);
		// b1.setPreferredSize(new Dimension(80, 80));
  b1.setForeground(Color.WHITE);
		b1.setBounds(400,440,120,30);
		b1.setBackground(new Color(92, 184, 92));
		 b2.setForeground(Color.WHITE);
		b2.setBackground(new Color(92, 184, 92));
		b2.setBounds(640,440,120,30);
		clock.setBounds(1000,100, 100, 30);
		//submitButton.setBounds(700,440, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		b1.setEnabled(false);
		//setSize(600,350);
		
	}
	String selected = null;
	HashMap<String,String> h=new HashMap<>();
	public  void mapData(){
		if(!selected.isEmpty()){
			h.put(l.getText(),selected);
		}

	}
	public void setButtonData(){
		if(h.containsKey(l.getText()))
		{
			System.out.println(l.getText());
			for(int i = 0; i <jb.length; i++){

				if(jb[i].getText().equals(h.get(l.getText())))
				{
					System.out.println(jb[i].getText());
					jb[i].setSelected(true);}

			}
		}

	}

	public void actionPerformed(ActionEvent e)
	{

		
		   

		for(int i = 0; i <jb.length; i++){

			if(jb[i].isSelected())

				selected = jb[i].getText();}



		if(e.getSource()==b2)
		{
			 
			
			count=count+1;
			
			current++;
			 
			set();	
			
			
			if(current==9)
			{    
				b2.setText("Submit Test");
				
				
			}else{
				b1.setEnabled(true);
			}
			if(current==10){
			if(b2.getText()=="Submit Test"){
				
				   JFrame jf=new JFrame();
				   jf.getContentPane().setBackground(Color.WHITE);
				JLabel   l1=new JLabel("ThankYou"); 
				l1.setFont(new Font("abc", Font.BOLD, 28));
				    l1.setBounds(600,320,400,30); 
				    jf.add(l1);
				   jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				   jf.setLayout(null);
				   jf.setLocation(250,100);
				   jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
				   jf.setVisible(true);
				   
				   dispose();
				 
					}  } 
		}if(e.getSource()==b1)
		{


			count=count-1;
			current--;
			set();	
			if(current<9)
			{    
                b2.setText("Next");
				b2.setEnabled(true);

				//b2.setText("Result");
			}if(current ==0){


				b1.setEnabled(false);

			}
		}
		
	

	}
	void set()
	{

		l.setFont(new Font("Serif", Font.BOLD, 20));
		l.setForeground(new Color(92, 184, 92));
		
		jb[4].setSelected(true);
		if(current==0)
		{
			 
		     
			l.setText("Que1: Which one among these is not a datatype ?");
			jb[0].setText("int");jb[1].setText("Float");jb[2].setText("boolean");jb[3].setText("char");	
			setButtonData();

		}
		if(current==1)
		{
			mapData();

			l.setText("Que2: Which class is available to all the class automatically ?");
			jb[0].setText("Swing");jb[1].setText("Applet");jb[2].setText("Object");jb[3].setText("ActionEvent");
			setButtonData();
			//System.out.println(h);
		}
		if(current==2)
		{
			mapData();
			l.setText("Que3: Which package is directly available to our class without importing it ?");
			jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");
			setButtonData();
		}
		if(current==3)
		{
			mapData();
			l.setText("Que4: String class is defined in which package ?");
			jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");
			setButtonData();
		}
		if(current==4)
		{
			mapData();
			l.setText("Que5: Which institute is best for java coaching ?");
			jb[0].setText("Utek");jb[1].setText("Aptech");jb[2].setText("SSS IT");jb[3].setText("jtek");
			setButtonData();
		}
		if(current==5)
		{ mapData();
		l.setText("Que6: Which one among these is not a keyword ?");
		jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");
		setButtonData();
		}
		if(current==6)
		{
			mapData();
			l.setText("Que7: Which one among these is not a class ?");
			jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");jb[3].setText("Button");
			setButtonData();
		}
		if(current==7)
		{
			mapData();
			l.setText("Que8: which one among these is not a function of Object class ?");
			jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");		
			setButtonData();
		}
		if(current==8)
		{
			mapData();
			l.setText("Que9: which function is not present in Applet class ?");
			jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");
			setButtonData();
		}
		if(current==9)
		{
			mapData();
			l.setText("Que10: Which one among these is not a valid component ?");
			jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");jb[3].setText("JTextArea");
			setButtonData();
		}
		if(current==10){
			mapData();
			
		}

		l.setBounds(460,200,1000,30);
		

		/*for(int i=0,j=0;i<=90;i+=30,j++)

			jb[j].setBounds(500,220+i,500,30);*/
		for(int i=0;i<5;i++){
			jb[i].setFont(new Font("abc", Font.BOLD, 18));
		}
		/*b1.setSize(new Dimension(100,40));
		b2.setSize(new Dimension(100,40));*/
		System.out.println(h);

	}



}



