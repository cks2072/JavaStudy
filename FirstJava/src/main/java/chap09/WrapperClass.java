package chap09;

import java.util.Scanner;

public class WrapperClass {

	public static void main(String[] args) {
		// Wrapper클래스 : 기본 자료형 -> 객체화
		// boolean, byte, char, short, int , long, float, double
		
		System.out.println("int 최대값: "+Integer.MAX_VALUE);
		System.out.println("int 최대값: "+Integer.MIN_VALUE);
		
		Scanner sc = new Scanner(System.in); // 키보드
		//sc.nextInt(); // String -> int
		System.out.print("숫자: ");
		String num  = sc.next(); // String타입
		
		int number = Integer.parseInt(num);// String -> int
		System.out.println( (num+100)+","+(number+100));
		
	}

}
