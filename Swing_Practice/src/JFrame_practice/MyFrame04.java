package JFrame_practice;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame04 extends JFrame{
	public MyFrame04(String title) {
		super(title);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new CardLayout());
		JButton btn1= new JButton("버튼1");
		add(btn1);
		
		JButton btn2= new JButton("버튼2");
		add(btn2);
		
		JButton btn3= new JButton("버튼3");
		add(btn3);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame04("CardLayout");
	}
}
