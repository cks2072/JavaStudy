package chap08;

public class InterfaceClass03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

interface a {
	public void prn1();
}
interface b {
	public void prn2();
}
// 다중 인터페이스:  인터페이스 타입은 다중 상속 가능
interface c extends a, b {
	//public void prn1();
	//public void prn2();
	public void prn3();
}

class test implements c {

	@Override
	public void prn1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prn2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prn3() {
		// TODO Auto-generated method stub
		
	}
	
}