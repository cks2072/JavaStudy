package chap02;

public class Sam02VarRef {

	public static void main(String[] args) {
		//참조형
//		String str1 = "홍길동";
//		String str2 = "홍길동";
//		System.out.println(str1 + ", "+ str2);
		
		
		// 디버거 단축키 : F8(다음브레크포인트), F5,F6(다음명령어)
		int i=0;
		i = i + 10;
		i = i + 10;
		i = i + 10;
		System.out.println(i);
		
		// 형전환 : 명시적, 묵시적
		int num1 = 10;
		short num2 = (short)num1;
		float num3 = 10;
		
		int num4 = (int)10.2;// double -> int
		
		


	}

}
