package chap17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AwtEventTest implements ActionListener {
	
	private Frame frame;
	private Button btn1, btn2, btn3, btn4, btn5;
	
	// 생성자
	public AwtEventTest() {
		frame = new Frame("이벤트 핸들러 예제");
		btn1 = new Button("btn1");
		btn2 = new Button("btn2");
		btn3 = new Button("btn3");
		btn4 = new Button("btn4");
		btn5 = new Button("btn5");
	}

	public static void main(String[] args) {
		/*
		 *  이벤트 소스 : 이벤트를 발생시킨 컴포넌트 
		 *  이벤트 리스너 : 이벤트 소스가 발생시키는 이벤트를 처리 할 수 있는 구현 클래스가 구현할 인터페이스
		 *  이벤트 핸들러 : 이벤트 리스너를 구현한 이벤트를 처리하는 클래스
		 */

		AwtEventTest awtEventTest = new AwtEventTest();
		awtEventTest.startFrame();
		
	}
	// 이벤트 핸들러 : 이벤트를 처리하는 이벤트 핸들러는 이벤트 리스너를 구현해서 이벤트를 처리
	public void startFrame() {
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		
		frame.add(btn1, BorderLayout.NORTH);
		frame.add(btn2, BorderLayout.SOUTH);
		frame.add(btn3, BorderLayout.WEST);
		frame.add(btn4, BorderLayout.EAST);
		frame.add(btn5, BorderLayout.CENTER);
		
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.addWindowListener(new WindowHandler());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			System.out.println("버튼1 클릭");
			System.out.println(e.getActionCommand());
		} else if (e.getSource() == btn2) {
			System.out.println("버튼2 클릭"); 
			System.out.println(e.getActionCommand());
		} else if (e.getSource() == btn3) {
			System.out.println("버튼3 클릭"); 
			System.out.println(e.getActionCommand());
		} else if (e.getSource() == btn4) {
			System.out.println("버튼4 클릭"); 
			System.out.println(e.getActionCommand());
		} else if (e.getSource() == btn5) {
			System.out.println("버튼5 클릭"); 
			System.out.println(e.getActionCommand());
		} 
			
	}
	
	public static class WindowHandler extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("윈도우 창닫기");
			System.exit(0);
		}
		
	}
	
//	public static class WindowHandler implements WindowListener {
//
//		@Override
//		public void windowOpened(WindowEvent e) {}
//
//		@Override
//		public void windowClosing(WindowEvent e) {
//			System.out.println("윈도우 창닫기");
//			System.exit(0);	
//		}
//
//		@Override
//		public void windowClosed(WindowEvent e) {}
//
//		@Override
//		public void windowIconified(WindowEvent e) {}
//
//		@Override
//		public void windowDeiconified(WindowEvent e) {}
//
//		@Override
//		public void windowActivated(WindowEvent e) {}
//
//		@Override
//		public void windowDeactivated(WindowEvent e) {}
//	
//		}
	
	}
