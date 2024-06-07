package chap12;

public class FunInterface01 {

	public static void main(String[] args) {
		// 함수형 인터페이스(Function Interface) : 익명함수
		// 람다식(Lambda expression)
		// 메서드 참조(Method reference): x -> System.out.print(x) ==> System.out::println
		
		Sample01Function f = () -> System.out.println("함수형 인터페이스 내용입니다.");
		f.test();
		
		//Sample02Function f3 = (t) -> "홍길순"+"동길이";
		Sample02Function f2 = (t) -> {
			String result = "";
			for (int i=0; i< t; i++) {
				result += "만세\n";
			}
			return result;
		};
		
		System.out.println("== 만세 삼창");
		System.out.println(f2.test(3));
		
//		A a = new AA();
//		a.test2();
	}

}

@FunctionalInterface
interface Sample01Function {
	public abstract void test(); // 한 개이상 추상 메서드
}

@FunctionalInterface
interface Sample02Function {
	public abstract String  test(int times);
}



//인터페이스를 사용하려면 하위 클래스에서 구현
interface A {
	public abstract void test2();
}
class AA implements A{
	@Override
	public void test2() {
		System.out.println("클래스에 구현한 인터페이스");
	}
}

