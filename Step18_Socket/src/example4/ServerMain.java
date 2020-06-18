package example4;

import java.util.List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMain {//통신관련 동작만 있다.
	//필드
	static List<ServerThread> threadList=new ArrayList<>();
	public static void main(String[] args) {
		// 필요한 객체를 저장할 지역변수 미리 만들기
		ServerSocket serverSocket=null;
		Socket socket=null;
		try {
			// 5000 번 통신 port 을 열고 클라이언트의 접속을 기다린다.
			serverSocket=new ServerSocket(5000);
			/*
			 * 	accept() 메소드는 클라이언트가 실제 접속을 할때 까지 리턴하지 않고 
			 * 	블록킹 되는 메소드 이다.
			 * 	클라이언트가 접속을 해오면 Socket 객체의 참조값을 반환하면서 리턴된다.
			 */
			while(true) {
				System.out.println("클라이언트의 Socket 연결 요청을 대기합니다.");
				socket=serverSocket.accept();// 접속한 클라이언트와 1대1로 연결되있는것.
				System.out.println("클라이언트가 접속을 했습니다.");
				//방금 접속한 클라이언트를 응대할 스레드를 시작시킨다.
				ServerThread thread=new ServerThread(socket);
				thread.start();
				//생성하고 시작한 스레드의 참조값을 List에 저장하기
				threadList.add(thread);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket!=null)serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//finally 종료
	}//main 종료
	//내부 클래스로 스레드 객체를 생성할 클래스를 정의한다.
	//static main() 메소드에서 클래스를 사용하기 위해 static 예약어를 붙여서 정의한다.
	public static class ServerThread extends Thread{
		//필드
		Socket socket;
		//클라이언트에게 출력할수 있는 문자열이 있는 객체
		BufferedWriter bw;
		
		//생성자의 인자로 Socket 객체를 전달받도록 한다.
		public ServerThread(Socket socket) {
			//생성자의 인자로 전달 받은 Socket 객체의 참조값을 필드에 저장한다.
			this.socket=socket;
		}
		
		//인자로 전달된 문자열을 Socket을 통해서 출력하는 메소드
		public void sendMessage(String msg) throws IOException {
			//반복문 돌면서 모든 스레드의 BufferedWriter 객체를 이용해서
			//문자열을 전송한다.
			for(ServerThread tmp:threadList) {
				tmp.bw.write(msg); //문자열 출력
				tmp.bw.newLine(); //개행기호 출력
				tmp.bw.flush(); //방출
			}
		}
		
		// 새로운 스레드를 호출하려면 new ServerThread().start();
		//새로운 작업 단위가 시작되는 run() 메소드
		@Override
		public void run() {
			try {
				//클라이언트 ip 주소
				String clientIp=socket.getInetAddress().getHostAddress();
				System.out.println("접속한 클라이언트의 아이피: "+clientIp);
				//클라이언트로 부터 읽어들일 (input) 객체의 참조값 얻어오기
				InputStream is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				
				//클라이언트에게 출력할수 있는 객체
				OutputStream os= socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os);
				//BufferedWriter 객체의 참조값을 필드에 저장하기
				bw=new BufferedWriter(osw);
				
				while(true) {
					/*
					 * 	클라이언트가 문자열을 한줄 (개행기호와 함께) 보내면
					 * 	readLine() 메소드가 리턴 하면서 보낸 문자열을 가지고 온다.
					 * 	보내지 않으면 계속 블로킹 되어서 대기하고 있다가
					 * 	접속이 끈기면 Exception 이 발생하거나 혹은 null 이 
					 * 	리턴 된다.
					 * 	따라서 null 이 리턴되면 반복문을 빠져 나가게 break 문을 만나도록
					 * 	한다.
					 * 	실행순서가 try 블럭을 벗어나면 run() 메소드가 리턴하게 되고
					 * 	run() 메소드가 리턴되면 해당 스레드는 종료가 된다.
					 */
					String msg=br.readLine(); // 메세지를 전송할때까지 기다린다.
					System.out.println("메세지:"+msg);
					
					//클라이언트에게 동일한 메세지를 보내는 메소드를 호출한다.
					sendMessage(msg);
					
					if(msg==null) {// 클라이언트의 접속이 끈겼기 때문에
						break;//반복문(while)을 빠져 나오도록 한다.
					}
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				//접속이 끈겨서 종료되는 스레드는 List에서 제거한다.
				threadList.remove(this); // 인덱스로 삭제도 되고 참조값을 찾아서 remove 하는 것도 있다.
				try {
					if(socket!=null)socket.close();
				}catch(Exception e) {}
			}//finally 종료
		}//run() 종료
	}
}
