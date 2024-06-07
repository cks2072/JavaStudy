package chap09;

public class GenericClass02 {

	public static void main(String[] args) {
		// 제한된 자료형의 제네릭
		Computer<ComputerPart> vga = new Computer<ComputerPart>();
		//인자 전달 방식: ComputerPart component = new Graphics();
		vga.setComponent(new Graphics());
		//vga.setComponent(new Monitor()); // error :상속관계가 아닌 클래스타입 올 수 없음
		vga.toInfo();
		
		// 생성자
		Computer<ComputerPart> mem = new Computer<>( new Memory()  );
		//Computer<ComputerPart> mem = new Computer<>( new Monitor()  ); // error
		mem.toInfo();
		
		

	}

}

// 제한된 자료형 제네릭 클래스
// ComputerPart클래스로 부터 상속받은 클래스 타입만 사용할 수 있게 제한
class Computer <T extends ComputerPart >{
	private T component;
	
	// 생성자
	public Computer() {}
	public Computer(T component) {
		this.component = component;
	}
	// 메서드
	public void toInfo() {
		System.out.println(component.getClass().getName());
	}
	public void setComponent(T component) {
		this.component = component;
	}
}



class ComputerPart{}
class Graphics extends ComputerPart{} //상속관계
class Memory extends ComputerPart {} //상속관계

class Monitor{}



