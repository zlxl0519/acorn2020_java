package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		 * 	member 테이블에 추가할 회원의 정보
		 * 	김구라, 노량진
		 * 	회원의 번호는 시퀀스 객체를 이용해서 넣기
		 * 	시퀀스 명 : member_seq
		 * 
		 */
		int num=1;
		String name="김구라";
		String addr="노량진";
		
		//DB 연결객체를 담을 지역변수 만들기
		Connection conn=null;
		try {
			//오라클 드라이버 로딩// 최초한번만 하면 된다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB 의 정보 @아이피주소:port 번호 :db 이름//jdbc:oracle:thin: 이거는 하나의 형식
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기 // url, 계정, 비밀번호가 맞아야 연결된다.
			conn=DriverManager.getConnection(url, "scott", "tiger");// 틀리면 sql exception 이 뜬다.
			//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		//필요한 객체의 참조값을 담을 빈 지역 변수 미리 만들기
		PreparedStatement pstmt=null;
		try {
			//실행할 sql 문
			String sql= "insert into member"
					+ " (num, name, addr)"
					+ " values(member_seq.NEXTVAL, ?, ?)";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//? 에 값을 바인딩해서 미완성의 sql 문을 완성 시킨다.
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			// 실제로 수행하기
			pstmt.executeUpdate();
			System.out.println("회원 정보를 저장했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
				try {
					//안전하게 마무리 작업하기
					if(pstmt!=null)pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
