package JFrame_practice;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame03 extends JFrame{
	public MyFrame03(String title) {
		super(title);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(2, 2, 100, 250));
		JButton btn1=new JButton("button1");
		add(btn1);
		
		JButton btn2=new JButton("button2");
		add(btn2);
		
		JButton btn3=new JButton("button3");
		add(btn3);
		
		JButton btn4=new JButton("button4");
		add(btn4);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame03("Layout GridLayout");
	}
}
