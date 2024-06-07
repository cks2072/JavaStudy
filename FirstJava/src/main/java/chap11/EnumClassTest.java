package chap11;


public class EnumClassTest {

	public static void main(String[] args) {
		// 열거형(enum) : 단순한 열거형, 값을 갖는 열거형, 4재 이상의 값을 갖는 열거형
		// final double PI = 3.14159;
		
		Color inputColor = Color.RED;
		
		System.out.println(inputColor.equals(Color.RED)? "Red": "Not Red");
		System.out.println(inputColor.equals(Size.SMALL)?"Red": "Not Red");
		
		System.out.println("-- 열거형");
		Color1 inputColor1 = Color1.RED;
		
		System.out.println(inputColor1.equals(Color1.RED)? "Red": "Not Red");
		System.out.println(inputColor1.equals(Size1.SAMLL)?"Red": "Not Red");
		
		System.out.println("열거형 반복자");
		for( Color1 c : Color1.values()) {
			System.out.println(c.name()+":"+c.ordinal());
		}
		
		System.out.println("---");
		System.out.println(Color1.RED);
		System.out.println(Size1.LARGE);
		
	}

}

// 열거형
enum Color1 {
//	final static  int RED = 0;
//	final static  int BLUE = 1;
//	final static  int ORANGE = 2;
	
	//RED{익명함수 재정의}, BLUE, ORANGE
	
	RED {
		@Override
		public String toString() {
			return "빨간색";
		}
	},
	BLUE {
		@Override
		public String toString() {
			return "파란색";
		}
	},
	ORANGE {
		@Override
		public String toString() {
			return "귤색";
		}
	}	
	
}
enum Size1 {
	SAMLL, MINDUM, LARGE;
}



//색 집합 클래스
class Color {
	//final static int R = 10;
	final static Color RED = new Color();
	final static Color BLUE = new Color();
	final static Color ORANGE = new Color();
	
}
//크기 집합 클래스
class Size {
	final static Size SMALL = new Size();
	final static Size MIDUM = new Size();
	final static Size LARGE = new Size();
}
