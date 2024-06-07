package chap12;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInterface01 {

	public static void main(String[] args) {
		// 1개의 매개변수, boolean 반환 자료형을 갖는 함수형 인터페이스
		// test()
		
		Predicate<Integer> isOdd = (s) -> (s%2) == 1;// 결과값인 true or false 반환
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print(" 숫자 : ");
//		sc.hasNextInt();// 키보드에 값있는지 판별
//		
//		boolean rs = isOdd.test(sc.nextInt());
//		System.out.println( (rs)?"홀수":"짝수");
		
		System.out.println("-- and , or ");
		int a = 12;
		int b = 33;
		
		Predicate<Integer> isMin = s -> s > 10;
		Predicate<Integer> isMax = s -> s < 20;
		
		System.out.println( isMin.and(isMax).test(a));
		
		System.out.println( isMin.or(isMax).test(b));
		
		System.out.println("-- isEqual");
		List<Integer> luckyNo = Arrays.asList(5,12,25,26,38,4);
		
		System.out.println(luckyNo);
		
		Predicate< List<Integer>  > isLucky = Predicate.isEqual(luckyNo);
		List<Integer> myNo = Arrays.asList(5,12,25,26,38,45);
		
		if (isLucky.test(myNo)) {
			System.out.println("1등 당첨");
		} else {
			System.out.println("1등 아님.");
		}
		
		
		System.out.println("--- not(), negate()");
		Predicate<Integer> isOdd2 = (s) -> (s%2 == 1); // 홀수
		Predicate<Integer> isEven2 =Predicate.not(isOdd2); // 짝수
		
		int num = 101;
		if (isOdd2.test(num)) {
			System.out.println("홀수");
		} else if (isEven2.test(num)) {
			System.out.println("짝수");
		}
		
		// 3의 배수 이거나 홀수인 수를 출력
		int[] no  = {1,3,6,9};
		
		Predicate<Integer> isOdd3 = s -> s%2 == 1;
		Predicate<Integer> isMultipleThree = s -> s%3 == 0;
		
		for (int num1 : no) {
			if (isOdd.or(isMultipleThree).test(num1)) {
				System.out.printf("%d는 홀수이거나 3의 배수입니다.\n", num1);
			}
		}

	}

}
