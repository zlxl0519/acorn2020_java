package example5;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

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
	static List<ServerThread> threadList=new ArrayList<>();//하나하나씩 chatName 으로 쓴 내용이 들어있다.
	public static void main(String[] args) {
		// 필요한 객체를 저장할 지역변수 미리 만들기
		ServerSocket serverSocket=null;
		Socket socket=null;
		try {
			// 5000 번 통신 port 을 열고 클라이언트의 접속을 기다린다.
			serverSocket=new ServerSocket(5000);
			while(true) {
				System.out.println("클라이언트의 Socket 연결 요청을 대기합니다.");
				//클라이언트의 소켓 접속을 기다린다.
				socket=serverSocket.accept();// 접속한 클라이언트와 1대1로 연결되있는것.
				System.out.println("클라이언트가 접속을 했습니다.");
				//방금 접속한 클라이언트를 응대할 스레드를 시작시킨다.
				ServerThread thread=new ServerThread(socket);
				thread.start();
				//생성하고 시작한 스레드의 참조값을 List에 저장하기
				threadList.add(thread);// 서버스레드 참조값을 넣어놓은 리스트
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
		//클라이언트의 대화명을 저장할 필드
		String chatName;
		
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
		
		//참여자 목록을 얻어내서 Client 에게 출력해주는 메소드
		public void sendChatNameList() {
			//4. 참여자 목록 메세지
			// {"type":"members", "list":["김구라", "해골", "원숭이"]}
			JSONObject jsonObj=new JSONObject();
			JSONArray jsonArr=new JSONArray();
			// 샘플 [ "김구라", "해골", "원숭이" ]
			//jsonArr.put(0, "김구라");
			//jsonArr.put(1, "해골");
			//jsonArr.put(2, "원숭이");
			
			// 스레드 리스트에서 대화명을 순서대로 참조해서 JSONArray 객체에 순서대로 넣기
			for(int i=0; i<threadList.size(); i++) {
				ServerThread tmp=threadList.get(i);
				jsonArr.put(i, tmp.chatName);
			}
			
			jsonObj.put("type", "members");
			jsonObj.put("list", jsonArr);
			
			try {
				sendMessage(jsonObj.toString());//{"type" : "members","list" : []}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		// 새로운 스레드를 호출하려면 new ServerThread().start();
		//새로운 작업 단위가 시작되는 run() 메소드
		@Override
		public void run() {
			try {
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
					//클라이언트가 전송하는 문자열을 읽어낸다.
					String msg=br.readLine(); // 메세지를 전송할때까지 기다린다.
					//전송된 JSON 문자열을 사용할 준비를 한다.
					JSONObject jsonObj=new JSONObject(msg);
					//type 을 읽어낸다.
					String type=jsonObj.getString("type");
					if(type.equals("enter")) {
						//현재 스레드가 대응하는 클라이언트의 대화명을 필드에 저장한다.
						String chatName=jsonObj.getString("name");
						this.chatName=chatName;
						//대화명 목록을 보내준다.
						sendChatNameList();
					}
					
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
				// this 가 퇴장 한다고 메세지를 보낸다.
				try {
					JSONObject jsonObj=new JSONObject();
					jsonObj.put("type", "out");
					jsonObj.put("name", chatName);
					sendMessage(jsonObj.toString());
					//대화명 목록을 보내준다.
					sendChatNameList();
					if(socket!=null)socket.close();
				}catch(Exception e) {}
			}//finally 종료
		}//run() 종료
	}
}
