package chap12;

import java.util.function.Function;

public class FunctionInterface01 {

	public static void main(String[] args) {
		// 매개변수 있고 반환값 있는 인터페이스
		// Function< T t, R r> 객체
		
		Function<Integer, String> f = (i) -> i + " index";
		String str = f.apply(10);
		
		System.out.println( str );
		
		System.out.println("-- Function Interface");
		Function<Integer, String> f2 = (i) -> {
			return switch(i)  {
						case 1 -> "one";
						case 2 -> "two";
						case 3 -> "three";
						default -> "other";
					};
			
			}; // end  Function
			
		System.out.println( f2.apply(100));

	}
	
	

}
