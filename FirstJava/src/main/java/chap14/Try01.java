package chap14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Try01 {

	public static void main(String[] args) {
		// 예외 처리 (Exception ), try-catch-finally, throw, thorws, ....
		
		// 에러가 발생시 비정상 종료하지 않고 정상 종료
		try {
			
			int i=5;
			int[] a = new int[i];
			for (int j=0; j<=i;j++) {
				a[j] = j; // a[0] = 0,...
				System.out.println(j);
			}
			System.out.println(Arrays.toString(a));			
			
		} catch (Exception e) {
			System.out.println("오류발생: "+ e.getMessage());
		}
		
		System.out.println("정상 종료1");
	
		System.out.println("====");
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("0으로 나눈후 작업종료!");
		
		System.out.println("--- 중첩 Exception 처리");
		
		try {
			// 1차 오류 발생
//			int i=5;
//			int[] a = new int[i];
//			for (int j=0; j<=i;j++) {
//				a[j] = j; // a[0] = 0,...
//				System.out.println(j);
//			}
//			System.out.println(Arrays.toString(a));		
			
			// 2차 오류
//			System.out.println(1/0);
			
			// 3차 오류
			String msg = "";
			List<String> list = new ArrayList<String>();
			list.add("홍길동");
			list.add("동순이");
			
			list = Collections.unmodifiableList(list);// List update불가
			list.add("강감찬");
			
			
			
		} catch (ArrayIndexOutOfBoundsException e1) { // 하위 클래스
			System.out.println(e1.getMessage());
		} catch (ArithmeticException e2) { // 상위 클래스
			System.out.println(e2.getMessage());
		} catch (Exception e3) { // 상위 클래스
			System.out.println(e3.getMessage());
		} finally {
			// 예외 처리와 관계없이 무조건 수행할 내용
			System.out.println("test");
			
		}
		System.out.println("------");
		
		

		

	}

}
