package chap16;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static void main(String[] args) {
		// 데이터 베이스 접속
		
		Connection conn = null;
		
		try {
			// DB 드라이브 로드
			Class.forName("org.mariadb.jdbc.Driver");
		
				conn = DriverManager.getConnection(
						"jdbc:mariadb://localhost:3306/mydb", // host
						"root", // 계정
						"1234" // 패스워드
						);
				if (conn != null) {
				System.out.println("conn : "+conn);
				System.out.println("접속 되었습니다.");
				} else {

				}
				
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		} finally {
			if (conn != null) try {
				conn.close();
			} catch (Exception e2) {}
		}
		
		
		
	}

}
