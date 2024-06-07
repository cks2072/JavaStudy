package chap08;

public class InterfaceClass02 {

	public static void main(String[] args) {
		// 인터페이스: 다중 상속에 활용하기
		Person1 p1 = new Person1();
		Person2 p2 = new Person2();
		Person3 p3 = new Person3();
		
		p1.study();
		p2.teach();
		
		p3.study();
		p3.teach();
		

	}

}

interface Student1 {
	void study();
}
interface Teacher {
	void teach();
}

// 학생
class Person1 implements Student1{

	@Override
	public void study() {
		System.out.println("Person1 공부한다.");		
	}
}
// 선생님
class Person2 implements Teacher{

	@Override
	public void teach() {
		System.out.println("Person2 가르친다.");
	}
}

// 학생, 선생님
class Person3 implements Student1, Teacher {

	@Override
	public void teach() {
		System.out.println("Person3 가르친다.");
	}

	@Override
	public void study() {
		System.out.println("person3 공부한다.");
	}
	
}


