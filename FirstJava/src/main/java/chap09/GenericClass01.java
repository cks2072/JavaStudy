package chap09;

public class GenericClass01 {

	public static void main(String[] args) {
		// 제네릭 클래스 
		// 클래스내에서 사용되는 자료형을 외부에서 지정해 사용
		// 다이몬드 기호 "<영문자>" :
		// E:Element, K:key, N:Number, T:Type, V:Value
		
		GenClass<Integer> g = new GenClass<Integer>();
		g.setT(100);
		System.out.println(g.getT());
		
		GenClass<String> g2 = new GenClass<String>();
		g2.setT("김길동");
		System.out.println(g2.getT());

	}

}


class GenClass<T> {
	private T t;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
}
