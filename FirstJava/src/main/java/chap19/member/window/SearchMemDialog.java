package chap19.member.window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import chap19.common.RentTableModel;
import chap19.member.controller.MemberController;
import chap19.member.vo.MemberVO;

public class SearchMemDialog extends JDialog {

	JPanel panelSearch, panelBtn;
	JLabel lMemName;
	JTextField tf;
	
	JButton btnSearch;
	JButton btnReg;
	JButton btnModify;
	JButton btnDelete;

	JTable memTable;
	
	// 테이블 UI 모델 객체
	RentTableModel rentTableModel;
	
	String[] columnNames = {"아이디","비밀번호","이름","전화번호","주소"};
	
	Object[][] memItems = new String[0][5];
	int rowIdx = 0, colIdx = 0;

	// 회원 관리 컨트롤러
	MemberController memberController;
	
	// 생성자
	public SearchMemDialog (MemberController memberController, String str) {
		this.memberController = memberController;
		
		setTitle(str); // 다이얼 창의 제목
		init(); // UI 객체 생성 메서드 호출
		
	}
	
	//UI 객체 생성 메서드
	public void init() {
		memTable = new JTable();
		
		ListSelectionModel rowSel = memTable.getSelectionModel();
		rowSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ListSelectionModel colSel = memTable.getColumnModel().getSelectionModel();
		colSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panelSearch = new JPanel();
		panelBtn = new JPanel();
		
		lMemName = new JLabel("이름");
		tf = new JTextField(15);
		btnSearch = new JButton("조회하기");
		
		// 검색 UI
		panelSearch.add(lMemName);
		panelSearch.add(tf);
		panelSearch.add(btnSearch);
		
		btnReg = new JButton("회원 등록하기");
		btnModify = new JButton("수정하기");
		btnDelete = new JButton("삭제하기");
		
		// 각 버튼 이벤트 핸들러
		btnReg.addActionListener(new MemberBtnHandler());
		btnModify.addActionListener(new MemberBtnHandler());
		btnDelete.addActionListener(new MemberBtnHandler());
		btnSearch.addActionListener(new MemberBtnHandler());
		
		// 버튼 관련 UI
		panelBtn.add(btnDelete);
		panelBtn.add(btnModify);
		panelBtn.add(btnReg);
		
		// Table 설정
		rentTableModel = new RentTableModel(memItems, columnNames);
		memTable.setModel(rentTableModel);
		
		// 테이블 이벤트 핸들러
		rowSel.addListSelectionListener(new ListRowSelectionHandler());
		colSel.addListSelectionListener(new ListColSelectionHandler());
		
		
		// 각 panel 배치
		add(panelSearch, BorderLayout.NORTH);
		add(new JScrollPane(memTable), BorderLayout.CENTER);
		add(panelBtn, BorderLayout.SOUTH);
		
		setLocation(300, 100);
		setSize(800,600);
		setModal(true);
		setVisible(true);
		
	}
	
	private void loadTabelDate(List<MemberVO> memList) {
		// 넘겨받은 회원 정보 List 에 회원 정보가 있으면 처리
		if (memList!= null && memList.size() != 0) {
			// 회원 정보-> 테이블 데이터로 전환
			memItems = new String[memList.size()][5];
			
			for (int i=0; i<memList.size(); i++) {
				MemberVO memVO = memList.get(i);
				
				memItems[i][0] = memVO.getMemId();
				memItems[i][1] = memVO.getMemPassword();
				memItems[i][2] = memVO.getMemName();
				memItems[i][3] = memVO.getMemAddress();
				memItems[i][4] = memVO.getMemPhoneNum();
				
			}
			
			rentTableModel = new RentTableModel(memItems, columnNames);
			memTable.setModel(rentTableModel);
			
		} else {
			// 전달 받은 데이터가 없는 경우
			message("조회한 정보가 없습니다.");
			
			memItems = new Object[10][0];
			
			rentTableModel = new RentTableModel(memItems, columnNames);
			memTable.setModel(rentTableModel);
		}
		
	}
	
	// 메시지 전달 메서드
	private void message(String msg) {
		JOptionPane.showMessageDialog(this, msg, "메시지 박스", JOptionPane.INFORMATION_MESSAGE);
	}
	
	// 회원 관리 이벤트 처리 클래스
	class MemberBtnHandler implements ActionListener {
		
		String memId = null;
		String memPassword = null;
		String memName = null;
		String memAddress = null;
		String memPhoneNum = null;
		
		List<MemberVO> memList = null; 
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// 조회버튼 클릭할 경우
			if (e.getSource() == btnSearch) {
				
				String name = tf.getText().trim();
				
				memList = new ArrayList<MemberVO>();
				MemberVO memVO = new MemberVO();
				
				if (name != null && name.length() != 0) {
					memVO.setMemName(name); // 이름 기준 조회
					
					// 조회요청
					memList = memberController.listMember(memVO);
					
					if (memList != null && memList.size() != 0) { // 검색결과 값이 있을경우
						loadTabelDate(memList);
					} else if (memList == null || memList.size() == 0) { // 검색 결과 값이 없을 경우
						loadTabelDate(null);
					}
					// memList.stream().forEach(System.out::println);
					
				} else {
					// 전체 조회
					memList = memberController.listMember(memVO);
					loadTabelDate(memList);
					// memList.stream().forEach(System.out::println);
				}
				
				tf.setText("");
				return;
				
			} else if (e.getSource() == btnReg) {
				// 회원 등록 대화창 생성
				new RegMemDialog(memberController, "회원 등록창");
				return;
				
			} else if (e.getSource() == btnModify) {
				memId = (String) memItems[rowIdx][0];
				memPassword = (String) memItems[rowIdx][1];
				memName = (String) memItems[rowIdx][2];
				memAddress = (String) memItems[rowIdx][3];
				memPhoneNum = (String) memItems[rowIdx][4];
				
				MemberVO memVO = new MemberVO(memId, memPassword, memName, memAddress, memPhoneNum);
				System.out.println("수정할 회원 선택 : "+memVO);
				
				memberController.modMember(memVO);
				
				return ; 
				
				
			} else if (e.getSource() == btnDelete) {
				memId = (String) memItems[rowIdx][0];
				memPassword = (String) memItems[rowIdx][1];
				memName = (String) memItems[rowIdx][2];
				memAddress = (String) memItems[rowIdx][3];
				memPhoneNum = (String) memItems[rowIdx][4];
				
				MemberVO memVO = new MemberVO(memId, memPassword, memName, memAddress, memPhoneNum);
				System.out.println("삭제할 회원 선택 : "+memVO);
				
				memberController.removeMember(memVO);
			
				return ;
				
			}
			
		} // end actionPerformed()
		
	} // end class
	
	// 테이블 행 클릭 이벤트 처리
	class ListRowSelectionHandler implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			if (!e.getValueIsAdjusting()) {
				
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				rowIdx = lsm.getMinSelectionIndex();
				System.out.println(rowIdx+" 번째 행이 선택됨");
				
			}
			
		}
		
	}
	
	class ListColSelectionHandler implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			ListSelectionModel lsm = (ListSelectionModel)e.getSource();
			colIdx = lsm.getMinSelectionIndex();
			
			if (!e.getValueIsAdjusting()) {
				System.out.printf(rowIdx+" 번째 행, "+colIdx+" 열 선택됨 ");
			}
			
		}
		
	}
	
}
