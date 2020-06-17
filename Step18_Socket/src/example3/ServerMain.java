package example3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
			while(true) {
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
				//클라이언트로 부터 읽어들일 (input) 객체의 참조값 얻어오기
				InputStream is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				//클라이언트가 전송한 문자열 한줄 읽어들이기
				String msg=br.readLine();
				System.out.println("메세지:"+msg);
				socket.close();
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
	}//main 
}
