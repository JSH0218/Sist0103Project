package stum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import oracleDb.DbConnect;

public class StuDbModel {

	DbConnect db = new DbConnect();

	public Vector<StumDto> selectStum() {

		Vector<StumDto> list = new Vector<StumDto>();

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from stum order by num";

		try {

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				StumDto dto = new StumDto();

				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setAvg(rs.getDouble("avg"));

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

	public void insertStum(StumDto dto) {

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		String sql = "insert into stum values (seq_stu.nextval,?,?,?,?,?)";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setDouble(5, (dto.getKor() + dto.getEng() + dto.getMat()) / 3.0);
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	public void deleteStum(String selectNum) {

		if (selectNum == null) {

			JOptionPane.showMessageDialog(null, "삭제할 데이터를 선택해 주세요");
			return;

		}

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		String sql = "delete from stum where num=?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectNum);
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	public void updateStum(String selectNum, StumDto dto) {

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		String sql = "update stum set name=?,kor=?,eng=?,mat=?,avg=? where num=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setDouble(5, (dto.getKor() + dto.getEng() + dto.getMat()) / 3.0);
			pstmt.setString(6, selectNum);
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}
	
	public ArrayList<String> selectUpdateStum(String selectNum) {
		
		ArrayList<String> list=new ArrayList<String>();
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		String sql = "select * from stum where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, selectNum);
			rs=pstmt.executeQuery();
			
			StumDto dto=new StumDto();
			
			if(rs.next()) {
				list.add(rs.getString("name"));
				list.add(String.valueOf(rs.getInt("kor")));
				list.add(String.valueOf(rs.getInt("eng")));
				list.add(String.valueOf(rs.getInt("mat")));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
		
	}

}
