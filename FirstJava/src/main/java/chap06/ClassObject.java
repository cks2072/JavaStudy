package chap06;

public class ClassObject extends Object {

	public static void main(String[] args) {
		
		MyObject obj1 = new MyObject();
		
		String A = new String("길순이"); // 매번 기억장소를 새로 할당받음
		String B = "길순이"; // 한번 할당 받을 기억장소를 그래로 사용
		String C = "길순이";
	
		System.out.println("A:"+A);
		System.out.println("B:"+B);
		System.out.println("C:"+C);
		
		System.out.println(" A == B");
		if (A == B )
			System.out.println("주소가 같음");
		else 
			System.out.println("주소가 다름");

		System.out.println(" B == C");
		if (B == C )
			System.out.println("주소가 같음");
		else 
			System.out.println("주소가 다름");
		
		System.out.println("  A.equals(B)");
		if (A.equals(B))
			System.out.println("값이 같음");
		else 
			System.out.println("값이 다름");
		
		
	}

}

class MyObject extends Object{
	String name;

	@Override
	public String toString() {
		return "MyObject [name=" + name + "]";
	}
	
	
}

// 최상위 클래스 (Object)
// 모든 클래스는 부모클래스로 Object기능을 상속 받음.
