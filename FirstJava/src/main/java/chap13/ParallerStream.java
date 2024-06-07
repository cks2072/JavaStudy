package chap13;

import java.util.stream.IntStream;

public class ParallerStream {

	public static void main(String[] args) {
		// 병렬 스트림: 순서가 필요하지 않은 작업: 동시에 처리하여 빠른 처리를 할 경우
		
		long processTime1 = System.currentTimeMillis();
		IntStream.rangeClosed(65,74)
				.forEach( x -> System.out.println(Thread.currentThread().getClass()+" - "+ (char) x));
		
		long result = System.currentTimeMillis() - processTime1;
		System.out.println("직렬 스트림 출력 시간 - "+ result);
		
		
		long processTime2 = System.currentTimeMillis();
		IntStream.rangeClosed(65,74)
				.parallel()
				.forEach( x -> System.out.println(Thread.currentThread().getClass()+" - "+ (char) x));
		result = System.currentTimeMillis() - processTime2;
		
		System.out.println("병렬 스트림 출력 시간 - "+ result);
	}

}
