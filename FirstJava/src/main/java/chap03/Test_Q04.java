package chap03;

import java.util.Scanner;

public class Test_Q04 {

	public static void main(String[] args) {
		// 양의 정수를 입력 받아 그 수가 소수인지 판별해 보세요.
		int num = 0; int count = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양의 정수를 입력:");
		num = Integer.parseInt(sc.next());
		
		for (int i=2; i<num; i++) {// 1과 자신의 수로는 나누기에서 제외
			if (num % i == 0) count++;
		}
		
		if (count==0) {
			System.out.println(num+"는 소수입니다.");
		} else {
			System.out.println(num+"는 소수가 아닙니다.");
		}
		

	}

}
