package chap18;

import java.awt.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import chap18.controller.MovieController;

public class MovieWindowView extends JFrame implements ActionListener {
	
	String resultMsg = null;
	
	JTextField tMovieTitle;
	JButton btnTitleInsert, btnSave, btnExit;
	List movieList;
	
	 MovieController controller;
	
	public MovieWindowView() {
		super ("영화 정보 관리 화면");
		
		controller = new MovieController();
		
		tMovieTitle = new JTextField(30);
		btnTitleInsert = new JButton("영화제목 추가");
		btnSave = new JButton("영화제목 파일 저장");
		
		movieList = new List();
		
		btnExit = new JButton("종료");
		
		// 컴포넌트 설정
		movieList.setBackground(Color.green);
		
		Panel p = new Panel();
		p.add(new Label("영화제목 입력"));
		p.add(tMovieTitle);
		p.add(btnTitleInsert);
		p.add(btnSave);
		
		add(BorderLayout.NORTH,p);
		add(BorderLayout.CENTER,movieList);
		add(BorderLayout.SOUTH,btnExit);
		
		setBounds(0,0,800,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		// 이벤트 등록 처리
		movieList.addActionListener(this);
		btnTitleInsert.addActionListener(this);
		btnSave.addActionListener(this);
		btnExit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		// MVC 디자인 패턴
		/*
		 * 뷰 (View) : 사용자의 요청을 받아들이는 화면으로 요청을 컨트롤러로 전달
		 * 컨트롤러(Controller) : View에서 전달된 요청에 맞는 모델을 선택
		 * 모델(Model) : 데이터베이스 연동이나 파일 저장, 로직등 실제 기능을 수행
		 */
		
		MovieWindowView movie = new MovieWindowView();
		
	}
	@Override
	public void actionPerformed (ActionEvent e) {
		try {
			String mTitle = e.getActionCommand();
			
			System.out.println("이벤트 발생 : "+mTitle);
			if (e.getSource() == btnTitleInsert) {
				controller.addTitle();
			} else if (e.getSource() == btnSave) {
				controller.saveTitle();	
			} else if (e.getSource() == btnExit) {
				controller.delTitle();
			}
			
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
	}

}
