package chap16.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import chap16.vo.MemberVO;

public class MemberDAO {
	// 데이터 베이스 관련 객체
	Connection conn = null;
	Statement stmt = null; // sql 문장 처리 하는 객체
	Result rs = null; // query 결과값 처리 하는 객체
	
	// 생성자 : db접속
	public MemberDAO() {
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
	
	// 데이터 입력
	public int insert(MemberVO vo) {
		int result = 0;
		try {
			String sql = "insert into member (memberno, id, name)"+
					" values ("+vo.getMemberno()+",'"+vo.getId()+"','"+vo.getName()+"')";
			
			System.out.println("sql : "+sql);
					
			stmt = conn.createStatement(); // sql 문장을 처리할 객체
			System.out.println("stmt : "+stmt);
			result = stmt.executeUpdate(sql);
			
		} catch (Exception e) {}
		
		return result;
		
	}
	// 데이터 조회
	
	// 데이터 수정
	
	// 데이터 삭제
	
	// 회원 목록
	public List<MemberVO> list() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			String sql = "select * from member";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
