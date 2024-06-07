package chap08;

import lombok.Data;

// 중학생 클래스
@Data
public class Middle extends Student {
	private int score; // 중학생 점수
	
	public Middle() {}
	// 부모클래스 멤버변수가 protected로 설정되었을때 적용
//	public Middle(String name, int grade) {
//		// 부모 클래스에있는 멤버변수
//		super.name = name;
//		super.grade = grade;
//	}
	// 부모클래스 멤버변수가 private 로 설정되었을때 적용
	public Middle(String name, int grade, int score) {
		// 전달 받은 인자값을 부모 생성자로 통해 값을 초기화
		super(name, grade);
		this.score = score;
	}

	public void studentInfo() {
		System.out.println("나는 중학생입니다.");
	}
	//메서드 재정의
	@Override
	public void study() {
		System.out.println("중학생 시험 공부를 합니다.");
		//super.study(); // 부모 클래스에 있는 메소드 호출
	}

}
