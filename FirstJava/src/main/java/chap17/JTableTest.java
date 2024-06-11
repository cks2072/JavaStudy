package chap17;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest extends JFrame {
	
	JTable table;
	Object[] columnsNames = {"사번", "이름", "근무부서"};
	String[][] data = {
			{"220000", "박길동", "총무부"},
			{"220001", "홍길동", "관리부"},
			{"220002", "이순신", "회계부"},
			{"220003", "강감찬", "개발부"},
			{"220004", "이재성", "총무부"},
			{"220005", "이몽룡", "총무부"},
			{"220006", "성춘향", "영업부"},
			{"220007", "김유신", "영업부"},
			{"220008", "손흥민", "개발부"},
			{"220009", "매디슨", "총무부"},
			{"220010", "솔로몬", "회계부"},
			{"220011", "이강인", "관리부"},
			{"220012", "에릭센", "관리부"},
			{"220013", "황희찬", "영업부"}
	};
	
	public JTableTest() {
		table = new JTable(data, columnsNames); // 배열을 TableModel로 이용해서 JTable 생성
		setTitle("사원 정보 테이블");
		add(new JScrollPane(table)); // 스크롤 객체 테이블을 추가
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 컬럼의 사이즈 조절시 양쪽 컬럼의 사이즈도 변경
		// table.setAutoResizeMode(table.AUTO_RESIZE_ALL_COLUMNS); 
		
		// 컬럼의 사이즈 조절시 마지막 컬럼의 크기만 변경
		 table.setAutoResizeMode(table.AUTO_RESIZE_LAST_COLUMN);
		
		// 컬럼의 사이즈 조절시 다음열의 크기만 변경
		// table.setAutoResizeMode(table.AUTO_RESIZE_NEXT_COLUMN);
		
		// 컬럼의 사이즈를 자동으로 조절하지 않고, 스크롤바를 이용
		// table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		
		// 테이블을 초함하는 화면 크기 조절시 모든 테이블의 열의 크기를 균등하게 유지 : 기본 속성
		// table.setAutoResizeMode(table.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		
		
		pack();
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// JTable : 데이터를 목록
		// TableModel 작성 -> 스크롤 기능 있는 테이블 (JTable 작성 -> JScrollPanel에 JTable 추가) -> Container에 추가
		
		JTableTest table = new JTableTest();
		
	}

}
