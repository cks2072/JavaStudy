package chap10;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Collection_Q01 {

	public static void main(String[] args) {
		/*
		 * 로또 예상번호를 몇 개 생성할지를 키보드로 입력받아서 그 수만큼
		 * 로또 예측 번호 6개를 정렬한 뒤 출력하고, 중복은 배제
		 * 맨 뒤에 7번째 예측 번호는 '보너스'를 붙여서 다음 실행 결과예와 같이 출력
		 * 
		 * 실행 결과 예)
		 * 몇 개의 예상 번호를 출력하시겠습니까? 2
		 * 40. 43. 21. 39. 35. 14. +보너스 36.
		 * 31. 44. 6. 12. 8. 11. +보너스 2.
		 * 
		 */
		
		int times = 0 ;// 로또 예상 번호 수
		
		Scanner sc = new Scanner(System.in); // 키보드 입력
		System.out.print("몇 개의 예상 번호를 출력하시겠습니까? ");
		times = sc.nextInt();
		
		Random rnd = new Random(); // 난수 발생
		
		for (int i=0; i<times; i++) { // 로또 생성 개수
			// 로또 번호를 저장하는 저장소
			Set<Integer> setList = new TreeSet<Integer>();
			
			for (int j=0; j<7; j++) {// 로또 번호 생성 : 7개 (6개, 1개 보너스)
				
				int number = rnd.nextInt(45)+1;// 1~45
		
				//  생성된 난수가 로또번호 저장해 놓은 저장소에 있는 유무 판단
				if (!setList.contains(number)) {
					if (j==6) {
						//보너스 숫자
						for (int no : setList) {
							System.out.printf("%d. ", no);
						}
						System.out.println("+ 보너스"+number);
					} else {
						// 로또 번호 숫자 6개
						setList.add(number);
					}
					
				} else {// 이미 저장되어 있으면 
					j--; // 난수가 로또 번호에 이미 있으면 j제어변수를 다시 재설정
				} // end if 
			}// end for (j)
			//System.out.println("생성된 로또 번호:"+setList);		
		}
		
		
				
		
		
		
		
		
		
		
		
		
		
		

	}

}
