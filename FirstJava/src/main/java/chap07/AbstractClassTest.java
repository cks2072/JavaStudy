package chap07;

public class AbstractClassTest {

	public static void main(String[] args) {
		// 추상 클래스는 클래스가 미완성 => 객체 생성을 할 수 없음.
		// Car car = new Car("검정","일본"); // error
		
		ElectricCar car1 = new ElectricCar("검정", "독일");
		GasolineCar car2 = new GasolineCar("실버", "한국");
		System.out.println(car1);
		System.out.println(car2);
		
		System.out.println(car1.fillUp());
		System.out.println(car2.fillUp());


	}

}
