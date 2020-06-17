package JFrame_practice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame02 extends JFrame implements ActionListener{
	
	//생성자
	public Frame02() {
		setLayout(new BorderLayout());
		
		JPanel panel=new JPanel();
		JButton btn=new JButton("버튼");
		JTextField f=new JTextField(10);
		JTextArea area=new JTextArea();
		
		panel.add(f);
		panel.add(btn);
		add(panel, BorderLayout.NORTH);
		add(area, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		Frame02 f=new Frame02();
		f.setTitle("test2");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,500,500);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
