package chap04.vo;

public class Data2 {
	
	String name;
	int age;
	
		
	public Data2() {	
		this("김길동", 10);
	}
	public Data2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Data2 [name=" + name + ", age=" + age + "]";
	}
	
	
	
	


	
	
	

}
