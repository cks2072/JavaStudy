package chap10;

import java.util.ArrayList;
import java.util.List;

public class ListCollection {

	public static void main(String[] args) {
		/* Collections framework
		 * Collection, Map
		 * Collection -> List, Set
		 * List -> ArrayList, LinkedList, Vector -> Stack
		 * Set -> HashSet, SortedSet => TreeSet
		 */
		
		List<String> arr = new ArrayList<String>();
		
		arr.add("홍길동");
		arr.add("동길이");
		arr.add("동순이");
		arr.add("동길이홍");
		arr.add("동길이홍");
		
		System.out.println(arr);
		System.out.println("-- 확장 for");
		for (String s : arr) {
			System.out.println(s);
		}
		System.out.println("-- forEach");
		arr.forEach( (s) -> {
			System.out.println(s);
		});
		//arr.forEach(System.out::println);
		
		System.out.println("- add(index, data)");
		arr.add(0, "김길동");
		arr.forEach(System.out::println);
		
		
		System.out.println("-- 수정: set(index, data)"); // array[5] = 100
		arr.set(1, "감감찬");
		arr.forEach( x -> System.out.println(x) );
		
		System.out.println("-- 특정 위치 값 추출");// array[0]
		System.out.println( arr.get(0));
		System.out.println( arr.get(3));
		
		System.out.println("크기: "+arr.size());
		
		System.out.println("-- 배열에 값 있으면 index 추출");
		System.out.println(arr.indexOf("김길동"));
		System.out.println(arr.indexOf("김길동001"));// 해당 값이 없으면 -1반환
		
		System.out.println("-- 삭제:index위치에 있는 요소 삭제");
		arr.remove(5);
		arr.forEach(System.out::println);
		
		
		int idx = arr.indexOf("동길이");
		if (idx > -1) {
			System.out.print("검색결과:");
			System.out.println(arr.get(idx));
		}
		else { 
			System.out.print("검색결과:");
			System.out.println("존재하지않습니다.");
		}
		
		System.out.println("---");
		List<String> delArr = new ArrayList<String>();
		delArr.add("감감찬");
		delArr.add("동길이홍");
		
		arr.removeAll(delArr);// 묶어서 삭제할 경우
		arr.forEach( s-> System.out.println(s) );

	}

}
