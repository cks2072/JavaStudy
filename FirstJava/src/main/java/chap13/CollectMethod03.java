package chap13;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectMethod03 {

	public static void main(String[] args) {
		// 배열의 요소들을 특정한 값을 기준으로 집계하거나 분류: groupingBy()
		
		List<Score1> scores = Arrays.asList(
				new Score1("홍길동", 61, 71, 81),
				new Score1("동길이", 62, 72, 82),
				new Score1("동순이", 100, 100, 61)				
				);
		System.out.println("--- ");
		scores.stream().forEach(System.out::println);
		
		
		// Map<String , Integer> map  => k:v=> 1:1
		// Map<String, List<Integer>> map> key:v => 1:n 
		// 수학 점수를 기준으로 A, B, C, D, F학점으로 분류
		// groupingBy(함수형 인터페이스 타입이 1개인 경우) :
		// 입력 요소에 대해 구현한 함수에 따라 요소를 그룹화하고 결과를 Map형태로 반환  
		Map<String, List<Score1>> result = 	scores.stream()
												  .collect( Collectors.groupingBy(
														  				s -> {
														  					// return "문자"가 그룹핑 기준 => key로 설정
														  					// 처리중인 요소(scores의 개별요소) => value로 설정
														  					return (s.getMat()>90) ? "A" : 
														  						   (s.getMat()>80 )? "B" : 
														  						   (s.getMat()>70) ? "C" : 
														  						   (s.getMat()>60) ? "D" :"F";
														  				}));
		
		System.out.println(result);
		result.keySet().forEach(k -> {
			System.out.printf("** 수학 %s 학점 \n",k);
			
			List<Score1> score = result.get(k);// get(키) => 값을 추출
			score.stream().forEach( s -> System.out.println(s.getName()));
			Long cnt = score.stream().collect(Collectors.counting());
			System.out.printf("%d 명\n", cnt);
		});
		
		// 근태 정보를 이용해서 출근, 지각, 결근 집계
		List<String> jobCheck = Arrays.asList(
				"출근", "출근","지각","출근","출근",
				"지각", "출근","지각","출근","출근",
				"지각", "지각","결근","출근","출근",
				"지각", "출근","지각","출근","출근"
				);
		System.out.println(jobCheck);
		
		Map<String, Long> info = jobCheck.stream()
				.collect(
							Collectors.groupingBy(
									Function.identity(), 	// 그룹핑 기준, Map의 key
									Collectors.counting() 	// 결과 값을 Map의 value
									));
		
		
		System.out.println(info);
		
		// partitioningBy()는  groupingBy()유사
		// groupingBy() : Function 함수형 인터페이스: 스트림으로 넘어온 요소를 특정 자료형으로 반환 : x-> x, 
		// partitioningBy():Predicate함수형 인터페이스 : 스트림으로 넘어온 요소를  Boolean 자료형으로 바환 : x -> true/false
		
		// 수학 80점 이상인 사람과 그렇지 않은 사람을 구분
		Map<Boolean, List<Score1>> result2 = scores.stream()
												.collect(
														Collectors.partitioningBy( s -> {
															return (s.getMat()>=80 ? true: false); // return 값이 그룹핑, key역할
														})
													);
		System.out.println(result2);
		result2.keySet().stream().forEach( key -> {
			//ystem.out.println(key+":"+result2.get(key));
			
			if (key) {
				System.out.println("-- 수학점수가 80이상인 학생");
				List<Score1> value = result2.get(key);
				value.stream().forEach(s -> System.out.println(s.getName()+"," + s.getMat()));
			} 
			
		});
		
		// 수학 80점이상인 사람과 그렇지 않은 사람은 각각 몇명인지 파악
		Map<Boolean, Long> result3 = scores.stream()
										.collect(Collectors.partitioningBy( 
												s -> {
														return s.getMat() >= 80 ? true: false;
												},
												Collectors.counting()
												)
										);
		System.out.println(result3);
		System.out.println(result3.get(true));
		

	}

}
