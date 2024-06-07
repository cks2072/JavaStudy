package chap10;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class MapClass02 {

	public static void main(String[] args) {
		
		Map<String, Integer> scoreMap = new HashMap<String, Integer>();
		
		scoreMap.put("이순신", 90);
		scoreMap.put("홍길동", 80);
		scoreMap.put("임꺽정", 88);
		scoreMap.put("인순신", 77);
		//System.out.println(scoreMap);
		
		Set<String> scoreSet = scoreMap.keySet();
		// Map구조 -> keys-> 배열에 작업 상황
		Object[] obj = scoreSet.toArray(); // 업캐스팅: String -> Object
		
		String[] arrKeys = new String[obj.length];
		for (int i=0; i<obj.length; i++) {
			
			String key = (String)obj[i]; // 다운캐스팅
			System.out.println(key+", "+scoreMap.get(key));
			
			arrKeys[i] = key;// 키값을 배열구조에 저장
		}
		
		System.out.println(Arrays.toString(arrKeys));
		
		Iterator<String> it = scoreSet.iterator();
		while( it.hasNext()) {
			System.out.println(  (String)it.next() );
		}
		
		// Enumeration : Iterator이전 
		Vector<String> v = new Vector<String>();
		v.add("홍길동");
		v.add("동길이");
		
		System.out.println("-- Enumeration: 스레드 동기화 지원");
		Enumeration<String> enu = v.elements();
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
			

	}

}
