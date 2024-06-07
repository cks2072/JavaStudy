package chap13;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectQ1 {

	public static void main(String[] args) {
		// 1. Stream을 이용해서 구구단
		
		System.out.println("-- 구구단");
		IntStream.rangeClosed(2, 9)
					.forEach( dan -> {
						System.out.println("- "+dan+"단 -");
						IntStream.rangeClosed(1, 9)
									.forEach( i -> {
										System.out.printf("%d x %d = %d \n", dan,i, (dan*i));
									});
					});
		
	
		
		// 2. 현재 수중에 500,000원을 갖고 있습니다. <보기>에 나오는 항목으로 장을 봤습니다.
		//    수중에 남는 돈은 얼마인지 reduce().메서드를 활용하여 코드 구현
		/* 보기
		 * 
		 * 빵	20,000
		 * 우유	5,000
		 * 라면 10,000
		 * 옷 200,000
		 * 신발 100,000
		 * 삼겹살 50,000
		 * 소주 10,000
		 * 삼장 2,000
		 * 상추 3,500
		 * 쌀 50,000
		 * ----
		 * 남은 돈 : 49,500
		 * 
		 */
		List<Integer> goods = Arrays.asList(
				20000, 5000, 10000, 200000, 100000, 50000, 10000, 2000, 3500, 50000
//				1,2,3
				);
		
		//System.out.println(goods); 
		// reduce(초기치,(x,y) -> x + y)
		int myMoney = 500000;
		myMoney =  goods.stream()
				.peek( x -> {
					DecimalFormat df = new DecimalFormat("#,##0원");
					
					//System.out.println("--");
					System.out.println("지출할 금액:"+df.format(x));
					//System.out.println("--");
				})
				.reduce( myMoney, (sum,data) -> {
					DecimalFormat df = new DecimalFormat("#,##0원");
					
					System.out.println("잔액="+df.format(sum));
					return sum - data;
					});
		
		System.out.println(myMoney);
		
		DecimalFormat df = new DecimalFormat("#,##0원");
		System.out.println("남은 돈 : " + df.format(myMoney));
				
		
		
		// 3. 1에서 100까지의 수 중에서 소수만 골라서 총 몇 개의 요소가 있는지 Stream을 이용하여 구현
		IntStream.rangeClosed(2, 100)
					.filter( x -> {
						int i = IntStream.rangeClosed(2, x)
											.map( y -> (x % y) == 0 ? 1: 0) // 나누어 떨이지면 1, 그렇지않으면 0
											.reduce(0, Integer::sum);
						
						// 나누어 떨어지는 회숫가 2보다 적어야 소수로 판별 (자기자신 외는 나누어 떨어진 경우가 없다)	
						return i < 2; 
					})
					.forEach(System.out::println);
		
		
		// 4. 파일명들에 확장자가 누락되어 있습니다. 파일명 뒤에'.java'를 모두 붙여서 출력하는 코드 구현
		//   보기> Sample01, Sample02,..
		//			[ Sample01.java, Sample02.java,...]
		
		List<String> fileList = Arrays.asList(
				"Sample01","Sample02","Sample03","Sample04"
				);
		System.out.println(fileList);
		List<String> newFileList = fileList.stream()
											.map(x -> x +".java")
											.collect(Collectors.toList());
		System.out.println(newFileList);
		
		// 5. 로또 번호를 스트림을 이용하여 난수를 발생시켜서 출력
		/*
		 * 조건 
		 * - 중복 값이 있으면 안된다.
		 * - 1부터 45까지의 수만 올 수 있다.
		 * - 순차적으로 정렬
		 * 
		 *  > 결과 : 2 4 5 22 24 48
		 */
		System.out.println("\n\n----");
		Stream.generate(Math::random)
				.peek(x -> System.out.println("random x:"+x))
				.map(n -> (n*44)+1)
				.peek(x -> System.out.println("(x*44)+1):"+x))
				.map(Math::round)
				.peek(x -> System.out.println("round(x*44)+1):"+x))
				.distinct()
				.limit(6)
				.sorted()
				.forEach( x -> System.out.printf("%d ", x));
				
	}

}
