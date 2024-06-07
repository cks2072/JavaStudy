package chap10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetCollection {

	public static void main(String[] args) {
		//TreeSet : 이진 트리의 형태로 데이터를 저장하는 자료구조
		// 이진 트리 : 각 노드의 자식 노드가 최대 두개로 왼쪽 한 개 오른쪽 한 개로 구성 구조
		// in-order(중위 순회) : 좌측, 가운데, 우측
		// pre-order(전위 순회) : 가운데, 왼쪽, 우측
		// post-order(후위 순회): 좌측, 오른쪽, 우측
		
		var arr = new ArrayList<String>();
		arr.add("사자");arr.add("호랑이");arr.add("원숭이");
	
		System.out.println("1> ArrayList를 TreeSet으로 가져오기[addAll()]");
		
		var trs = new TreeSet<String>();
		trs.addAll(arr);
		System.out.println("TreeSet: "+trs);
		
		System.out.println("> Treeset에 타이거 추가[add()]");
		trs.add("타이거");
		System.out.println("TreeSet: "+trs);
		
		String addString = "토끼";
		System.out.printf("TreeSet에 %s가 없으면 추가[contains()]\n", addString);
		//System.out.println(trs.contains(addString));
		if (trs.contains(addString))
			System.out.printf("TreeSet에 %s가 있습니다.",addString);
		else
			System.out.printf("TreeSet에 %s가 없습니다.",addString);
		
		System.out.printf("> TreeSet에 %s보다 크거나 같은 값 중에 \n제일 가까운값을 출력[ceilling()]\n", "'자'");
		System.out.printf("%s\n", trs.ceiling("자"));
		
		System.out.printf("> TreeSet에 %s보다 작거나 같은 값 중에 \n제일 가까운값을 출력[floor()]\n", "'자'");
		System.out.printf("%s\n", trs.floor("자"));
		
		System.out.printf("> TreeSet에 %s보다 큰 값을 출력[higher()]\n", "토끼");
		System.out.printf("%s\n", trs.higher("토끼"));
		
		System.out.printf("> TreeSet에 %s보다 작은 값을 출력[lower()]\n", "토끼");
		System.out.printf("%s\n", trs.lower("토끼"));		
		
		System.out.printf("> TreeSet에 첫 번째 값을 출력[first()]\n", "토끼");
		System.out.printf("%s\n", trs.first());		
		
		System.out.printf("> TreeSet에 마지막 번째 값을 출력[last()]\n", "토끼");
		System.out.printf("%s\n", trs.last());		
		
		
		System.out.println(">Iterator로 내림차순");
		Iterator<String> it = trs.descendingIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		
	}

}
