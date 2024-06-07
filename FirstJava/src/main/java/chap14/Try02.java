package chap14;

public class Try02 {

	public static void main(String[] args) {
		// throw : 강제로 오류를 발생
		
	
		try {
			System.out.println("1. throw 객체로 인위적(강제)으로 오류를 발생");
			
			throw new UnsupportedOperationException("throw로 오류를 강제로 발생");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(" -- 오류를 위임: 상위 영역으로 넘기기");
		
		try {
			
			excute(); // 함수를 호출
			excute2();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("execute()정상 처리 되었습니다.");
		
		
	}
	public static void excute() throws Exception{
		
		System.out.println(  30/0 );

	}
	public static void excute2() throws Exception{
		
		throw new Exception("throws로 오류를 강제로 위임시킴!!!");
	}

}
