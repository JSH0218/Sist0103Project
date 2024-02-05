package day0125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuizJdbcFoodOrder {

	static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	public void foodOrder() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select j.order_num num,f.fno fno,j.order_name oname,f.food_name fname,"
				+ "to_char(f.price,'L999,999,999') price,f.f_shopname sname,f.shop_loc sloc,"
				+ "j.order_addr oaddr from foodshop f,jumun j where f.fno=j.fno order by j.order_name";

		try {
			conn = DriverManager.getConnection(URL, "stu", "a1234");

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("주문번호\t음식번호\t주문자\t음식명\t가격\t상호명\t상점위치\t주문자위치");
			System.out.println("----------------------------------------------------------------------");
			while (rs.next()) {
				int order_num = rs.getInt("num");
				int fno = rs.getInt("fno");
				String order_name = rs.getString("oname");
				String food_name = rs.getString("fname");
				String price = rs.getString("price");
				String f_shopname = rs.getString("sname");
				String shop_loc = rs.getString("sloc");
				String order_addr = rs.getString("oaddr");

				System.out.println(order_num + "\t" + fno + "\t" + order_name + "\t" + food_name + "\t" + price + "\t"
						+ f_shopname + "\t" + shop_loc + "\t" + order_addr);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizJdbcFoodOrder qjfo = new QuizJdbcFoodOrder();
		qjfo.foodOrder();

	}

}
