package chap03;

import java.util.Scanner;

public class Test_Q02 {

	public static void main(String[] args) {
		// 양의 정수를 입력받아서 각 자리의 합을 출력해 보세요
		/*
		 실행 결과
		 num = 2347
		 2347의 자릿수의 합은 16
		*/
		
		int num;
		int mok = 0; 
		int remainder = 0;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("자연수를 입력하세요.");
		System.out.print("num= ");
		//num = sc.nextInt(); // String -> int
		num = Integer.parseInt(sc.next()); // String -> int
		
		//System.out.println(10/3);// java => 정-정 연산 결과 정수
		//System.out.println(10/3.0);// 정-실 => 실수
		//System.out.printf("%d %d\n",num/10, num%10);
		
		mok = num;
		do {
			remainder = mok % 10;// 나머지
			mok = mok / 10; // 몫
			
			// 나머지값은 각 자리수를 의미
			sum += remainder;// 각 자리수 합계
			
			System.out.printf(" 몫=%4d, 나머지=%2d\n",mok,remainder);
		}while(mok != 0);// 특정 조건이 될때까지 반복
		
		System.out.println(num+"의 자릿수의 합은 " + sum);
		
		
		

	}

}
