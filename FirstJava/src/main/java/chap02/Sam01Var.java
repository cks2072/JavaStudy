package chap02;

public class Sam01Var {

	public static void main(String[] args) {
		// 문자형
		char chr = 'A';
		System.out.println("char : "+chr); // 문자
		System.out.println("Encoding: "+ (int)chr); // ASCII코드 번호
		System.out.println("A+1 :"+ (char)('A'+32) );
		System.out.println("a+1 :"+ (char)('a'-32) );
		
		// 숫자형 : 정수형 , 실수형
		// 정수형: byte(1), short(2), int(4) ,long(8)
		//  1byte -> 8bit : 0-255-> 128-~127
		// 실수형: float(4), double(8)
		
		byte a1 = 127, a2 = -128;
		System.out.printf("byte: min=%d, max=%d\n ", a1, a2);
		
		int c1 = 1000;
		long c2 = 1000L;
		
		float f1 = 10.2f;
		double f2 = 10.2;
		System.out.printf("float: %f \n double: %8.2f\n",f1,f2);
		
		System.out.printf("10진:%d, 8진:%o, 16진:%X \n",10,10,10);
		System.out.printf("지수: %e, %e, %f", 1.e3, 1.e-3, 1.0e3);
		
		// 비기본자료형=> 참조형
		// 문자열 
		String str1 = "Apple";
		System.out.printf("\n%s, %s, %c", str1, str1.toUpperCase(), 'a');		
		
		
		
		
		
		
		

	}

}
