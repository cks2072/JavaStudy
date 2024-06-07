package chap08;

import lombok.Data;

@Data
public class College extends Student{
	private int courses; // 대학생 학점
	
	public College(String name,int grade) {
		super(name, grade);
	}
	public void collegeInfo() {
		System.out.println("나는 대학생입니다.");
	}
	
	@Override
	public void study() {
		System.out.println("대학생 시험 공부를 합니다.");
	}

}
