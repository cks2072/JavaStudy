package chap05;

public class NestedClass02 {

	public static void main(String[] args) {
		// - 지역 내부 클래스
		NestedClass02 outer = new NestedClass02();
		outer.localMethod();

	}
	
	// (default)
	void localMethod() {
		int age = 23;
		
		// 지역클래스 : "{}"블럭내에서 클래스 선언
		class LocalClass {
			public void howOldAreYou() {
				System.out.println("홍길동 나이: "+age);
			}
		} // inner class
		
		LocalClass innerClass = new LocalClass();
		innerClass.howOldAreYou();
		
	}// end localMethod()

}
