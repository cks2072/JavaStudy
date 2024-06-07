package chap08;

import java.util.Arrays;
import java.util.Comparator;

// 추상 클래스 : 하나이상의 추상메서드가 포함된
public abstract class Data {
	Integer[] data;
	
	// 배열을 입력하는 메서드
	public void setData(Integer...  data) { // 가변 인자: data[0],....
		this.data = data;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(data); // 배열 내용 상태 표시
	}
	
	// 추상 메서드: 본체가 없는 메서드
	public abstract void sort(); 
}

// 오름 차순 처리 클래스 설계
class AscData extends Data {
	
	@Override
	public void sort() {
		Arrays.sort(data); // 오름차순으로 정렬
	}
}
//내림 차순 처리 클래스 설계
class DescData extends Data {
	@Override
	public void sort() {
		Arrays.sort(data, Comparator.reverseOrder());// 내림차순
	}
}