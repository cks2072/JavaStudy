package chap08;

public class FinalStaticClass {

	public static void main(String[] args) {
		// final, static 
		
		DynamicNumber n1 = new DynamicNumber();
		DynamicNumber n2 = new DynamicNumber();

		System.out.println("--- n1");		
		n1.increaseNum();
		System.out.println( n1.getNumCounter() );
		n1.increaseNum();
		System.out.println( n1.getNumCounter() );
		
		System.out.println("--- n2");
		n2.increaseNum();
		System.out.println( n2.getNumCounter() );
		n2.increaseNum();
		System.out.println( n2.getNumCounter() );
		
		System.out.println("-------- static  field, method s1, s2");
//		StaticNumber s1 = new StaticNumber();
//		StaticNumber s2 = new StaticNumber();
//		
//		s1.increaseNum();
//		System.out.println( s1.getNumCounter() );
//		s1.increaseNum();
//		System.out.println( s1.getNumCounter() );
//		
//		s2.increaseNum();
//		System.out.println( s2.getNumCounter() );
//		s2.increaseNum();
//		System.out.println( s2.getNumCounter() );
		
		
		StaticNumber.num2 = 100;
		StaticNumber.increaseNum();
		System.out.println(  StaticNumber.getNumCounter()  );
		
		
		// 인스턴스 변수
		System.out.println("----------");
		
		AClass a1 = new AClass();
		AClass a2 = new AClass();
		
		System.out.println(a1.num+100);
		a1.prn();
		
		System.out.println("--");
		
		System.out.println(a2.num+1000);
		a2.prn();
		
		System.out.println("----------");

	}

}


class AClass {
	public int num = 100;
	public void prn() {
		System.out.println(num);
	}

}

class DynamicNumber {
	private int num1 = 0; // 인스턴스변수
	public int getNumCounter() {
		return num1;
	}
	public void increaseNum() {
		num1++;
	}
}

// 클래스 단위
class StaticNumber {
	static int num2 = 0; // 클래스단위 변수
	public static int getNumCounter() {
		return num2;
	}
	public static void increaseNum() {
		num2++;
	}
}