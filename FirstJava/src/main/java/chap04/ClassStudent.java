package chap04;

import chap04.vo.VO4;

public class ClassStudent {

	public static void main(String[] args) {
		
		VO4 student = new VO4();
		
		//student.hakbun = 1; // 접근 불가
		student.setHakbun(10);
		student.setName("홍길동");
		student.setKor(100);
		student.setMat(80);
		student.setEng(90);
		
		System.out.println(student.getHakbun());
		System.out.println(student.getName());
		System.out.println(student.getKor());
		System.out.println(student.getEng());
		System.out.println(student.getMat());

	}

}
