package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemoDto;
import test.util.DBConnect;

public class MemoDao {
	private static MemoDao dao;
	
	private MemoDao() {
		
	}
	
	public static MemoDao getInstance() {
		if(dao==null) {
			dao=new MemoDao();
		}
		return dao;
	}
	
	//DB에 insert 하는 메소드
	public boolean insert(MemoDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="insert into memo"
					+ " (num, content, regdate)"
					+ " values (memo_seq.nextval, ?, sysdate)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
			flag=pstmt.executeUpdate();
			System.out.println("메모를 추가했습니다.");
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
	
	//DB 에서 delete 하는 메소드
	public boolean delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="delete from memo"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			flag=pstmt.executeUpdate();
			System.out.println("메모를 삭제했습니다.");
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
		
	}//delete()
	
	// DB 에 update(수정) 하는 메소드
	public boolean update(MemoDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="update memo"
					+ " set content=? "
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
			pstmt.setInt(2, dto.getNum());
			flag=pstmt.executeUpdate();
			System.out.println("메모를 수정했습니다.");
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
	
	//DB 에서 한가지의 메모만 select 하는 메소드
	public MemoDto getData(int num) {
		MemoDto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			String sql="select num, content, regdate"
					+ " from memo"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto=new MemoDto();
				dto.setNum(num);
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
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
	}//getDate()
	
	//memo 전체 리스트를 읽어오는 메소드
	public List<MemoDto> getList(){
		List<MemoDto> list=new ArrayList<MemoDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			//regdate 는 읽어올때 String 으로 읽어오기때문에 sql 문에서 문자로 바꿔준다. to_char로 하면 그게 칼럼명이 되므로 별칭을 주면 
			//rs로 읽어 올때 regdate로 읽어올수 있다.
			//to_chat 안에 yyyy 년 mm 월 으로 하고 싶을때 년을 넣는 방법은 " 앞에 \ 를 넣어주면 다른 문자를 넣는다고인식한다.
			//Frame 에 나타낼때 regdate 가 yyyy년 mm월 dd일 이런식으로 나타나게 한다.
			String sql="select num, content, to_char(regdate,'YYYY\"년\"MM\"월\"DD\"일\" AM HH\"시\"MI\"분\" ') as regdate"
					+ " from memo"
					+ " order by num asc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemoDto dto=new MemoDto();
				int num=rs.getInt("num");
				String content=rs.getString("content");
				String regdate=rs.getString("regdate");
				
				dto.setNum(num);
				dto.setContent(content);
				dto.setRegdate(regdate);
				
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
