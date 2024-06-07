package chap13;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamRange {
	
	static int number = 100;

	public static void main(String[] args) {
		// 특정 범위에서 스트림 얻기
		// IntStream.range(시작, 마지막): 마지막 미포함, IntStream.rangeClosed(시작,마지막): 마지막값 포함
		
		
		List<Board> boardList = new ArrayList<Board>();
		
		IntStream.range(1, 11)
				.forEach( i -> {
					boardList.add( new Board(i, "title_"+i, "user_"+i, LocalDateTime.now()));
				});
		
		boardList.stream().forEach(System.out::println);
		
		System.out.println("--- 람다식에서 지역변수");
		// 람다식에서 지역변수 사용은 제약
		// 람다식에서 외부변수 : 멤버변수, 지역변수 final 배열구조에 초기값설정
		final int[] cnt = {100};
		boardList.forEach( x -> {
			System.out.println(x);
			System.out.println("람다식 안에서 멤버변수 사용가능:"+ number++ );
			System.out.println("람다식 안에서 지역변수 사용가능:"+ cnt[0]++ );
		});
		
		// 램덤 수에서 스트림
		System.out.println("-- Random.ints()");
		IntStream intStream1 = new Random().ints(5);
		intStream1.forEach(System.out::println);
		
		System.out.println("-- limit(n)");
		IntStream intStream2 = new Random().ints(1,10).limit(10);
		intStream2.forEach( x -> System.out.print(x+" "));

	}

}

@Data@AllArgsConstructor
class Board{
	int no;
	String title;
	String user;
	LocalDateTime createdate;
}