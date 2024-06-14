package chap19.member.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import chap19.common.RentTableModel;
import chap19.member.controller.MemberController;
import chap19.member.vo.MemberVO;
import chap19.member.window.SearchMemDialog.MemberBtnHandler;


public class ModfiyMemDialog extends JDialog {
	
	JPanel jPanel, panelSearch, panelBtn;
	JLabel lMemName;
	JTextField tf;
	
	JLabel lId, LName, lPassword, lAddress, lPhonNum;
	JTextField tfId, tfName, tfPassword, tfAddress, tfPhoneNum;
	
	JButton btnSearch;
	JButton btnMod;
	JButton btnCancel;
	
	MemberController memberController;
	
	public ModfiyMemDialog(MemberController memberController, String str) {
		
		this.memberController = memberController;
		setTitle(str);
		init();
		
	}
	
	public void init() {
		
		// 검색 UI
		lMemName = new JLabel("이름");
		tf = new JTextField(15);
		btnSearch = new JButton("조회하기");
		
		// 수정 UI
		btnCancel = new JButton("취소");
		btnMod = new JButton("수정");
		
		// 조회 UI
		lId = new JLabel("아이디");
		LName = new JLabel("이름");
		lPassword = new JLabel("비밀번호");
		lAddress = new JLabel("주소");
		lPhonNum = new JLabel("전화번호");
	
		tfId = new JTextField(20);
		tfName = new JTextField(20);
		tfPassword = new JTextField(20);
		tfAddress = new JTextField(20);
		tfPhoneNum = new JTextField(20);
	
		jPanel = new JPanel (new GridLayout(0,2));
		panelBtn = new JPanel();
		panelSearch = new JPanel();
		
		jPanel.add(lId);
		jPanel.add(tfId);
		
		jPanel.add(lPassword);
		jPanel.add(tfPassword);
		
		jPanel.add(LName);
		jPanel.add(tfName);
		
		jPanel.add(lAddress);
		jPanel.add(tfAddress);
		
		jPanel.add(lPhonNum);
		jPanel.add(tfPhoneNum);
		
		panelSearch.add(lMemName);
		panelSearch.add(tf);
		panelSearch.add(btnSearch);
		
		panelBtn.add(btnMod);
		panelBtn.add(btnCancel);
		
		
		// 각 UI 배치
		add(panelSearch, BorderLayout.NORTH);
		add(jPanel, BorderLayout.CENTER);
		add(panelBtn, BorderLayout.SOUTH);
		
		// 사이즈
		setLocation(400,200);
		setSize(500,300);
		setModal(true);
		setVisible(true);
		
		btnSearch.addActionListener(new MemberBtnHandler());
		btnMod.addActionListener(new MemberBtnHandler());
		btnCancel.addActionListener(new MemberBtnHandler());
		
	}
	 
	class MemberBtnHandler implements ActionListener {
		
		String memId = null;
		String memPassword = null;
		String memName = null;
		String memAddress = null;
		String memPhoneNum = null;
		
		List<MemberVO> memList = null;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
	
}
