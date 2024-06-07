package chap03;

import java.util.Scanner;

public class Test_Q03 {

	public static void main(String[] args) {
		// 두 양의 정수를 입력받아서 두 수의 최대 공약수를 구해 보세오.
		int num1 = 0;
		int num2 = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두 수를 입력(10 20): ");
		num1 = Integer.parseInt(sc.next());
		num2 = Integer.parseInt(sc.next());
		
		//System.out.println(num1+","+num2);
		if (num1 > num2) { // 작은 수를 기준으로 설정,자리바꿈
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		//System.out.println(num1+","+num2);
		
		// 1부터 두수 중 작은 숫자까지만 반복처리
		// 최대(max), 최소(min) 
		int max = -9999;int min = 9999;
		for (int i=1; i<=num1; i++) {
			if ( (num1 % i == 0) && (num2 % i == 0) ) {
				System.out.println("공약수: "+i);
				
				if (max < i) max = i;// 공약수 중 가장 큰값 추출
				if (min > i) min = i;
				
			}
		}
		System.out.println(max);
		System.out.println(min);
		
		
		

	}

}
