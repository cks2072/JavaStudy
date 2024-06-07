package chap02;

import java.util.Random;
import java.util.Scanner;

public class Sam03Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("입력할 값:");
//		String in = sc.nextLine(); // 문자열 전체 입력
//		System.out.println("입력한 값: "+in);
		
		// nextXXX(): 공백 이전까지 문자열을 반환
//		int num1 = 0;
//		System.out.print("숫자1:");
//		
//		num1 = sc.nextInt();
//		System.out.println(num1 +","+(num1*2));
//		
//		float num2 = sc.nextFloat();
//		System.out.println(num2 +","+(num2*2));
//		
//		num1 = sc.nextInt();
//		System.out.println(num1 +","+(num1*2));		
		
//		String str = "";
//		System.out.print("String:");
//		str = sc.nextLine();
//		System.out.println("문자열:"+str);
		
//		char[] chr;// String -> char 배열 전환
//		System.out.print("char:");
//		chr = sc.next().toCharArray();
//		
//		System.out.println(chr[0]);
//		System.out.println(chr[1]);
		
//		final float PI = 3.14159f;
//		System.out.println(PI);
		
//		PI = 3.14f; // error
//		System.out.println(PI);
		
		Random rnd = new Random();

		for (int i=0; i<10; i++) {
			 int num_rnd = rnd.nextInt(10)+1;//1~3
			 System.out.println(num_rnd);
		}
		
		
		
		
				
		
	}
}
