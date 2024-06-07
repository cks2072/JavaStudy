package chap10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapClass {

	public static void main(String[] args) {
		// Key와 Value 쌍으로 저장 구조
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("java", 1);
		map.put("javascript", 2);
		map.put("react", 3);
		map.put("python", 4);
		map.put("perl", 5);
		
		System.out.println(map);
		
		Set<String> keys =  map.keySet();
		//System.out.println(keys);
		System.out.println("-- keys: forEach");
		keys.forEach(System.out::println);
		
		System.out.println("맵의 매핑수: "+map.size());
		
		System.out.println(map.containsKey("delphi"));
		System.out.println(map.containsKey("java"));
		
		if (map.containsKey("java"))
			System.out.println( map.get("java") );
			//map.remove("java"); // 삭제
		else 
			System.out.println( "java가 없음" );
		System.out.println(map);
		
		
		map.computeIfPresent("java", (String key, Integer value) -> ++value );
		System.out.println(map);
		
		map.computeIfPresent("react", (String key, Integer value) -> --value );
		System.out.println(map);
		
		System.out.println("--- valueSet");
		System.out.println(map.values());
		map.values().forEach( (value) -> System.out.println(value));
		
		System.out.println("--- entrySet");
		Set entrySet = map.entrySet();
		
		System.out.println(entrySet);
		entrySet.forEach( (x)-> System.out.println(x));
		
		
	}

}
