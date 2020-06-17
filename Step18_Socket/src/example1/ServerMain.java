package example1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public static void main(String[] args) {
		// 필요한 객체를 저장할 지역변수 미리 만들기
		ServerSocket serverSocket=null;
		Socket socket=null;
		try {
			// 5000 번 통신 port 을 열고 클라이언트의 접속을 기다린다.
			serverSocket=new ServerSocket(5000);
			System.out.println("클라이언트의 Socket 연결 요청을 대기합니다.");
			/*
			 * 	accept() 메소드는 클라이언트가 실제 접속을 할때 까지 리턴하지 않고 
			 * 	블록킹 되는 메소드 이다.
			 * 	클라이언트가 접속을 해오면 Socket 객체의 참조값을 반환하면서 리턴된다.
			 */
			socket=serverSocket.accept();// 접속한 클라이언트와 1대1로 연결되있는것.
			System.out.println("클라이언트가 접속을 했습니다.");
			//클라이언트 ip 주소
			String clientIp=socket.getInetAddress().getHostAddress();
			System.out.println("접속한 클라이언트의 아이피: "+clientIp);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket!=null)serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//finally 종료
	}//main 
}
