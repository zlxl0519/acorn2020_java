package JFrame_practice;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame02 extends JFrame{
	
	public MyFrame02(String title) {
		super(title);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		JButton btn1=new JButton("버튼1");
		add(btn1,BorderLayout.NORTH);
		
		JButton btn2=new JButton("버튼2");
		add(btn2, BorderLayout.WEST);
		
		JButton btn3=new JButton("버튼3");
		add(btn3 , BorderLayout.SOUTH);
		
		JButton btn4=new JButton("버튼4");
		add(btn4, BorderLayout.EAST);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame02("BorderLayout");
	}
}
