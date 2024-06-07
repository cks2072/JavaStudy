package chap03;

import java.util.Scanner;

public class Sam01BitOper {

	public static void main(String[] args) {
		// 비트 연산자( &, |, ~,^, <<,>,>>,....)
		int a = 2;
		int b = 3;
		// 왼쪽을 1개 shift할 경우 : *2
//		System.out.println("비트 연산 << : "+a+", "+ (a<<2));
		// 오른쪽을 1개 shift할 경우 : /2
//		System.out.println("비트 연산 >> : "+a+", "+ (a>>1));
		System.out.println("비트 연산 & : "+a+"&"+b+"=>"+ (a & b));
		System.out.println("비트 연산 | : "+a+"|"+b+"=>"+ (a | b));
		System.out.println("비트 연산 ~ : "+a+"=>"+ (~a));
		System.out.println("비트 연산 ^ : "+a+"=>"+ (a^b));
		System.out.println("2진 표기");
		System.out.printf("[%32s] [%d]\n",Integer.toBinaryString(a),a);
		System.out.printf("[%32s] [%d]\n",Integer.toBinaryString(b),b);
		System.out.println("&: 비트연산 AND");
		System.out.printf("[%32s] [%d]\n",Integer.toBinaryString(a&b),a&b);
		System.out.println("~: 비트연산 NOT");
		System.out.printf("[%32s] [%d]\n",Integer.toBinaryString(b),b);
		System.out.printf("[%32s] [%d]\n",Integer.toBinaryString(~b),~b);
		
//		System.out.println("3항 연산자");
		
//		int number;
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("숫자:");
//		number = sc.nextInt();
		
//		String result = (number%2 == 0) ? "짝수":"홀수";
//		System.out.println(result + " number");
//		
		int num1 = 10;
		System.out.println(num1++);
		System.out.println(num1);
				
		
		
		
		

	}

}
