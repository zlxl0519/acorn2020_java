package test.frame11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener, KeyListener{
	
	public static String COMMEND_PLUS="plus";
	public static String COMMEND_minus="minus";
	public static String COMMEND_multi="multi";
	public static String COMMEND_divi="divi";
	
	JTextField inputNum1;
	JTextField inputNum2;
	JLabel resultNum;
	//default 생성자
	public MyFrame() {
		setLayout(new BorderLayout());
		//입력할곳
		inputNum1=new JTextField(10);
		inputNum2=new JTextField(10);
		//연산자 버튼 // 클릭했을때 이벤트
		JButton plus=new JButton("+");
		plus.addActionListener(this);
		plus.setActionCommand(COMMEND_PLUS);
		JButton minus=new JButton("-");
		minus.addActionListener(this);
		minus.setActionCommand(COMMEND_minus);
		JButton multi=new JButton("*");
		multi.addActionListener(this);
		multi.setActionCommand(COMMEND_multi);
		JButton divi=new JButton("/");
		divi.addActionListener(this);
		divi.setActionCommand(COMMEND_divi);
		//값나오는곳
		JLabel result = new JLabel("=");
		resultNum=new JLabel();
		//판넬 추가
		JPanel panel=new JPanel();
		panel.add(inputNum1);
		panel.add(plus);
		panel.add(minus);
		panel.add(multi);
		panel.add(divi);
		panel.add(inputNum2);
		panel.add(result);
		panel.add(resultNum);
		
		add(panel, BorderLayout.NORTH);
		
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
		try {
			Object command=e.getActionCommand();
			//계산위해 숫자로 바꾸기
			double num1=Double.parseDouble(inputNum1.getText());
			double num2=Double.parseDouble(inputNum2.getText());
			
			if(command==COMMEND_PLUS) {
				double plusresult=num1+num2;
				//불러오기 위해 String 으로 바꾸기
				resultNum.setText(plusresult+"");
				
			}else if(command==COMMEND_minus) {
				double minusresult=num1-num2;
				resultNum.setText(minusresult+"");
			}else if(command==COMMEND_multi) {
				double multiresult=num1*num2;
				resultNum.setText(multiresult+"");
			}else if(command==COMMEND_divi) {
				double diviresult=num1/num2;
				resultNum.setText(diviresult+"");
			}
		}catch(NumberFormatException nfe) {
			System.out.println("숫자형식에 맞게 입력 하세요");
		}
		
		
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	
}
