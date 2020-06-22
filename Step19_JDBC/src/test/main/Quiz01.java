package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Quiz01 {
	public static void main(String[] args) {
		/*
		 *  2, 해골, 행신동 이라는 정보를
		 * 	member table 에 추가 해 보세요.
		 */
		int num=2;
		String name="해골";
		String addr="행신동";
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
		
		String sql= "insert into member"
				+" (num, name, addr)"
				+" valuse(?, ? ,?)";
		PreparedStatement pstm=null;
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, num);
			pstm.setString(2, name);
			pstm.setString(3, addr);
			pstm.executeUpdate();
			System.out.println("회원 정보를 저장했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null)pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
