package chap13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectMethod06 {

	public static void main(String[] args) {
		// flatMap() : 여러개의 stream 을 모두 합쳐서 하나의 스트림으로 반환

		String[] str1 = {"홍길동","동길이","동순이"};
		String[] str2 = {"이순신","강감찬","을지문덕"};
		
		Stream<String[]> strm = Stream.of(str1, str2);
		
		System.out.println(strm);
		strm.forEach( x -> {
			System.out.println("---");
			System.out.println(Arrays.toString(x));
			for (String s : x) {
				System.out.println(s);
			}
		});
		
		System.out.println("--- flatmap");
		Stream<String[]> strm2 = Stream.of(str1, str2);
		
		List<String> list = 
				strm2.flatMap( x -> Arrays.stream(x))
				.collect(Collectors.toList());
		
		System.out.println(list);
		
		
	}

}
