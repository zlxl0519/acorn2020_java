package JFrame_practice;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame05 extends JFrame{
	public MyFrame05(String title) {
		super(title);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new GridBagLayout());
		JButton btn1=new JButton("버튼1");
		add(btn1);
		
		JButton btn2=new JButton("버튼2");
		add(btn2);
		
		JButton btn3=new JButton("버튼3");
		add(btn3);
		
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new MyFrame05("GridBagLayout");
	}
}
