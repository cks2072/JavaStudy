package chap05;

public class NestedClass01 {

	public static void main(String[] args) {
		/*
		 * 중첩 클래스
		 * - 인스턴스 내부 클래스
		 * - 지역 내부 클래스
		 * - 익명 내부 클래스
		 * - 정적 중첩 클래스
		 * 
		 */
		
		// 1.인스턴스 내부 클래스
		// outer class에 대한 인스턴스 생성
		Student st1 = new Student("홍길동");
		Student.Score st1Score = st1.new Score();
		
		st1Score.eng = 23;
		st1Score.mat = 21;
		st1Score.showInfo();
		
		

	}

}
