package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * 	JDBC ( Java DataBase Connectivity )
 * 
 * 	DataBase 에 연결해서 SELECT, INSERT, UPDATE, DELETE 작업하기
 * 
 * 	Oracle 에 연결하기 위해서는 드라이버 클래스가 들어있는 ojdbc6.jar 파일을
 * 	사용할수 있도록 설정해야 한다.
 */
public class MainClass01 {
	public static void main(String[] args) {
		//DB 연결객체를 담을 지역변수 만들기
		Connection conn=null;
		try {
			//오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB 의 정보 @아이피주소:port 번호 :db 이름//jdbc:oracle:thin: 이거는 하나의 형식
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "scott", "tiger");// DriverManager 은 static class
			//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//SELECT 작업을 위해서 필요한 객체의 참조값을 담을 지역변수 만들기
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//실행할 sql 문
			String sql="SELECT num,name,addr FROM member"// query 문
					+" ORDER BY num ASC";// 공백이 없으면  SELECT num, name, addr FROM memberORDER BY 라고 인식한다.
				//그래서 새로운 줄 시작할때는 " 띄고 시작
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql); //실행할 sql 문 준비
			//PreparedStatement 객체를 이용해서 query 문 수행하고 결과를
			//ResultSet 객체로 받아오기
			rs=pstmt.executeQuery(); //자바는 결과 데이터를 ResultSet 으로 받아온다. 
			while(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				//출력하기
				System.out.println(num+" | "+name+" | "+addr);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
