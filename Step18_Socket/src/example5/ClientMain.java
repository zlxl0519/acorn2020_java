package example5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONObject;
/*
 * 	메세지의 종류
 * 	
 * 	1. 일반 대화 메세지 	
 * 		{"name" : "김구라", "msg" : "안녕하세요"} - JSONObject neme 이라는 키값에 "김구라" 가 있는것.
 * 	2.	누군가 입장 했다는 메세지	
 * 		{"enter" : "김구라"}
 * 	3. 누군가 퇴장 했다는 메세지	
 * 		{"out " : "원숭이"}
 * 	4. 참여자 목록 메세지
 * 		{"members":["김구라", "해골", "원숭이"]}   // [] -JSONArray
 * 		
 * 
 */
public class ClientMain extends JFrame implements ActionListener, KeyListener{
	//필드
	JTextField tf_msg;
	//서버와 연결된 Socket 객체의 참조값을 담을 필드
	Socket socket; // 이 객체를 다른 메소드에서도 사용하도록 //선언만 하면 null이 들어있다.
	BufferedWriter bw;
	JTextArea area;
	//대화명
	String chatName;
	//생성자
	public ClientMain() {
		//대화명을 입력 받아서 필드에 저장한다.
		chatName=JOptionPane.showInputDialog(this, "대화명을 입력하세요");
		
		setTitle("대화명:"+chatName);
		//서버에 소켓 접속을 한다.
		try {
			//접속이 성공되면 Socket 객체의 참조값이 반환된다.
			//반환되는 객체의 참조값을 필드에 저장해 놓는다.
			socket=new Socket("192.168.0.9", 5000);//필드에 저장된다.
			//문자열을 서버에 전송(출력Output) 하기// 접속한 서버에 출력할객체
			//서버에 문자열을 출력할
			//BufferedWriter 객체의 참조값을 얻어내서 필드에 저장해 놓는다.
			OutputStream os=socket.getOutputStream();//socket객체의 메소드로 받아온 객체
			//new 해서 쓰고 버리고...이런식
			OutputStreamWriter osw=new OutputStreamWriter(os);//객체를 일회용으로 사용중
			bw=new BufferedWriter(osw);
			//내가 입장한다고 서버에 메세지를 보낸다.
			//"{"enter" : "김구라"}" {} - jsonobject , [] -jsonarray
			//String msg="{\"enter\":\""+chatName+"\"}";//" 밖에 있는 " 인식하지 말라고 \ 사용
			
			JSONObject jsonObj=new JSONObject();
			jsonObj.put("enter", chatName);// 서버에서 chatName 을 빼내기 위해서는 서버에서 new JSONObject(chatName);
			String msg=jsonObj.toString();
			//BufferedWriter 객체를 이용해서 보내기
			bw.write(msg);
			bw.newLine();
			
			
			
			//서버로 부터 메세지를 받을 스레드도 시작을 시킨다.
			new ClientThread().start(); // 다른 스레드로 동작해서 동작이 잡혀있지 않는다.
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//레이아웃을 BorderLayout 으로 지정하기
		setLayout(new BorderLayout());
		
		//페널
		JPanel panel=new JPanel();
		panel.setBackground(Color.YELLOW);
		//입력창
		tf_msg=new JTextField(10);
		//버튼
		JButton sendBtn=new JButton("전송");
		sendBtn.setActionCommand("send");
		//버튼에 리스너 등록
		sendBtn.addActionListener(this);
		//페널에 입력창과 버튼을 추가
		panel.add(tf_msg);
		panel.add(sendBtn);
		//프레임의 아래쪽에 페널 배치하기
		add(panel, BorderLayout.SOUTH);
		
		//JTextArea 의 참조값을 필드에 저장하기
		area=new JTextArea();
		//문자열 출력 전용으로 사용하기 위해 편집 불가능하도록 설정
		area.setEditable(false);
		//배경색
		area.setBackground(Color.PINK);
		//스크롤 가능하도록
		JScrollPane scroll= new JScrollPane(area, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//프레임의 가운데에 배치하기
		add(scroll, BorderLayout.CENTER);
		
		//엔터키로 메세지 전송 가능하게 하기 위해
		tf_msg.addKeyListener(this);
		
	}//생성자 종료
	
	public static void main(String[] args) {
		//프레임 객체 생성
		ClientMain f= new ClientMain();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sendMessage();
	}
	
	//메세지를 전송하는 메소드
	public void sendMessage() {
		//전송할 문자열
		String msg=tf_msg.getText();//메소드가 리턴해준 객체
		try {
			//필드에 있는 BufferedWriter 객체의 참조값을 이용해서 서버에 문자열 출력하기
			bw.write(chatName+" : "+msg);
			bw.newLine();//개행기호도 출력 (서버에서 줄단위로 읽어낼 예정)
			bw.flush();
		}catch(Exception ie) {
			ie.printStackTrace();
		}
		tf_msg.setText("");
		
	}
	
	//서버에서 불특정 시점에 도착하는 메세지를 받을 스레드
	public class ClientThread extends Thread{//서버로 부터 메세지가 오는지 감시하는 역할을 하는 스레드
		
		@Override
		public void run() {
			try {
				//서버로 부터 입력 받을수 있는 객체의 참조값 얻어오기
				InputStream is=socket.getInputStream();//외부 클래스에 필드와 메소드를 사용할수 있다.
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				while(true) {
					//서버로부터 문자열이 전송되는지 대기한다.
					String msg=br.readLine();
					area.append(msg);
					area.append("\r\n");// 개행 기호도 출력하기
					//최근 추가된 글 내용이 보일수 있도록
					int docLength=area.getDocument().getLength();
					area.setCaretPosition(docLength);
					if(msg==null) {
						break;
					}
				}
			}catch(Exception e) {
				
			}
		}//run 종료
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//눌러진 키의 코드값
		int code=e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {//만일 엔터키를 눌렀다면
			sendMessage();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}