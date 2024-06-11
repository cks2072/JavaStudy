package chap17;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTabTest {
	
	JFrame jFrame;
	JTabbedPane jtab;
	
	ImageIcon icon1, tabicon;
	JButton btn1, btn2;
	JLabel jlab;
	
	JPanel jpan;
	
	JTextField tf1;
	JTextArea tArea;
	
	public void crateFrame() {
		jFrame = new JFrame("Jtab 테스트");
		
		icon1 = new ImageIcon("src/main/resources/images/cup-1.jpg");
		jlab = new JLabel(icon1);
		tabicon = new ImageIcon("src/main/resources/images/rabbit.png");
		
		// 패널에 요소 추가
		jpan = new JPanel();
		
		tf1 = new JTextField("테스트");
		btn1 = new JButton("전송"); 
		
		jpan.add(tf1);
		jpan.add(btn1);
		
		// 텍스트 설정
		tArea = new JTextArea(7,20);
		tArea.setText("내용을 입력하세요");
		
		// 탭 패널 설정
		jtab = new JTabbedPane();
		jtab.addTab("탭1", jlab);
		jtab.addTab("탭2", new JPanel().add(tArea));
		jtab.addTab("탭3", tabicon, jpan, "세번째 탭");
		
		// 프레임에 탭패널 추가
		jFrame.add(jtab);
		
		jFrame.setPreferredSize(new Dimension(500,500));
		jFrame.pack();
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// JTabbedPane: 탭 컴포넌트

		JTabTest jTabTest = new JTabTest();
		jTabTest.crateFrame();

	}

}
