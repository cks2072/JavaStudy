package chap04;

public class Method01 {

	public static void main(String[] args) {
		
		
//		Method01 m = new Method01();
//		
//		m.hello(); // 인자값, 반환값 없는 구조
//		m.sum(10, 20);
//		
//		int result = m.sum2(100, 200);
//		System.out.println(result);
		
		// static으로 선언된 메서드: 객체 생성 없이 함수 호출
		hello();
		sum(10,100);
		System.out.println( sum2(50, 1));
		
		
	}
	
	// 함수(메서드)
	public static void hello() {
		System.out.println("Hello Java!!");
	}

	public static void sum(int num1, int num2) {
		System.out.println(num1+","+num2);
		System.out.println((num1+num2));
	}
	public static int sum2(int num1, int num2) { 
		return (num1+num2);
	}

}
