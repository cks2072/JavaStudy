package chap10;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSortCollection {

	public static void main(String[] args) {
		// 정렬: 특정 기준으로 재배치
		// 정렬방식( 선택, 버블, 이진, 퀵....)
		
		System.out.println("-- 배열 : 선택 정렬하기");
		int[] num = {8,3,9,10,4};
		System.out.println(Arrays.toString(num));
		
		// 선택정렬
		for (int i=0; i<num.length-1; i++) {
			for(int j=i+1; j<num.length; j++) {
				//System.out.println(i+","+j);
				if(num[i] > num[j]) { // 오름차순 
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}// inner for
			
			System.out.println(i+"번째 정렬");
			System.out.println(Arrays.toString(num));
			System.out.println("---");
			
		}// outer for
		
		System.out.println("-- List : 버블 정렬하기");
		
		var list = new ArrayList<Integer>();
		list.add(10); // int => Integer전환
		list.add(3); 
		list.add(8); 
		list.add(2); 
		list.add(9); 
		
		System.out.println("정렬전:"+list);
		
		for(int times=0 ; times<list.size() -1; times++) {
			for (int i=0; i<list.size() - (times+1); i++) {
				var target1 = list.get(i);
				var target2 = list.get(i+1);
				
				if (target1 > target2) {
					list.set(i, target2);
					list.set(i+1, target1);
				}
				System.out.println(target1+","+target2+"="+list);
			} // innter for
			System.out.println((times+1)+"회");
		}// outer for
		System.out.println("최종 정렬: "+list);
	}

}
