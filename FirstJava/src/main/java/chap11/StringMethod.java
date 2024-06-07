package chap11;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringMethod {

	public static void main(String[] args) throws UnsupportedEncodingException, ClassNotFoundException {
		// String Method 
		
		String str = "Hello Java !!!";
		
		System.out.println("length():"+str.length());
		System.out.println("charAt(index):"+str.charAt(3));
		System.out.println("indexOf(문자):"+str.indexOf('o'));
		System.out.println("indexOf(문자):"+str.indexOf('z'));// 없는 경우 -1 반환
		
		System.out.println("replace():"+str.replace("Java", "python"));
		System.out.println("substring(start, end):"+ str.substring(3));
		System.out.println("substring(start, end):"+ str.substring(0,3));	
		System.out.println("substring(start, end):"+ str.substring(2,3));		
		
		System.out.println("trim(): "+" hello ".length()+","+" hello ".trim().length());
		System.out.println("concat():"+str.concat(" hello python !!!"));
		

		System.out.println("=== 주민 번호 뒷번호 *표시");
		// 주민 번호 뒷번호 *표시하기
		
		String jumin = "901001-123456";
		int idx = jumin.indexOf("-"); 				//System.out.println(idx);
		String front = jumin.substring(0, idx); 	// System.out.println(front );
		String temp = jumin.substring(idx+1, jumin.length());	// System.out.println(temp);
		
		String end = "";
		for (int i=0; i< temp.length(); i++) {
			if (i==0) {
				end += temp.charAt(i); // 주민 뒷자리 첫번째 숫자
			}else { // 주민 뒷자리 두번째 이후 숫자
				end += "*";
			}
		}
		System.out.println("주민번호: "+front+"-"+end);
		
		
		// split(): 문자열을 특정문자로 기준으로 분리해서 배열로 저장
		String fruitData = "사과 바나나 귤 수박";
		
		String[] data = null;
		data = fruitData.split(" ");
		
		System.out.println("- for");
		for( int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
		System.out.println("-- for");
		for (String s : data) System.out.println(s);
		
		// 문자열을 바이트배열로 전환
		byte[] b = "ahello".getBytes();
		System.out.println("-- getBytes()");
		System.out.println(b.length);
		System.out.println(Arrays.toString(b));
		String decodeName2 = new String(b, 2,3, "UTF-8");
		System.out.println(decodeName2);
		
		// StringBuffer : String+Buffer기능 추가
		// 멀티 스레드 동기화를 제공
		String name = "홍길동";
		System.out.println(name.concat("길순이"));
		System.out.println(name);
		
		StringBuffer sb = new StringBuffer("홍길순");
		System.out.println(sb);
		sb.append("동길이");
		sb.append("동순이");
		
		System.out.println(sb);
		
		// 멀티 스레드 동기화를 제공하지 않음
		StringBuilder sb2 = new StringBuilder("부산");
		System.out.println(sb2);
		sb2.append("서울"); sb2.append("대구");
		System.out.println(sb2);
		
		// class 클래스 :  실행 중 메모리의 클래스 객체로 부터 원래 클래스에 관한 정보 추출
		//1. 
		Class c1 = EnumClassTest.class;
		System.out.println(c1.getName());
		System.out.println(c1.getSimpleName());
		System.out.println(c1.getPackage().getName());
		
		Class c2 = Class.forName("chap10.MapClass"); // chap10.MapClass.class
		System.out.println(c2.getName());
		System.out.println(c2.getSimpleName());
		System.out.println(c2.getPackage().getName());
		
		EnumValue e1 = new EnumValue();
		Class c3 = e1.getClass();
		
		System.out.println(c3.getName());
		System.out.println(c3.getSimpleName());
		System.out.println(c3.getPackage().getName());	
		
		// 같은 경로에 있는 다른 리소스파일(.xml, 이미지, 설정파일 등)의 경로 추출
		String sPath = c3.getResource("cup-8.jpg").getPath();
		System.out.println(sPath);
		
		// StringTokenizer클래스 : split()와 유사
		String data1 = "사과 바나나 수박 참외";
		String data2 = "202405/27";
		
		StringTokenizer str1 = new StringTokenizer(data1) ; // 구분자 생략시 공백
		while(str1.hasMoreTokens()) {
			System.out.println(str1.nextToken());
		}
		
		StringTokenizer str2 = new StringTokenizer(data2, "/") ; 
		while(str2.hasMoreTokens()) {
			System.out.println(str2.nextToken());
		}		
		
		
		
		
		
		
		
	}

}

