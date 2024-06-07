package chap07;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public abstract class Car { // abstract 키워드 : 추상클래스
	private String color; // 색
	private String manufacturer;//제조사
	
//	public Car(String color, String manufacturer) {
//		this.color = color;
//		this.manufacturer = manufacturer;
//	}
	
	
	public void printInfo() {
		System.out.println("이 차의 색: "+this.color);
		System.out.println("이 차는 "+fillUp());
		System.out.println("이 차는 :"+this.manufacturer+"에서 생산합니다.");
	}
	
	// 추상 메서드
	public abstract String fillUp();



}
