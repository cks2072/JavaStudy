package chap17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import chap17.AwtEventTest.WindowHandler;

public class AwtEventTest02 {
	
	private Frame frame;
	private Button btn1, btn2, btn3, btn4, btn5;
	
	public AwtEventTest02() {
		frame = new Frame("이벤트 핸들러 예제");
		btn1 = new Button("btn1");
		btn2 = new Button("btn2");
		btn3 = new Button("btn3");
		btn4 = new Button("btn4");
		btn5 = new Button("btn5");
	}

	public static void main(String[] args) {
		// 내부 클래스로 이벤트 핸들러 구현

		AwtEventTest02 event02 = new AwtEventTest02();
		event02.startFrame();
		
	}
	
	public void startFrame() {
	
	btn1.addActionListener(new InnerHandler());
	btn2.addActionListener(new InnerHandler());
	btn3.addActionListener(new InnerHandler());
	btn4.addActionListener(new InnerHandler());
	btn5.addActionListener(new InnerHandler());
	
	frame.add(btn1, BorderLayout.NORTH);
	frame.add(btn2, BorderLayout.SOUTH);
	frame.add(btn3, BorderLayout.WEST);
	frame.add(btn4, BorderLayout.EAST);
	frame.add(btn5, BorderLayout.CENTER);
	
	frame.setSize(400,400);
	frame.setVisible(true);
	frame.addWindowListener(new WindowHandler());
	
	}
	
	// 내부 클래스에서 이벤트 처리
	public class InnerHandler implements ActionListener {

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
		
	}
	
}
