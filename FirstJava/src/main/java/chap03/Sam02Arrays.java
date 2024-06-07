package chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sam02Arrays {

	public static void main(String[] args) {
		// 배열
		int[] number = {10,20,30};
		int[] number1 = new int[3];
		
		System.out.println(number+","+number1);
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(number1));
		
		String[] str1 = new String[3];
		str1[0] = "홍길동";str1[1] = "홍길순";str1[2] = "동길이";
		
		String[] str2 = {"자바","파이썬","코틀린"};
				
		System.out.println(str1+","+str2);
		System.out.println(Arrays.toString(str1));
		System.out.println(Arrays.toString(str2));
		System.out.println(str1.length+","+str2.length);
		
		String[] str3 = str2.clone();// 배열 복사
		System.out.println(str3);
		System.out.println(Arrays.toString(str3));
		
		for (int i=0;i<str3.length; i++) {
			System.out.println(str3[i]);
		}
		
		String city = "서울|대전|대구|부산";
		String[] arrCity = city.split("\\|");
		System.out.println(Arrays.toString(arrCity));
		
		System.out.println("이스케이프 문자  표시:  \" \\ ");
		
		// 배열 활용하기
		// 1차원
		int[] correct = {1,2,3,4,1,4,5,2,1,3};
		// 2차원
		int[][] answer = {
				{1,2,3,4,1,4,5,2,1,3}, // 행
				{1,1,3,1,1,4,1,2,1,3},
				{1,2,3,4,1,4,5,2,1,3},
				{1,2,3,1,1,4,5,1,1,3},
				{1,2,1,4,1,4,1,2,1,3}
		};
		
		System.out.println("답안: "+Arrays.toString(correct));
		// 다차원 배열 출력
		System.out.println("학생답안: "+Arrays.deepToString(answer));
		
		
		// 만점자 찾기
		int no = 0;
		for ( int[] dap : answer) {
			no++;
			if (Arrays.equals(correct, dap) ) {
				System.out.println(no+": " +Arrays.toString(dap)+" 만점");
			} else {
				System.out.println(no+": " +Arrays.toString(dap)+" 만점 아님");
			}
		}
		
		// 배열 복사
		String[] han1 = new String[] {
				"라면","미역국", "수제비", "갈비탕","순대국"
		};
		
		String[] han2 = Arrays.copyOf(han1, han1.length-1);
		String[] han3 = Arrays.copyOf(han1, han1.length-2);
		String[] han4 = Arrays.copyOf(han1, han1.length-3);
		String[] han5 = Arrays.copyOf(han1, han1.length-4);
		String[] han6 = Arrays.copyOf(han1, han1.length-5);
		
		System.out.println(Arrays.toString(han1));
		System.out.println(Arrays.toString(han2));
		System.out.println(Arrays.toString(han3));
		System.out.println(Arrays.toString(han4));
		System.out.println(Arrays.toString(han5));
		System.out.println(Arrays.toString(han6));
		
		System.out.println("첫 번째와 마지막 요소제외한 복사");
		// copyOfRange(배열원본, 시작위치, 끝위치)
		String[] cp =  Arrays.copyOfRange(han1, 1, han1.length-1);
		System.out.println(Arrays.toString(cp));
		
		// 정렬
		//Arrays.sort(han1);
		Arrays.sort(han1, 2,5);// 1,2번째를 제외한 정렬
		System.out.println(Arrays.toString(han1));
		
		// 컬렉션 프레임워크에서 List자료형에 배열을 다른 메서드
		
		// List객체 생성하기
		List<String> st = new ArrayList<String>();
		st.add("홍길순");
		st.add("동길이");
		System.out.println(st);
		
		List<String> st2 = Arrays.asList("동길이홍","길길동");
		System.out.println(st2);
		
	}

}
