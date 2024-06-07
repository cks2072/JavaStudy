package chap08;

public class ClassInher01 {

	public static void main(String[] args) {
		// 상속 -> 자원 재사용
		
		Middle m = new Middle("동순이", 10,50);
		College c = new College("김갑돌",20);
		
		// 부모클래스의 기능을 상속받아 재사용
		//m.setName("홍길동");
		//m.setGrade(1);
		
		System.out.println("-----------");
		m.study();
		System.out.println( m.test()  );
		System.out.println( m.getName());
		System.out.println( m.getGrade());
		// 자식 클래스에서 작성하는 기능
		m.setScore(30);
		m.studentInfo();
		
		System.out.println("-----------");
		c.study();
		System.out.println( c.test()  );
		System.out.println( c.getName());
		System.out.println( c.getGrade());
		// 자식 클래스에서 작성하는 기능
		c.setCourses(30);
		c.collegeInfo();
		
		// 업캐스팅(Upcasting) : 기능축소
		// : 부모 클래스 타입 참조변수 = 자식클래스타입변수 or 인스턴스
		
		// 다운캐스팅(Downcasting) : 기능확장
		// : 자식 클래스 타입 참조 변수 = (자식클래스타입)부모클래스타입 인스턴스
		
		
	
		Student s = new Middle("동순이", 10,50);
		s.study();
		s.test();
		//s.studentInfo() // 기능 축소에 의해 작동안됨
		
		Middle m2 = (Middle)s; // 기능 확대
		m2.study();m2.test(); m2.studentInfo();
		
		Student s2 = new College("김갑돌",20);
		
		
//		Student[] arrStudent = new Student[3];
//		
//		arrStudent[0] = new Middle("동순이", 10,50);
//		arrStudent[1] = new College("김갑돌",20);
//		
//		Middle t1  =  (Middle)arrStudent[0];
//		College t2 =  (College)arrStudent[1];
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * 클래스 사이의 관계
		 * 
		 * is-a 관계 : 한 클래스가 다른 클래스를 설명
		 * College is a student : 대학생은 학생입니다.
		 * Bus is a car : 버스는 자동차입니다.
		 * 
		 * use-a 관계 : 클래스가 다른 클래스를 사용하는 관계
		 * A student uses a calculator : 학생이 계산기를 사용한다.
		 * A driver uses a Car : 운전자가 자동차를 운전한다.
		 * 
		 * has-a 관계 한 클래스가 다른 클래스를 소유(포함)하는관계
		 * A car has a tire : 자동차는 타이어를 가집니다.
		 * A computer has a monitor : 컴퓨터는 모터를 가집니다.
		 */
		
		// JAVA에는 단일 상속만 가능
		// 대학생 클래스, 중학생 클래스 -> 학생 클래스
		// 상위클래스 : 공통된 속성, 메서드 : 기능 축소
		// 하위클래스 : 개별 속성, 메서드 : 기능 확대
		
		

	}

}
