package test.frame2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	//생성자
	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//레이 아웃 매니저를 FlowLayout 으로 지정한다.
		//setLayout(new FlowLayout(0));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		// 흐르는 레이아웃 프레임 크기가달라질때마다
		// 버튼 위치들이 자연스럽게 바뀐다.
		/*
		 * 	public class FlowLayout{
		 * 		public static final int LEFT=0;
		 * 		public static final int RIGHT=2;
		 * 		.	
		 * 		.
		 * }
		 */
		
		JButton btn1=new JButton("버튼1");
		add(btn1);
		
		JButton btn2=new JButton("버튼2");
		add(btn2);
		
		JButton btn3=new JButton("버튼3");
		add(btn3);
		
		JButton btn4=new JButton("버튼4");
		add(btn4);
		
		setVisible(true); 
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}
