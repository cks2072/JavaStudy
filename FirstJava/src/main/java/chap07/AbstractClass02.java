package chap07;

public class AbstractClass02 {

	public static void main(String[] args) {
		// 추상 다형성(Polymorphism)
		
		//Cat cat = new Cat(false, 4);
		
		// 부모클래스 타입의 객체변수 = 자식 객체 주소
		// 업 캐스팅 : 자식클래스의 객체가 부모 클래스의 타입으로 형 변환
		// 다운 캐스팅: 부모클래스 타입인 객체가 자식 클래스의 타입으로 형 변환
		Pet cat = new Cat(false, 4);
		cat.run(getPetName(cat));// cat.run("고양이");
		
		Pet parret = new Parrot(true, 2);
		parret.run(getPetName(parret));//parret.run("앵무새");
	}
	
	//static : 객체 생성없는 함수 호출
	public static String getPetName(Pet pet) {
		String str = "";
		if(pet instanceof Cat) {
			str = "고양이";
		} else if (pet instanceof Parrot) {
			str = "앵무새";
		}
		return str;
	}

}
