package quiz.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import info.model.InfoDto;
import oracle.db.DbConnect;

public class quizDao {
	
	DbConnect db=new DbConnect();

	public void insertInfo(quizDto dto) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into quizinfo values(seq_1.nextval,?,?,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getHp());
			pstmt.setString(3, dto.getAge());
			pstmt.setString(4, dto.getDriver());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public Vector<quizDto> getAllDatas() {
		Vector<quizDto> list=new Vector<quizDto>();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from quizinfo order by no";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				quizDto dto=new quizDto();
				
				dto.setNo(rs.getString("no"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setHp(rs.getString("hp"));
				dto.setDriver(rs.getString("driver"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public void deleteInfo(String no) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="delete from quizinfo where no=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, no);
			//업데이트
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public quizDto getData(String no) {
		quizDto dto=new quizDto();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from quizinfo where no=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs=pstmt.executeQuery();
			
			//수정하려는 1개의 데이터 조회
			if(rs.next()) {
				dto.setNo(rs.getString("no"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setHp(rs.getString("hp"));
				dto.setDriver(rs.getString("driver"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	public void updateInfo(quizDto dto) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="update quizinfo set name=?, age=?, hp=?, driver=? where no=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//?바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAge());
			pstmt.setString(3, dto.getHp());
			pstmt.setString(4, dto.getDriver());
			pstmt.setString(5, dto.getNo());
			
			//업데이트
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

}
