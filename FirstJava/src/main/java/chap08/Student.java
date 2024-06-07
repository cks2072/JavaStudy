package chap08;

import lombok.Data;

// 공통 기능
@Data
public class Student {
	// protected : 상속 관계에서는 접근가능, 같은 패키지 가능
	//protected String name;
	//protected int grade;
	
	private String name;
	private int grade;
	
	// 인자 없는 생성자: 객체 생성시점에 한번 수행하는 메서드
	public Student() {
		System.out.println("Student 기본생성자 호출");
	}
	// 매개변수가 있는 생성자
	public Student(String name, int grade) {
		System.out.println("매개변수가 있는 Student 생성자 호출");
		this.name = name;
		this.grade = grade;
	}
	
	// 기능 수행을 위한 일반 메서드
	public void study() {
		System.out.println("시험 공부를 합니다.");
	}
	public int test() {
		System.out.println("시험 점수입니다.");
		return 0;
	}
	// 학생 신상 정보 출력 메서드
//	@Override
//	public String toString() {
//		return "Student [name=" + name + ", grade=" + grade + "]";
//	}
	
	
	

}
