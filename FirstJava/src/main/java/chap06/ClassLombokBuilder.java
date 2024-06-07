package chap06;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class ClassLombokBuilder {

	public static void main(String[] args) {
		// Lombok Builder
		Person per1 = Person.builder()
				.no(1)
				.build();
		
		System.out.println(per1);
		Person per2 = Person.builder()
				.no(1)
				.name("동길이")
				.build();
		System.out.println(per2);
		
		Person per3 = Person.builder()
				.no(1).name("동순이").phone("010-0101-0101")
				.build();
		System.out.println(per3);

	}

}

// VO, DTO
@Data
@Builder
@AllArgsConstructor
class Person{
	private int no;
	private String name;
	private String phone;
	
//	@Builder
//	public Person(int no, String name, String phone) {
//		this.no = no;
//		this.name = name;
//		this.phone = phone;
//	}
	
	
	
}
