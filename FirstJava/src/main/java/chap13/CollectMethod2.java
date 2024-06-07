package chap13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class CollectMethod2 {

	public static void main(String[] args) {
		// 최종작업을 추가로 처리할 경우: collectingAndThen(), reverse()
		
		List<String> locals = Arrays.asList("서울","대전","대구","광주", "부산", "제주","제주");
		
		
		// collect()에서 작업처리할 메서드는 Collectors()함수를 호출하여 처리
		List<String> reversedLocals = locals.stream()
											.collect( Collectors.collectingAndThen(Collectors.toList(), city -> {
												Collections.reverse(city); // 배열을 역정렬 : 현재 city는 List구조
												return city; // List구조에서 반환
											}));
											
		
		System.out.println("-- 정렬후 List구조로 전환");									
		System.out.println(locals);
		System.out.println(reversedLocals);
		
		Set<String> reversedLocals2 = locals.stream()
											.collect( 
													Collectors.collectingAndThen(
															Collectors.toList(),  		// 1. 처리해할 작업
															city -> { 					// 2. 처리할 작업이 끝후 다음 작업을 처리할 내용
																Collections.reverse(city); // 배열을 역정렬 : 현재 city는 Set구조
																return city.stream(); // stream구조에서 반환
											}))
											.collect(Collectors.toSet());// Set구조로 전환후 반환
		
		System.out.println("-- 정렬후 Set구조로 전환");
		System.out.println(locals);
		System.out.println(reversedLocals2);	
		
		// 수정할 수 없는 상태 : unmodifiableList() Collection클래스를 수정 할 수 없는 상태로 반환
		List<String> G7 = Stream.of("미국","영국","프랑스","독일","이탈리아", "캐나다","일본")
								.collect( 
										Collectors.collectingAndThen(
												Collectors.toList(), 
												Collections::unmodifiableList)
								);
		
		System.out.println(G7);
		//G7.add("대한민국");
		
		
		// 평균: averagingInt(),averagingLong(),averagingDouble()
		List<Integer> scores = Arrays.asList(100,100,61, 85,91);
		System.out.println("평균(int): "+scores.stream()
											.collect(Collectors.averagingInt(i -> i)));
		
		List<Long> scores10 = Arrays.asList(100L,100L,61L, 85L,91L);
		System.out.println("평균(long): "+scores10.stream()
											.collect(Collectors.averagingLong(i -> i)));	
		
		List<Double> scores20 = Arrays.asList(100.0, 100.8, 61.7, 85.5, 91.98);
		System.out.println("평균(double): "+scores20.stream()
											.collect(Collectors.averagingDouble(i -> i)));		
		
		
		List<Score1> scores2 = Arrays.asList(
				new Score1("홍길동", 100, 100, 100),
				new Score1("동길이", 100, 100, 80),
				new Score1("동순이", 100, 100, 90),
				new Score1("김길동", 100, 100, 70)
				);
		
		double avgMat = scores2.stream()
								.collect(
										Collectors.averagingInt(Score1::getMat));
		System.out.printf("수학 평균: %6.3f\n",avgMat);

	}

}

@Data@RequiredArgsConstructor
class Score1 {
	private final String name;
	private final int kor;
	private final int eng;
	private final int mat;
	private String msg;
}
