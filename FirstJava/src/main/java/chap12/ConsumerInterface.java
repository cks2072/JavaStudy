package chap12;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ConsumerInterface {

	public static void main(String[] args) {
		//매개변수가 한 개인 함수형 인터페이스
		// Consummer : 1개의 매개변수, 반환값 없음
		// void accept(T t)
		// defaultConsumer<T> : andThen(Consumer<? super T>after):Consumer작업을 순서대로 수행하고 다음 작업을 수행
		
		Consumer<String> c = x -> {
			System.out.printf("%s는 1개의 매개변수는 있지만 반환할 자료형은 없습니다.", x.toUpperCase());
		};
		
		c.accept("Consummer");
		
		System.out.println();
		System.out.println("--- Consumer인터페이스를 이용한 클래스 작성및 객체 생성");
		
		List<Employee1> emp = Arrays.asList(
				new Employee1(1, "홍길동", 2400),
				new Employee1(2, "동순이", 2700),
				new Employee1(3, "김길동", 3000),
				new Employee1(4, "김갑순", 3200)
				);
		
//		System.out.println(emp);
		
		//emp.forEach( (x) -> System.out.println(x));
		
		
		System.out.println("== 연봉 2배 인상 ==");
		Consumer<Employee1> consumer = (x) -> {
			x.setSalary(x.getSalary()*2);
		};
		
		doubleSalary(emp, consumer.andThen( (item) -> System.out.println("== 인상후: "+item)));
		//doubleSalary(emp, consumer);
		//System.out.println(emp);
		
	}
	
	private static void doubleSalary(List<Employee1> emp, Consumer<Employee1> f) {
		//System.out.println(emp);
		
		for (Employee1 e : emp) {
			System.out.println("-- 인상전: "+e);
			f.accept(e);
		}
		
		//System.out.println(emp);
		
	}
}

@Data
@AllArgsConstructor
class Employee1 {
	private int no;
	private String name;
	private double salary;
}



