package chap04.vo;

public class Data {
	
	String name;
	int age;
	
	//생성자
	public Data() {
		this("",0);
	}
	public Data(String name) {
		this(name, 0); // 생성자 호출
	}
	public Data(int age) {
		this("", age); // 생성자 호출
	}
	public Data(String name, int age) {
		this.name = name;
		this.age = age;
	}
	// 멤버 함수(메서드)
	//public void hello() {}
	
	public String toString() {
		return "Data [name="+this.name+", age="+age+"]";
	}

}
