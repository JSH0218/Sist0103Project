package day0126;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracleDb.DbConnect;

public class QuizStuInfo {

	DbConnect db = new DbConnect();

	public void insert() {
		Scanner sc = new Scanner(System.in);
		String s_name, s_gender, s_age, s_hp;
		String sql = "";

		System.out.println("학생명을 입력하세요");
		s_name = sc.nextLine();
		System.out.println("성별을 입력하세요");
		s_gender = sc.nextLine();
		System.out.println("나이를 입력하세요");
		s_age = sc.nextLine();
		System.out.println("전화번호를 입력하세요");
		s_hp = sc.nextLine();

		sql = "insert into stuinfo values (seq_info.nextval,'" + s_name + "','" + s_gender + "','" + s_age + "','"
				+ s_hp + "',sysdate)";
		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("**데이터가 추가됨**");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}

	public void select() {
		String sql = "";

		sql = "select * from stuinfo";
		System.out.println("번호\t학생명\t성별\t나이\t연락처\t가입일");
		System.out.println("--------------------------------------------------");

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int s_no = rs.getInt("s_no");
				String s_name = rs.getString("s_name");
				String s_gender = rs.getString("s_gender");
				String s_age = rs.getString("s_age");
				String s_hp = rs.getString("s_hp");
				String gaipday = rs.getString("gaipday");

				System.out
						.println(s_no + "\t" + s_name + "\t" + s_gender + "\t" + s_age + "\t" + s_hp + "\t" + gaipday);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
	}

	public void delete() {
		Scanner sc = new Scanner(System.in);
		String no;
		String sql = "";

		System.out.println("삭제할 번호를 입력하세요");
		no = sc.nextLine();

		sql = "delete from stuinfo where s_no=" + no;

		Connection conn = null;
		Statement stmt = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			int a = stmt.executeUpdate(sql);

			if (a == 0) {
				System.out.println("삭제할 데이터가 없습니다");
			} else {
				System.out.println("**데이터가 삭제됨**");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}

	public boolean getOneDate(String s_no) {
		boolean flag = false;

		String sql = "select * from stuinfo where s_no=" + s_no;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}

		return flag;
	}

	public void update() {
		Scanner sc = new Scanner(System.in);
		String s_no, s_name, s_gender, s_age, s_hp;
		String sql = "";

		System.out.println("수정할 번호를 입력하세요");
		s_no = sc.nextLine();

		if (!this.getOneDate(s_no)) {
			System.out.println("해당번호는 존재하지 않습니다");
			return;
		}

		System.out.println("수정할 이름을 입력하세요");
		s_name = sc.nextLine();
		System.out.println("수정할 성별을 입력하세요");
		s_gender = sc.nextLine();
		System.out.println("수정할 나이를 입력하세요");
		s_age = sc.nextLine();
		System.out.println("수정할 번호를 입력하세요");
		s_hp = sc.nextLine();

		sql = "update stuinfo set s_name='" + s_name + "',s_gender='" + s_gender + "',s_age='" + s_age + "',s_hp='"
				+ s_hp + "' where s_no=" + s_no;

		Connection conn = null;
		Statement stmt = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("**데이터가 수정됨**");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}

	}

	public void find() {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String name;
		String sql = "";

		System.out.println("검색할 이름을 입력하세요");
		name = sc.nextLine();

		sql = "select * from stuinfo where s_name like '%" + name + "%'";

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int s_no = rs.getInt("s_no");
				String s_name = rs.getString("s_name");
				String s_gender = rs.getString("s_gender");
				String s_age = rs.getString("s_age");
				String s_hp = rs.getString("s_hp");
				String gaipday = rs.getString("gaipday");

				System.out
						.println(s_no + "\t" + s_name + "\t" + s_gender + "\t" + s_age + "\t" + s_hp + "\t" + gaipday);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizStuInfo qsi = new QuizStuInfo();
		Scanner sc = new Scanner(System.in);

		int n = 0;

		while (true) {
			System.out.println("**원하시는 기능을 선택하세요**");
			System.out.println("1.학생정보입력\t2.정보출력\t3.정보삭제\t4.학생정보수정\t5.학생검색\t9.종료");
			n = Integer.parseInt(sc.nextLine());

			if (n == 1) {
				qsi.insert();
			} else if (n == 2) {
				qsi.select();
			} else if (n == 3) {
				qsi.delete();
			} else if (n == 4) {
				qsi.update();
			} else if (n == 5) {
				qsi.find();
			} else if (n == 9) {
				System.out.println("**프로그램이 종료됩니다**");
				break;
			}
		}

	}

}
