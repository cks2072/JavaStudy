package chap10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListCollection {
	
	static List<String> list1 = new ArrayList<String>();
	static List<String> list2 = new LinkedList<String>();

	public static void main(String[] args) {
		// LinkedList
		list1.add("dog");list1.add("cat");list1.add("lion");
		myToString();
		
		list2.add("dog");list2.add("cat");list2.add("lion");
		myToString();
		
		list1.add(2, "tiger");list2.add(2, "tiger");
		myToString();
		
		list1.remove(2);list2.remove(2);
		myToString();
		
		// ArrayList => 자주 검색
		// LinkedList => 수정,삭제,삽입 작업이 빈번 할 경우
		
		
	}
	
	public static void myToString() {
		System.out.println("--");
		System.out.println("ArrayList: "+ list1);
		System.out.println("LinkedList: "+ list2);
	}

}


