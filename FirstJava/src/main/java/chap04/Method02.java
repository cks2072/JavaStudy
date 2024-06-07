package chap04;

public class Method02 {

	public static void main(String[] args) {
		
		
//		hello();
//		hello("홍길순");
//		hello(100);
		
		System.out.println( sum(10) );
		System.out.println( sum(10,20) );
		System.out.println( sum(10,20,30,40,50) );
		
		System.out.println("-- 재귀함수");
		System.out.println(sum2(10));

	}

	// 가변인자 함수
	// 함수(매개변수,...., 가변인자) => sum(String a, String b, int... num1)
	public static int sum(int... num1 ) { // 자료형...   매개변수(배열구조)
		int tot = 0;
		
		for (int i : num1) { // num1[0],num1[1],....
			tot += i;
		}
		return tot;
	}
	
	
	
	// 오버로딩
	public static void hello() {
		System.out.println("Hello");
	}
	public static void hello(String name) {
		System.out.println(name);
		System.out.println("Hello !!");
	}
	public static void hello(int num) {
		System.out.println(num);
	}
	
	// 재귀함수: 종료하는 조건식
	public static int sum2(int a) {
		if (a == 1)
			return 1;
		else 
			return a+sum2(a-1); // 3+sum2(2), 2+sum2(1) , return 1
	}
		

}
