package example1;

import java.io.IOException;
import java.net.Socket;

public class ClientMain {
	public static void main(String[] args) {
		Socket socket=null;
		try {
			//이 Ip 주소로 socket 접속하는 방법
			socket=new Socket("192.168.0.30",5000);
			System.out.println("Socket 연결 성공!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket!=null)socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//finally
		System.out.println("main 메소드가 종료됩니다.");
	}
}