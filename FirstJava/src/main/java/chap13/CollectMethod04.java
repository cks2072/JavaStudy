package chap13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectMethod04 {

	public static void main(String[] args) {
		// distinct(), count(), min(), max()
		
		List<FreeBoard> list = Arrays.asList(
				new FreeBoard(1, "가입인사", "Hello!!!"),
				new FreeBoard(2, "가입인사", "반값습니다."),
				new FreeBoard(3, "질문있습니다.", "스프링 레그시 작성방법을 알려주세요")
				);
		
		long cnt1 = list.stream()
						.collect(Collectors.counting());
		System.out.println("게시글 수: "+cnt1);
		
		long cnt2 = list.stream().count();
		System.out.println("게시글 수: "+cnt2);
		
		List<Integer> numbers = Arrays.asList(10,4,7,56, 43,99);
		Integer minNumber = numbers.stream().min(Integer::compare).get();
		System.out.println(numbers);
		System.out.println("최솟값: "+minNumber); 
		
		List<Score1> scores = Arrays.asList(
				new Score1("홍길동", 61, 71, 81),
				new Score1("동길이", 62, 72, 82),
				new Score1("동순이", 100, 100, 61)				
				);

		scores.stream()
				.collect( 
						Collectors.minBy(Comparator.comparing(Score1::getMat))
				)
				.ifPresent(System.out::println);
		
		Score1 minMathScore =  scores.stream()
									.min(Comparator.comparing(Score1::getMat))
									.get();
		System.out.println(minMathScore);
		
		// sum() : 요소의 모든 수를 더하는 메서드
		int sum1 = IntStream.rangeClosed(1, 5)
							//.boxed() // IntStream -> Stream<Integer>,  collect()메서드 안에서 xxx.reducing() 반드시 기술
							.reduce(0, (a,b)-> a+b);
		System.out.println("1~5까지의 합(.reduce(0, (a,b)-> a+b)):"+sum1);
		// .boxed() : IntStream -> Stream<Ineger> 전환	
		int sum2 = IntStream.rangeClosed(1, 5).boxed().reduce(0, Integer::sum);
		/*
		 * Intger.sum(a,b) => Intger::sum => 메서드 참조
		 * public final class Integer extends Number{
		 *     public static int sum(int a, int b) {
			        return a + b;
			   }
		   }
		   
		   final : 변수 => 읽기 전용
		   final : 메서드 => 오버라이딩 불가
		   final : 클래스 => 상속 불가
		 */
		System.out.println("1~5까지의 합(.reduce(0, Integer::sum):"+sum1);
		
		Integer sum3 = IntStream.rangeClosed(1, 10)
								.skip(9) // 9개는 넘김
								.sum();
		System.out.println(sum3);
		
		// average() : 스트림이 요소의 평균값
		IntStream.rangeClosed(1, 100)
				.average()
				.ifPresent(System.out::println);
		
		double avg = IntStream.rangeClosed(1, 100)
								.average()
								.getAsDouble();// 결괎은 반환 할 경우
		System.out.println(avg);
		
		// allMatch():스트림이 모든 요소가 조건을 반족하면 true
		// anyMatch(): 적어도 하나이상 조건이 참이면 true, 
		// noneMatch(): 모든 요소가 조건에 만족하지 않으면 true
		scores.stream().forEach( s -> {
			System.out.println(s);
		});
		boolean rs1 = scores.stream()
							.anyMatch( x ->  x.getMat() > 39 );// 모든 학생 수학점수가 40미만이면 false, 그렇지않으면 true
		System.out.println("수학 과락이 아닌 사람(40이상)이 있나요? "+ (rs1?"네":"아니오"));
		
		boolean rs2 = scores.stream()
							.allMatch( x -> x.getKor() > 39);// 모든 학생 국어점수가 40이상이면 true, 그렇지않으면 false
		System.out.println("국어 과락은 없나요? "+ (rs2?"네":"아니오"));
		
		boolean rs3 = scores.stream()
							.noneMatch(x -> x.getEng()>39); //  모든 학생 영어점수가 40미만이면 true, 그렇지않으면 false
		System.out.println("영어는 모두 과락인가요? "+(rs3?"네":"아니오"));
		
		
		// findAny(): 스트림 요소 중에 조건에 맞는 첫 번째요소 추출, 
		// findFirst():  스트림 요소 중에 첫 번째요소 추출
		
		List<Integer> li = Arrays.asList(4, 6, 2, 8, 10);
		System.out.println(li);
		// 요소들 중에 제일 먼저 찾은 요소를 추출
		li.stream().findAny().ifPresent(System.out::println);
		
		li.stream()
			.filter( x -> x>2) // true로 판별된 x요소가 다음 메서드로 전달
			.findAny()
			.ifPresent(System.out::println);
		
		// 병렬 스트림: 순서와 관계 없이 첫 번째 요소 추출
		li.parallelStream()
			.filter(x -> x > 2)
			.findAny()
			.ifPresent(System.out::println);

		// 요소중 첫 번째
		li.stream()
			.filter(x -> x > 2)
			.findFirst()
			.ifPresent(System.out::println);
		
		li.parallelStream()
			.filter(x -> x > 2)
			.findFirst()
			.ifPresent(System.out::println);
		
	}
	
	

}
