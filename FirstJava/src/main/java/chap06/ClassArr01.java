package chap06;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class ClassArr01 {

	public static void main(String[] args) {
		
		
		// 객체 배열
		//Student3 students = new Student3("홍길동", 10, 1);
		Student3[] students = new Student3[3];
		
		students[0] = new Student3("홍길동", 10, 1);
		students[1] = new Student3("동길이", 11, 3);
		students[2] = new Student3("동순이", 12, 5);
		
		for(Student3 s : students) {
			System.out.println(s.toString());
		}
		
		System.out.println("---");
		for (int i=0; i<students.length; i++) {
		
			System.out.println(   students[i].toString()   );
		
		}
		
		//----------------------
		students[0].getAge();
		students[0].setAge(10);
		
		Student3 st01 = new Student3("김길순", 20);

	}

}

//@Getter@Setter@ToString => @Data
@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
class Student3{
	
	@NonNull // 정의된 필드만 생성자에 매개변수로 포함
	String name;
	
	@NonNull // 정의된 필드만 생성자에 매개변수로 포함
	int age;
	
	int grade;
	
	
	// 편집툴에서 소스 불러오기
//	public Student3(String name, int age, int grade) {
//		super();
//		this.name = name;
//		this.age = age;
//		this.grade = grade;
//	}
//
//	@Override
//	public String toString() {
//		return "Student3 [name=" + name + ", age=" + age + ", grade=" + grade + "]";
//	}
//	
	
	
	// 직접 입력
//	public Student3(String name, int age, int grade) {
//		this.name  = name;
//		this.age   = age;
//		this.grade = grade;
//	}
//	@Override
//	public String toString() {	
//		return "Student3[name="+name+",age="+age+",grade="+grade+"]";
//	}
}
