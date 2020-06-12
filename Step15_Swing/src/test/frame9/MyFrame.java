package test.frame9;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener, KeyListener{
	
	JTextField inputMsg;
	JLabel lab1;
	
	//default 생성자
	public MyFrame() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		// <input type="test"/>
		inputMsg=new JTextField(10);
		add(inputMsg);
		
		inputMsg.addKeyListener(this);
		
		JButton sendBtn=new JButton("전송");
		sendBtn.addActionListener(this);
		add(sendBtn);
		
		//JLabel 객체 생성
		lab1=new JLabel("label 입니다.");
		add(lab1);
	}
	
	public static void main(String[] args) {
		//MyFrame 클래스를 이용해서 객체 생성하고 참조값을 지역변수 frame 에 담기
		MyFrame frame=new MyFrame();
		//프레임 제목 설정
		frame.setTitle("나의 프레임");
		//프레임을 닫으면 자동으로 프로세스가 종료 되도록 한다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
		
	}
	//ActionListener 인터페이스를 구현 해서 강제 오버라이드된 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		//JTextField 에 입력한 문자열을 읽어와야한다.
		String msg=inputMsg.getText();
		//읽어온 문자열을 JLabel 에 추가하기
		lab1.setText(msg);
		//입력창 문자열 삭제하기
		inputMsg.setText("");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//눌러진 키보드의 코드값을 일어온다.
		int code=e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {
			//JTextField 에 입력한 문자열을 읽어와야한다.
			String msg=inputMsg.getText();
			//읽어온 문자열을 JLabel 에 추가하기
			lab1.setText(msg);
			//입력창 문자열 삭제하기
			inputMsg.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	
}
