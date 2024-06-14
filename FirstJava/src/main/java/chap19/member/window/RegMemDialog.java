package chap19.member.window;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.StackWalker.Option;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import chap19.member.controller.MemberController;
import chap19.member.vo.MemberVO;

public class RegMemDialog extends JDialog {
	// 회원 정보 등록하기 화면
	
	// 회원 정보 등록 요청 객체
	MemberController membercontroller;
	
	// 화면 구성 요소 객체
	JPanel jPanel;
	JLabel lId, LName, lPassword, lAddress, lPhonNum;
	JTextField tfId, tfName, tfPassword, tfAddress, tfPhoneNum;
	JButton btnReg;
	
	// 생성자
	public RegMemDialog(MemberController memberController, String str) {

		this.membercontroller = memberController;

		setTitle(str);
		init(); // 화면 요소 객체 생성 메서드 호출
	
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
		
		btnReg = new JButton("회원 등록하기");
		btnReg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 화면의 있는 값을 객체로 저장
				String id = tfId.getText().trim();
				String Name = tfName.getText().trim();
				String Password = tfPassword.getText().trim();
				String Address = tfAddress.getText().trim();
				String PhoneNum = tfPhoneNum.getText().trim();
				
				MemberVO vo = new MemberVO(id, Password, Name, Address, PhoneNum);
				
				// ID중복체크: 객체에 널(null) 허용하는 타입
				Optional<MemberVO> checkIdVO = Optional.ofNullable(membercontroller.checkId(id));
				System.out.println("check Id : "+checkIdVO.get().getMemId());
				
				if (checkIdVO.get().getMemId()!= null) { // id가 중복이 아니면
					showMessage(checkIdVO.get().getMemId()+"이미 사용중인 ID입니다.", -1);
					
				} else { // id가 중복일 경우
					// 회원 정보 DB 등록 요청
					int result = membercontroller.regMember(vo);
					if (result > 0) {
						showMessage ("새회원을 등록했습니다.", result);
						tfId.setText("");
						tfPassword.setText("");
						tfName.setText("");
						tfAddress.setText("");
						tfPhoneNum.setText("");
					} else {
						showMessage ("회원 등록 실패", result);	
						
					}
					
				}
		
			}
			
		});
		
		jPanel = new JPanel (new GridLayout(0,2));
		
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
		
		add(jPanel, BorderLayout.NORTH);
		add(btnReg, BorderLayout.SOUTH);
		
		setLocation(400,200);
		setSize(400,400);
		setModal(true);
		setVisible(true);
		
	}
	
	// 메시지 전달창
	private void showMessage (String msg, int result) {
		if (result > 0) {
			JOptionPane.showMessageDialog(this, msg, "메시지 박스", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, msg, "메시지 박스", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}
