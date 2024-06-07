package chap07;

class ElectricCar extends Car {

	public ElectricCar(String color, String manufacturer) {
		super(color, manufacturer);// super(): 부모생성자 
	}

	@Override
	public String fillUp() {
		return "전기를 충전합니다.";
	}



}
class GasolineCar extends Car {

	public GasolineCar(String color, String manufacturer) {
		super(color, manufacturer);
	}

	@Override
	public String fillUp() {
		return "휘발유를 주유합니다.";
	}

}

