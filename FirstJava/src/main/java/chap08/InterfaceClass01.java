package chap08;

public class InterfaceClass01 {

	public static void main(String[] args) {
		// 인터페이스 : 상수와 추상메서드로만 구성
		ICompute a = new Apartment();
		
		float area = a.compute(30);
		System.out.printf("아파트의 면적은 %f 제곱미터입니다.",area);
		
		System.out.println();
		area = a.toPyung(area);
		System.out.printf("빌라의 면적은 %f 평입니다.",area);
	}

}


// 상위 요소로 작성 : 하위클래스에 구현할 목적으로 작성
interface ICompute {
	// abstract 생략 가능 
	static final float pyung = 3.3f;// static final 생략 가능
	
	// 추상 메서드 , abstract 생략 가능
	float compute(int area);  // 함수(메서드)
	
	default float toPyung(float area) { // 디폴트 메서드
		return area / pyung;
	}
}

class Apartment implements ICompute{

	@Override
	public float compute(int area) {
		//pyung++; // 인터페이스에서 선언된 상수는 변경안됨 
		return area * pyung ;
	}
	
}



/*
 * 
 * 
 * 
*/