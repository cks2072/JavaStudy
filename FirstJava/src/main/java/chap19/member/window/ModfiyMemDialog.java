package chap19.member.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	JTable ModTable;
	
	RentTableModel rentTableModel;
	
	MemberController memberController;
	
	public ModfiyMemDialog(MemberController memberController, String str) {
		
		this.memberController = memberController;
		setTitle(str);
		init();
		
	}
	
	public void init() {
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
		
		lMemName = new JLabel("이름");
		tf = new JTextField(15);
		btnSearch = new JButton("조회하기");
		
		btnCancel = new JButton("취소");
		btnMod = new JButton("수정");

		btnMod.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id = tfId.getText().trim();
				String Name = tfName.getText().trim();
				String Password = tfPassword.getText().trim();
				String Address = tfAddress.getText().trim();
				String PhoneNum = tfPhoneNum.getText().trim();
				
				MemberVO vo = new MemberVO(id, Password, Name, Address, PhoneNum);
				
				// btnReg.addActionListener(new MemberBtnHandler());
				btnMod.addActionListener(new MemberBtnHandler());
				// btnDelete.addActionListener(new MemberBtnHandler());
				btnSearch.addActionListener(new MemberBtnHandler());
			}
			
		});
	
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
		
		panelBtn.add(btnMod);
		panelBtn.add(btnCancel);
		
		panelSearch.add(btnSearch);
		panelSearch.add(tf);
		panelSearch.add(lMemName);
		
		add(panelSearch, BorderLayout.NORTH);
		add(panelBtn, BorderLayout.SOUTH);
		
		
		setLocation(400,200);
		setSize(400,400);
		setModal(true);
		setVisible(true);

		
	}
	 
	class MemberBtnHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
	
}
