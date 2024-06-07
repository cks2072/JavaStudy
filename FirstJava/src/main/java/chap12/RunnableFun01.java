package chap12;

import java.util.function.Supplier;

import lombok.AllArgsConstructor;

public class RunnableFun01 {

	public static void main(String[] args) {
		// 자주 사용하는 함수형 인터페이스를 미리 만들어서 제공
		
		// 매개변수가 없는 함수형 인터페이스
		// Runnable : void run(), Supplier: T get() 
		
		// 다형성 : + => 산술식, 결합 " 10+20, "A"+"20"
		
		Runnable r = () -> {
			System.out.println("Runnable은 매개변수도 없으며, 반환 자료형도 없는 인터페이스");
		};
		r.run();
		
		Runnable r2 = ()-> { System.out.println("안녕0"); };
		r2.run();
		
		Supplier<String> s = () -> "Supplier는 매배겨내수가 없지만 반환 자료형은 있음.";
		System.out.println(s.get());
		
		System.out.println("--- 함수형 인터페이스을 이용하여 클래스 작성 및 객체 생성");
		MessageCenter mc = new MessageCenter("Hello!!! Lambda~~~");
		
		MessageCenter main = getMsg(  () -> mc ); // 매개변수 없고, 반환값이 있는 함수식을 전달
		System.out.println(main);
		
//		String msg = getMeg2(1000);
//		System.out.println(msg);

	}
	
	// Supplier<MessageCenter> mc =  () -> mc;
	public static MessageCenter getMsg( Supplier<MessageCenter> mc) {
		return mc.get();
	}
	
//	public static String getMeg2(int num) {
//		return num+"";// 숫자+문자열 => 문자열 : 100+"" -> "100"
//	}

}

@AllArgsConstructor
class MessageCenter {
	private final String msg;
	
	@Override
	public String toString() {
		return msg;
	}

}
