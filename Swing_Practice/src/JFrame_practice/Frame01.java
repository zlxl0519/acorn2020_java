package JFrame_practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame01 extends JFrame implements ActionListener{
	//생성자
	public Frame01() {
		
		setLayout(new BorderLayout());
		
		Panel panel=new Panel();
		
		JButton sendBtn=new JButton("전송");
		JButton removeBtn=new JButton("삭제");
		
		panel.add(sendBtn);
		panel.add(removeBtn);
		
		add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.YELLOW);
		
	}
	
	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setTitle("test");
		f.setBounds(100,100,500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
