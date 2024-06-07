package chap13;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class TerminalOperations {

	public static void main(String[] args) {
		// 최종 연산 : toArray(), forEach(),......
		
		int[] numbers = IntStream.rangeClosed(1, 10)
								.toArray();
		System.out.println(Arrays.toString(numbers));
		
		Arrays.stream(numbers).forEach(System.out::println);
		
		System.out.println("-- forEach(), forEachOrdered()");
		List<Integer> list = Arrays.asList(2,4,6,8,10);
		
		System.out.println("-- 직렬 forEach()");
		list.forEach( x -> System.out.print(x+" "));
		
		System.out.println();
		System.out.println("-- 병렬 forEach(): 비순서");
		list.parallelStream().forEach( x -> System.out.print(x+" "));
		
		System.out.println();
		System.out.println("-- 병렬 forEachOrdered(): 순서보장");
		list.parallelStream().forEachOrdered( x -> {
			System.out.print(x+" ");
		});
		
		// reduce():  누적 함수를 사용하여 스트림요소에 대한 값을 반환
		// reduce(초기값, (인자1, 인자2))
		
		System.out.println("\n--- reduce()");
		int[] nums = {1,2,3};
		
		int sum = 0;
		for (int x : nums) {
			sum += x;
		}
		System.out.println("sum = "+sum);
		System.out.println("-- ");
		
		int sum2 = Arrays.stream(nums).reduce(0, (x,y) -> x+y);
		System.out.println("sum2 = "+ sum2);
		
		int sum3 = Arrays.stream(nums).reduce(0, Integer::sum);
		System.out.println("sum3 = "+sum3);
		
		//1부터 100까지의 합
		int sum4 = IntStream.rangeClosed(1, 100).reduce(0, (x,y)-> x+y);
		int sum5 = IntStream.rangeClosed(1, 100).reduce(0, (x,y)-> { 
			return x+y;
		});
		int sum6 = IntStream.rangeClosed(1, 100).reduce (0, Integer::sum);
		
		System.out.println("-- 1~10합");
		System.out.println(sum4);
		System.out.println(sum5);
		System.out.println(sum6);
		
		int fac = IntStream.rangeClosed(1, 4).reduce (1, (x,y) -> x*y);
		System.out.println("fac="+fac);
		 
		//Optional 클래스 : null일 발생하는 것을 대비한 타입으로 null인 경우 default값을 설정할 수 있음.
		int optSum1 = 0;
		OptionalInt optSum2;
		
		optSum1 = IntStream.rangeClosed(7,10).reduce(6, Integer::sum);
		System.out.println(optSum1);
		
		optSum2 = IntStream.rangeClosed(6, 10).reduce(Integer::sum);
		System.out.println(optSum2);
		System.out.println(optSum2.getAsInt());
		
		OptionalInt optSum3 = OptionalInt.empty();
		if (optSum3.isEmpty()) {
			System.out.println("비어 있음.");
		} 
		
		optSum3 = OptionalInt.of(123);
		if (optSum3.isPresent()) {
			System.out.println(optSum3.getAsInt());
		} else {
			System.out.println("값이 없음.");
		}
		
		
		// Optional클래스에서 제공하느 메서드
		// isPresent(): 값 저장 유무 판별 : true,false		
		// orElse(T), orElse(double) : 저장된 값이 없는 경우 디폴트값 지정
		// ifPresent(Consumer), ifPresent(DoubleConsumber) : 지정된 값이 있는 경우 처리
		
		// IntStream -> Optional도 기본형값으로 OptionInt 반환
		OptionalInt t1 = OptionalInt.of(0); // 0저장
		OptionalInt t2 = OptionalInt.empty(); // null을 저장
		
		System.out.println(t1.isPresent());
		System.out.println(t2.isPresent());
		
		System.out.println(t1.getAsInt());
		//System.out.println(t2.getAsInt()); // error: NoSuchElementException
		
		Optional<String> t3 = Optional.ofNullable(null);
		Optional<String> t4 = Optional.empty();
		System.out.println(t3.equals(t4));
		
		System.out.println("----");
		IntStream.rangeClosed(1, 5)
				.reduce(Integer::sum) // 15결과 있으면(값이 있을 경우에만 처리)
				.ifPresent( x -> System.out.println(x));
		
		
		
				
		
		
		

		

	}

}
