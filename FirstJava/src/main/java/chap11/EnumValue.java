package chap11;

import lombok.Builder.Default;

public class EnumValue {

	public static void main(String[] args) {
		// 값을 갖는 열거형
				
		/*
		 * enum 이름 {
		 * 	상수명1(상수값1),...  ;  // 반드시 세미콜론
		 * 
		 *  private final [자료형] value;
		 *  
		 *  private enum명(자료형 value) {
		 *  	this.value = value
		 *  }
		 *  
		 *  public 자료형 getValue(){
		 *  	return value;
		 *  }
		 * }
		 */
		
		FLOWER f = FLOWER.ROSE;
		System.out.printf("I have a %s", f.getenName());
		System.out.println();
		System.out.printf("I have a %s", f.getkrName());
		
		System.out.println("\n---");
		Days toDay = Days.SATURDAY;
		
		switch(toDay) {
		case SUNDAY -> System.out.println("일요일");
		case MONDAY -> System.out.println("월요일");
		case TUESDAY -> System.out.println("화요일");
		case WEDNESDAY -> System.out.println("수요일");
		case THURSDAY -> System.out.println("목요일");
		case FRIDAY -> System.out.println("금요일");
		case SATURDAY -> System.out.println("토요일");
		default -> System.out.println("없는 요일");
		}
		


	}


}

// enum 클래스
enum FLOWER {
	SUNFLOWER("sunflower","해바라기"), ROSE("rose","장미");  
	
	private final String enName;
	private final String krName;
	
	private FLOWER(String enName, String krName) {	
		this.enName = enName; 
		this.krName = krName;
	}
	public String getenName() { return enName; }
	public String getkrName() { return krName; }
}

// 요일 처리하는 enum
enum Days {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

