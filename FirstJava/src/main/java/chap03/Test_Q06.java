package chap03;

import java.util.Scanner;

public class Test_Q06 {

	public static void main(String[] args) {
		/*
		 * 비트 연산 활용하여 5문제의 답이 비트연산 결과가
		 *  1이면 'O', 0이면 'X' 으로 표시
		 *  
		 * 답 입력> 10110`
		 *    정답> 11010
		 *    결과> OXXOO
		 */
		
		int[] dap = {1,1,0,0,1};
		System.out.print("답 입력> ");
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine(); // 키보드로부터 값 입력
		
		System.out.print("  정답 > ");
		for (int n : dap)
			System.out.print(n);
		
		System.out.print("\n  결과 > ");
		int tagetLoc = 0;
		// String("홍길동") -> char[]("홍","길","동")
		// String -> char[] -> [0],[1],..[n]
		for (char c : in.toCharArray()) {
			// &연산, |연사, ^연산의 결과가 1-> 'O', 0이면 'X'
			System.out.print( (c & dap[tagetLoc++]) == 1 ? "O":"X"  );
		}
				

	}

}
