package chap13;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import chap04.ConstructorTest;
import lombok.AllArgsConstructor;
import lombok.Data;

public class CollectMethod02 {

	public static void main(String[] args) {
		// counting(): 스트림의 요소 하나하나 세어 최종 스트림 요소의 수를 반환
		List<FreeBoard> boardList = Arrays.asList(
				new FreeBoard(1, "가입인사", "Hello!!!"),
				new FreeBoard(2, "가입인사", "반값습니다."),
				new FreeBoard(3, "질문있습니다.", "스프링 레그시 작성방법을 알려주세요")
				);
		
		List<FreeBoard> reversedList = 
				boardList.stream()
						.collect(Collectors.collectingAndThen(
									// 첫째인자: 1차 작업
									Collectors.toList(), 
									
									// 두번째인자 : 2차 작업
									(contents)-> {			
											Collections.reverse(contents);
											return contents;  // List구조 상태에서 반환
											//return contents.stream(); // List-> Stream 전환
										})
									);
						//.collect(Collectors.toList());
		
		long cnt = boardList.stream().collect(Collectors.counting());// 요소의 개수
		
		System.out.println("FreeBoard 게시글 수: "+cnt);
		//System.out.println(boardList);
		System.out.println("-- 정렬 전");
		boardList.stream().forEach(System.out::println);
		System.out.println("-- 정렬 후");
		//System.out.println(reversedList);
		reversedList.stream().forEach( (b) -> {
			System.out.println("-----");
			System.out.printf("no %d\n", b.getNo());
			System.out.printf("게시글 제목: %s\n", b.getTitle());
			System.out.printf("게시글 내용: %s\n", b.getContents());
		});
		
		
		// 요소중 제일 큰값, 제일 작은 값: maxBy(), minBy()
		List<Score1> scores = Arrays.asList(
				new Score1("홍길동", 61, 71, 81),
				new Score1("동길이", 62, 72, 82),
				new Score1("동순이", 100, 100, 61)
				);

		System.out.println("-- 전체 학생 점수");
		scores.stream().forEach(System.out::println);
		
		System.out.println("-- 국어가 최저 점수인 학생");
		//Comparator.comparing()에서 비교한 결과 중 minBy,maxBy이면 결과값을 반환
		scores.stream()
				.collect(Collectors.minBy(Comparator.comparing(Score1::getKor)))
				.ifPresent( s -> {
					System.out.printf("최저 점수: %d, 이름: %s",s.getKor(), s.getName());
				});
		
		System.out.println("\n-- 영어가 최고 점수인 학생");
		scores.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Score1::getEng)))
				.ifPresent(System.out::println);
				
		
		System.out.println("-- 이름순으로 제일 빠른 학생");
		scores.stream()
				.collect(Collectors.minBy(Comparator.comparing(Score1::getName)))
				.ifPresent(System.out::println);
//		System.out.println("-- 이름순으로 제일 느린 학생");
		
		
		
		// 스트림 요소들을 하나로 조합하는 메서드 : joining()
		List<String> langList = Arrays.asList("py", "java", "c");
		
		System.out.println("-- joining()");
		System.out.println(langList);
		
		// 단순 조합
		String word = langList.stream().collect(Collectors.joining());
		System.out.println("-- 연결 : "+word);
		
		String word2 = langList.stream().collect(Collectors.joining("/"));
		System.out.println("-- 연결2 : "+word2);
		
		String word3 = langList.stream().collect(Collectors.joining(",","프로그래밍 언어에는 ", " 등 이있습니다."));
		System.out.println("-- 연결2 : "+word3);
		
		
		// reducing(): 스트림 요소에서 처리할 경우
		long sum1 =  IntStream.rangeClosed(1, 10).reduce(100, Integer::sum);
		System.out.println(sum1);
		
		IntStream range = IntStream.rangeClosed(1, 10);
		// .boxed() : IntStream -> Stream<Integer>로 박싱
		long sum2 = range.boxed().collect(Collectors.reducing(1000, Integer::sum));
		System.out.println(sum2);
		

		
	}

}

@Data
@AllArgsConstructor
class FreeBoard {
	private int no;
	private String title;
	private String contents;
}
