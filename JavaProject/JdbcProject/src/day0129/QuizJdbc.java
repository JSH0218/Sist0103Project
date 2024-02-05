package day0129;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracleDb.DbConnect;

public class QuizJdbc {

	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);

	public void process() {
		while (true) {
			System.out.println("\t\t\t\t[사원관리 프로그램]\t\t\t\t");
			System.out.println();
			System.out.println("1.사원정보입력\t2.사원정보출력\t3.사원정보삭제\t4.사원정보수정\t5.사원정보검색\t9.종료");
			int num = Integer.parseInt(sc.nextLine());

			switch (num) {
			case 1:
				this.insertMember();
				break;
			case 2:
				this.writeMember();
				break;
			case 3:
				this.deleteMember();
				break;
			case 4:
				this.updateMember();
				break;
			case 5:
				this.searchMember();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			default:
				System.out.println("잘못된 번호를 입력하셨습니다");
			}
		}
	}

	public void insertMember() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		System.out.println("사원이름을 입력하세요");
		String s_name = sc.nextLine();
		System.out.println("부서를 입력하세요");
		String buseo = sc.nextLine();
		System.out.println("직급을 입력하세요");
		String position = sc.nextLine();
		System.out.println("성별을 입력하세요");
		String gender = sc.nextLine();
		System.out.println("급여를 입력하세요");
		int pay = Integer.parseInt(sc.nextLine());
		System.out.println("보너스를 입력하세요");
		int bonus = Integer.parseInt(sc.nextLine());

		String sql = "insert into sawonmember values (seq_s.nextval,?,?,?,?,?,?,sysdate)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_name);
			pstmt.setString(2, buseo);
			pstmt.setString(3, position);
			pstmt.setString(4, gender);
			pstmt.setInt(5, pay);
			pstmt.setInt(6, bonus);
			pstmt.execute();

			System.out.println("추가되었습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	public void writeMember() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select s_no,s_name,buseo,position,gender,to_char(pay,'L999,999,999'),to_char(bonus,'L999,999,999'),ipsaday from sawonmember";

		System.out.println("번호\t이름\t부서\t직급\t성별\t급여\t보너스\t입사일");
		System.out.println("--------------------------------------------------");

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("s_no") + "\t" + rs.getString("s_name") + "\t" + rs.getString("buseo")
						+ "\t" + rs.getString("position") + "\t" + rs.getString("gender") + "\t"
						+ rs.getString("to_char(pay,'L999,999,999')") + "\t"
						+ rs.getString("to_char(bonus,'L999,999,999')") + "\t" + rs.getDate("ipsaday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}

	public void deleteMember() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		System.out.println("삭제할 사원정보의 번호를 입력해주세요");
		String s_no = sc.nextLine();

		String sql = "delete from sawonmember where s_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_no);
			int n = pstmt.executeUpdate();

			if (n == 1)
				System.out.println("삭제되었습니다");
			else
				System.out.println("없는 번호입니다");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	public boolean isOneDate(String s_no) {
		boolean flag = false;

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawonmember where s_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_no);
			rs = pstmt.executeQuery();

			if (rs.next())
				flag = true;
			else
				flag = false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return flag;
	}

	public void updateMember() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		System.out.println("수정할 사원정보의 번호를 입력하세요");
		String s_no = sc.nextLine();

		if (!this.isOneDate(s_no)) {
			System.out.println("없는 사원번호입니다");
			return;
		}

		System.out.println("사원이름을 입력하세요");
		String s_name = sc.nextLine();
		System.out.println("부서를 입력하세요");
		String buseo = sc.nextLine();
		System.out.println("직급을 입력하세요");
		String position = sc.nextLine();
		System.out.println("성별을 입력하세요");
		String gender = sc.nextLine();
		System.out.println("급여를 입력하세요");
		int pay = Integer.parseInt(sc.nextLine());
		System.out.println("보너스를 입력하세요");
		int bonus = Integer.parseInt(sc.nextLine());

		String sql = "update sawonmember set s_name=?,buseo=?,position=?,gender=?,pay=?,bonus=? where s_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_name);
			pstmt.setString(2, buseo);
			pstmt.setString(3, position);
			pstmt.setString(4, gender);
			pstmt.setInt(5, pay);
			pstmt.setInt(6, bonus);
			pstmt.setString(7, s_no);
			pstmt.execute();

			System.out.println("수정되었습니다");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	public void searchMember() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("정보를 검색할 사원의 이름을 입력하세요");
		String s_name = sc.nextLine();

		String sql = "select s_no,s_name,buseo,position,gender,to_char(pay,'L999,999,999'),to_char(bonus,'L999,999,999'),ipsaday from sawonmember where s_name like ?";

		System.out.println("번호\t이름\t부서\t직급\t성별\t급여\t보너스\t입사일");
		System.out.println("--------------------------------------------------");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + s_name + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("s_no") + "\t" + rs.getString("s_name") + "\t" + rs.getString("buseo")
						+ "\t" + rs.getString("position") + "\t" + rs.getString("gender") + "\t"
						+ rs.getString("to_char(pay,'L999,999,999')") + "\t"
						+ rs.getString("to_char(bonus,'L999,999,999')") + "\t" + rs.getDate("ipsaday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizJdbc sawon = new QuizJdbc();
		sawon.process();

	}

}
