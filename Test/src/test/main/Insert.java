package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

public class Insert {
	public static void main(String[] args) {
		/*
		 * 	member2 테이블에 추가할 회원의 정보
		 * 	김구라, 노량진
		 * 	회원의 번호는 시퀀스 객체를 이용해서 넣기
		 * 	시퀀스 명 : member_seq
		 * 
		 */
		String name="김구라";
		String addr="노량진";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=new DBConnect().getConn();
			String sql="insert into member2"
					+ " (num, name, addr)"
					+ " values (mem_seq.nextval, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.executeUpdate();
			System.out.println("회원정보가 추가되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}
