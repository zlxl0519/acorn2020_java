package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AcornFrame extends JFrame implements ActionListener{
	
	public AcornFrame() {
		
		setLayout(new BorderLayout());
		JButton sendBtn=new JButton("전송");
		add(sendBtn, BorderLayout.NORTH);
		sendBtn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		
		AcornFrame f=new AcornFrame();
		f.setBounds(100, 100, 400, 400);
		f.setTitle("acorn");
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(this, "전송합니다.");
	}
}
