package chap17;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JOptionTest extends JFrame implements ActionListener {
	
	JButton btn1, btn2, btn3, btn4;
	String[] str = {"카드 결제","계좌 이체","계좌 송금"};
	
	public JOptionTest() {
		super ("여러가지 메시지 박스 테스트"); // 창의 제목
		setLayout(new FlowLayout()); // 가로방향 배치
		
		btn1 = new JButton("출력 메시지 박스");
		btn2 = new JButton("확인 메시지 박스");
		btn3 = new JButton("입력 메시지 박스");
		btn4 = new JButton("선택 메시지 박스");
		
		add(btn1); add(btn2); add(btn3); add(btn4);
		pack();
		
		setLocation(300,300);
		setVisible(true);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);	
		
	}

	public static void main(String[] args) {
		// JOptionPane : 간단한 메시지를 입력 받거나 경고를 출력
		new JOptionTest();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 사용자에게 메시지를 보여주는 박스
		if (e.getSource() == btn1) {
			JOptionPane.showMessageDialog(this,
					"출력 메시지 박스", // 메시지
					"메시지", // 창제목
					JOptionPane.INFORMATION_MESSAGE // 아이콘
					);
		} else if (e.getSource() == btn2) {
			// YES, NO, CANCEL과 같은 버튼으로 확인 하는 메시지 박스
			JOptionPane.showMessageDialog(this,
					"확인 메시지 박스", // 메시지
					"확인", // 창제목
					JOptionPane.YES_NO_CANCEL_OPTION // 아이콘
					);
		} else if (e.getSource() == btn3) {
			// 사용자로부터 자료를 입력 받기 위한 메시지 박스
			JOptionPane.showInputDialog(this,
					"입력 메시지 박스", // 메시지
					"입력", // 창제목
					JOptionPane.YES_NO_OPTION // 아이콘
					);
		} else if (e.getSource() == btn4) {
			// 위 세가지를 포함하여 맞춘 메시지 박스
			JOptionPane.showOptionDialog(this,
					"선택 메시지 박스", // 메시지
					"옵션", // 창제목
					JOptionPane.YES_NO_OPTION, // 아이콘
					JOptionPane.INFORMATION_MESSAGE,
					null,
					str,
					str[0]
					);
		}
		
	}

}
