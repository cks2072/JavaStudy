package chap10;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapCollection {

	public static void main(String[] args) {
		// TreeMap : TreeSet유사, 키를 기준으로 정렬되어 key,value형태로 Entry로 저장된 Map
		
		System.out.println("HashMap은 정렬되지 않은 Key,Value형태");
		Map<String, String> hasmap = new HashMap<String, String>();
		hasmap.put("1902893", "선풍기");
		hasmap.put("1801438", "신문지");
		hasmap.put("1803962", "동백꽃");
		hasmap.put("1722761", "김길순");
		
		System.out.println(hasmap);
		
		var  map = new TreeMap<String, String>(); // 타입 추론
		map.putAll(hasmap);

		System.out.println(map);
		
		
		

	}

}














