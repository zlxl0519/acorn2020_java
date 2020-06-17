package JFrame_practice;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame01 extends JFrame implements ActionListener{
	//필드
	JTextField text;
	JTextArea area;
	//생성자
	public Frame01() {
		
		setLayout(new BorderLayout());
		
		JButton sendBtn=new JButton("전송");
		JButton removeBtn=new JButton("삭제");
		
		sendBtn.setActionCommand("send");
		removeBtn.setActionCommand("remove");
		
		sendBtn.addActionListener(this);
		removeBtn.addActionListener(this);
		
		text=new JTextField(10);
		
		JPanel panel=new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.YELLOW);
		panel.add(text);
		panel.add(sendBtn);
		panel.add(removeBtn);
		
		area=new JTextArea();
		add(area, BorderLayout.CENTER);
		
		
	}
	
	public static void main(String[] args) {
		Frame01 f=new Frame01();
		f.setTitle("test");
		f.setBounds(100,100,500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("send")) {
			send();
		}else if(command.equals("remove")) {
			area.setText("");
		}
	}
	
	public void send() {
		String inputtext=text.getText();
		text.setText("");
		area.append(inputtext);
		area.append("\r\n");
	}
	
}
