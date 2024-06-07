package chap13;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFlatMap {
	// 스트림 내에서 외부에 있는 기억장소를 사용시 : 멤버변수을 적용
	static int sum = 0;

	public static void main(String[] args) {
		// 스트림 가변 인자 
		String[] str1 = {"홍길동","동길이","동순이"};
		String[] str2 = {"김길동","이순신","강감찬"};
		
		Stream<String[]> stm1 = Stream.of(str1, str2); // 가변인자
		
		System.out.println("-- Stream.of(s,t)");
		stm1.forEach( x -> {
			System.out.println(Arrays.toString(x));
		});
		
		System.out.println("-- 스트림.flatMap()");
		Stream<String[]> stm3 = Stream.of(str1, str2); 
		Stream<String> flatStm = stm3.flatMap(Arrays::stream); // Arrays.stream(str1)
		
		
		flatStm.forEach( x -> System.out.println(x));
		
		
		System.out.println("-- .range()");
		IntStream intStream = IntStream.range(0, 5);
		intStream.forEach( System.out::println);
		
		System.out.println("-- rangeClose()");
		IntStream.rangeClosed(0,5).forEach(i -> System.out.println(i));
		
		
		// 스트림 내에서 외부에 있는 기억장소를 사용시 : 멤버변수을 적용
		IntStream.rangeClosed(1, 10)
				.forEach( i -> sum += i);
		System.out.println("sum="+sum);

	}

}
