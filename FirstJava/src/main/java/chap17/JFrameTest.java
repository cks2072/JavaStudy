package chap17;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JFrameTest {
	
	JFrame jFrame = new JFrame("JFrame 테스트");
	JButton btn1, btn2, btn3, btn4;
	JTextField text1;
	
	public void createFrame() {
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		btn3 = new JButton("버튼3");
		btn4 = new JButton("버튼4");
		text1 = new JTextField("내용을 입력하세요.");
		
		// 프레임에 추가
		jFrame.add(text1, BorderLayout.NORTH);
		jFrame.add(btn1, BorderLayout.SOUTH);
		jFrame.add(btn2, BorderLayout.WEST);
		jFrame.add(btn3, BorderLayout.EAST);
		jFrame.add(btn4, BorderLayout.CENTER);
		
		jFrame.setPreferredSize(new Dimension(500,500));
		jFrame.pack();
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// AMT : 운영체제에 따라 모양이 달리 보임
		// JFC (Java Foundation Class) 라이브러리를 제공하여 운영체제 관계 없이 동일 모양
		// javax.*
		
		JFrameTest jframe01 = new JFrameTest();
		jframe01.createFrame();
		

	}

}
