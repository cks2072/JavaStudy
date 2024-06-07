package chap10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetCollection {

	public static void main(String[] args) {
		//Set : 순서가 없음. 중복 불가
		Set<String> set = new HashSet<String>();
		
		set.add("dog");set.add("dog");set.add("dog");set.add("dog");
		set.add("cat");set.add("cat");set.add("cat");
		set.add("lion");set.add("lion");
		
		System.out.println(set);
		
		System.out.println("---- ArrayList");
		List<String> list = new ArrayList<String>();
		list.add("dog");list.add("dog");
		list.add("cat");list.add("cat");
		list.add("lion");list.add("lion");
		System.out.println(list);
		
		set.addAll(list);
		
		System.out.println("--- Set: 중복제거");
		System.out.println(set);
		
		System.out.println("-- 중복제거된 set => List에 저장");
		List<String> list2 = new ArrayList<String>();
		list2.addAll(set);
		System.out.println(list2);
		

		
		
		
		

	}

}
