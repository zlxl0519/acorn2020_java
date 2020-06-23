package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.Member2Dto;
import test.util.DBConnect;

public class Member2Dao {
	//필드 다른데서 사용하지 못하고 static 영역에 하나만생기도록
	private static Member2Dao dao;
	
	//생성자 다른데서 사용하지 못하도록  private
	private Member2Dao() {}
	
	//클래스를 생성하기위해 필요한 메소드
	public static Member2Dao getInstance() {
		if(dao==null) {//dao 가 처음 만들어져서 아무값이 안들어져있으면
			dao=new Member2Dao(); // 필드에 생성한다.
		}
		return dao;// 값이 있으면 dao 그걸 리턴한다.
	}
	
	//DB 에 데이터를 저장, 수정, 삭제, 한명의 데이터를 가져오는것, 리스트를 보는것 메소드
	
	//1. 저장메소드(insert)
	public boolean insert(Member2Dto dto) {//이걸 쓰기전에 넣을 데이터를 dto에 set 하고 사용하는메소드
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="insert into member2"
					+ " (num, name, addr)"
					+ " values (mem_seq.nextval, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보가 추가되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}//insert()
	
	//2. 수정메소드(update)
	public boolean update(Member2Dto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="update member2"
					+ " set name=?, addr=?"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			flag=pstmt.executeUpdate();
			System.out.println("회원정보가 수정되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}//update()
	
	//3. 삭제메소드(delete)
	public boolean delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="delete from member2"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보를 삭제 했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}//delete ()
	
	//4. 한명의 데이터를 가져오는 메소드 (getData())
	public Member2Dto getData(int num) {
		Member2Dto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			String sql="select num, name, addr"
					+ " from member2"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto=new Member2Dto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	//5. 데이터 리스트를 가져오는 메소드(getList)
	public List<Member2Dto> getList(){
		List<Member2Dto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			String sql="select num, name, addr"
					+ " from member2"
					+ " order by num asc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				Member2Dto dto=new Member2Dto();
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
