package chap17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BoardLayoutTest {

	public static void main(String[] args) {
		// BoardLayout
		
		/*
		 *  Object -> Component, MenuComponent -> MenuItem, MenuBar
		 *  Container -> Window, Panel
		 *  Window -> Frame, Dialog
		 *  Panel -> Applet
		 * 	Button, Choice, List, Label, Checkbox, Scrollbar
		 */
		
		Frame frame;
		Button center, west, east, north, south;
		TextField tf1;
		
		// 각각의 컴포넌트 객체 생성
		frame = new Frame("BoarderLayout 예제");
		
		south = new  Button("botton1");
		west = new  Button("botton1");
		east = new  Button("botton1");
		north = new  Button("botton1");
		center = new Button("botton1");
		
		tf1 = new TextField("입력창입니다.");
		
		frame.add(tf1, BorderLayout.NORTH); // 프레임 위쪽에 배치
		frame.add(south, BorderLayout.SOUTH); // 프레임 아래 배치
		frame.add(west, BorderLayout.WEST); // 프레임 왼쪽 배치
		frame.add(east, BorderLayout.EAST); // 프레임 오른쪽 배치
		frame.add(center, BorderLayout.CENTER); // 프레임 가운데 배치
		
		frame.setSize(400,400); // 프레임 크기
		frame.setVisible(true); // 프레임 표시
		frame.addWindowListener(new WindowHandler());

		System.out.println("--- FlowLayout 예제 : 기본 형태, 수직 수평 배치");
		Frame frame2;
		Button btn1, btn2, btn3;
		
		frame2 = new Frame ("FlowLayout");
		btn1 = new Button("OK");
		btn2 = new Button("Open");
		btn3 = new Button("Close");
		
		frame2.setLayout(new FlowLayout());
		frame2.add(btn1);
		frame2.add(btn2);
		frame2.add(btn3);
		
		frame2.setSize(300,300);
		frame2.setVisible(true);
		frame2.addWindowListener(new WindowHandler());
		
		
		System.out.println("--- GridLayout 예제 : 테이블 형태 배치");
		Frame frame3;
		Button btn4, btn5, btn6;
		TextField tf01, tf02, tf03;
		
		frame3 = new Frame ("GridLayout");
		
		btn4 = new Button("btn4");
		btn5 = new Button("btn5");
		btn6 = new Button("btn6");
		
		tf01 = new TextField("입력창1");
		tf02 = new TextField("입력창2");
		tf03 = new TextField("입력창3");
		
		// 배치할 요소의 행, 열
		frame3.setLayout(new GridLayout(2,0));
		
		frame3.add(btn4);
		frame3.add(tf01);
		
		frame3.add(btn5);
		frame3.add(tf02);
		
		frame3.add(btn6);
		frame3.add(tf03);
		
		frame3.pack(); // 컴포넌트 크기 일치하도록 설정
		frame3.setVisible(true);
		frame3.addWindowListener(new WindowHandler());
		
		System.out.println("--- Panel");
		
		Frame frame4;
		Panel panel;
		
		Button btnOk, btnCancel;
		TextField txt;
		
		frame4 = new Frame("Panel 예제");
		
		btnOk = new Button ("OK");
		btnCancel = new Button("Cancel");
		txt = new TextField("입력창");
		
		panel = new Panel();
		
		frame4.add(txt, BorderLayout.NORTH);
		
		panel.setBackground(Color.green);
		panel.add(btnOk);
		panel.add(btnCancel);
		
		frame4.add(panel, BorderLayout.CENTER);
		
		frame4.setSize(400,400);
		frame4.setVisible(true);
		frame4.addWindowListener(new WindowHandler());
		
	}
	
	public static class WindowHandler extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("윈도우 창닫기");
			System.exit(0);
		}
	}
}



	
