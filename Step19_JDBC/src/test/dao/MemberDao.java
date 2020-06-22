
package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

/*
 *   DAO (Data Access Object)  의 약자
 *   
 *   - 만드는 방법
 *   
 *   1. 외부에서 객체 생성하지 못하도록 생성자의 접근 지정자를 private 로 지정
 *   2. 자신의 참조값을 저장할수 있는 필드를 private static 로 선언
 *   3. 자신의 참조값을 오직 하나만 생성해서 리턴해주는 static 메소드 만들기 
 *   4. 나머지 기능(select,insert,update,delete)들은 non static 으로 만들기. 
 *   
 *   dao 는 오직 하나만 만들게 한다. // static 으로 만들어서
 *   여러 객체를 만드는 것은 안좋음
 *   connection 객체는 수가 한정되있다.
 *   
 */
public class MemberDao {
	//자신의 참조값을 저장할 private 필드
	private static MemberDao dao;
	
	//외부에서 객체 생성하지 못하도록 한다. 
	private MemberDao() {}
	
	//참조값을 리턴해주는 메소드
	public static MemberDao getInstance() {//이전에 호출 됬었으면 null 이 아니다.
		if(dao==null) {//최초 호출되면 null 이므로 
			dao=new MemberDao();//객체를 생성해서 static 필드에 담는다. 
		}//null 이 아니면 그냥 리턴해주는 구조
		return dao;
	}
	//회원 한명의 정보를 리턴해주는 메소드
	public MemberDto getData(int num) {
		MemberDto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			String sql="select name, addr"
					+ " from  member"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				//MemberDto 객체 생성해서
				dto=new MemberDto();
				//회원 한명의 정보를 담는다.
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
	
	//회원 목록을 리턴해주는 메소드
	public List<MemberDto> getList(){
		//회원 목록을 담을 객체 생성
		List<MemberDto> list= new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;// select 문을 할거니까 필요
		try {
			//DBConnect 객체를 이용해서 connection 객체의 참조값을 얻어온다.
			conn=new DBConnect().getConn();
			//실행할 sql 문
			String sql="select num, name, addr"
					+ " from member"
					+ " order by num ASC";
			pstmt=conn.prepareStatement(sql);
			// quary 문 수행하고 결과 얻어오기
			rs=pstmt.executeQuery();
			//반복문 돌면서 select 된 회원정보 읽어오기
			while(rs.next()) {
				
				//회원정보를 list 에 담아 보세요.
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				//MemberDto 객체를 생성해서 회원 한명의 정보를 담는다.
				MemberDto dto=new MemberDto();
				dto.setNum(num);// MemberDto 에 필드가 private 로 되있어서 setNum
				dto.setName(name);
				dto.setAddr(addr);
				//MemberDto 객체를 List 에 누적 시킨다.
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//객체를 사용했던 순서 역순으로 닫아준다.
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
		
	}
	//회원 한명의 정보를 DB 에서 삭제하는 메소드
	public void delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=new DBConnect().getConn();
			String sql="delete from member"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
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
	}
	//회원 정보를 DB 에 저장하는 메소드 
	public void insert(MemberDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=new DBConnect().getConn();
			String sql="insert into member"
					+ " (num, name, addr)"
					+ " values (member_seq.nextval, ?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.executeUpdate();
			System.out.println("회원 정보를 추가 했습니다.");
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
	}
	//회원 정보를 DB 에서 수정하는 메소드
	public void update(MemberDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=new DBConnect().getConn();
			String sql="update member"
					+ " set name=?, addr=?"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			pstmt.executeUpdate();
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
	}
}