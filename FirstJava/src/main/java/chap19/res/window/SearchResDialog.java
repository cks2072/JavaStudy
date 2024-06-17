package chap19.res.window;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import chap19.common.RentTableModel;
import chap19.res.controller.ResController;
import chap19.res.vo.ResVO;

public class SearchResDialog extends JDialog {

	JPanel panelSearch, panelBtn;
	JLabel lResName;
	JTextField tf;
	
	JButton btnSearch;
	JButton btnReg;
	JButton btnModify;
	JButton btnDelete;
	
	JTable resTable;
	RentTableModel rentTableModel;
	
	String[] columnNames = {"예약번호","예약차번호","예약날짜","예약시작날짜","예약종료날짜","고객ID"};
	
	Object[][] resItems = new String[0][5];
	int rowIdx = 0, colIdx = 0;
	
	ResController resController;
	
	public SearchResDialog(ResController resController, String str) {
		this.resController = resController;
		
		setTitle(str);
		init();
		
	}
	
	public void init() {
		resTable = new JTable();
		
		ListSelectionModel rowSel = resTable.getSelectionModel();
		rowSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ListSelectionModel colSel = resTable.getSelectionModel();
		colSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panelSearch = new JPanel();
		panelBtn = new JPanel();
		
		lResName = new JLabel("예약자명");
		tf = new JTextField(15);
		btnSearch = new JButton("조회하기");
		
		panelSearch.add(lResName);
		panelSearch.add(tf);
		panelSearch.add(btnSearch);
		
		btnReg = new JButton("예약등록하기");
		btnModify = new JButton("예약수정하기");
		btnDelete = new JButton("예약삭제하기");
		
//		btnReg.addActionListener(new CarBtnHandler());
//		btnModify.addActionListener(new CarBtnHandler);
//		btnDelete.addActionListener(new CarBtnHandler);
//		btnSearch.addActionListener(new CarBtnHandler);
		
		panelBtn.add(btnDelete);
		panelBtn.add(btnModify);
		panelBtn.add(btnModify);
		
		rentTableModel = new RentTableModel(resItems, columnNames);
		resTable.setModel(rentTableModel);
		
//		rowSel.addListSelectionListener(new ListRowSelectionHandler());
//		colSel.addListSelectionListener(new LitsColSelectionHandler());
		
		add(panelSearch, BorderLayout.NORTH);
		add(new JScrollPane(resTable), BorderLayout.CENTER);
		add(panelBtn, BorderLayout.SOUTH);
		
		
	}
 	
	private void loadTableData(List<ResVO> resList) {
		
		if (resList != null && resList.size() != 0) {
			
			resItems = new String[resItems.length][5];
			
			for (int i=0; i<resList.size(); i++) {
				ResVO resVO = resList.get(i);
				
				resItems[i][0] = resVO.getResNumber();
				resItems[i][1] = resVO.getResCarNumber();
				resItems[i][2] = resVO.getResDate();
				resItems[i][3] = resVO.getUseBeginDate();
				resItems[i][4] = resVO.getReturnDate();
				resItems[i][5] = resVO.getResUserId();
				
			}
		}
	}
}
