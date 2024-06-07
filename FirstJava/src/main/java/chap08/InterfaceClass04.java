package chap08;

import java.util.Arrays;

public class InterfaceClass04 {

	public static void main(String[] args) {
		/* 인터페이스
		 * - 추상 클래스가 발전된 기능
		 * - 멤버는 상수와 추상 메서드만 가능
		 * - 인터페이스 구현하는 클래스는 반드시 추상클래스를 구현해야 함.
		 * - 인터페이스 타입 참조변수를 이용해서 업캐스팅으로 많이 사용
		 * - 인퍼페이스는 하위 클래스들의 기능을 표준화
		 */
		//  정수형 => 개체로 전환 => 정수형 객체 : Wrapper클래스
		//  정수형객체 = 정수형 : 오토박싱, float f = 10;
		Data asc = new AscData();// 업캐스팅 : 부모참조변수 = 자식변수,객체
		asc.setData(1,2,6,9,4); // int -> Integer
		
		System.out.println("-- 정렬 전 ");
		System.out.println(asc.toString());// 배열값 출력
		
		asc.sort();// 오름차순 정려하는 메서스 실행
		
		System.out.println("-- 정렬 후 ");
		System.out.println(asc);
		
		
		System.out.println("-----------------");
		Data desc = new DescData();
		desc.setData(1,2,6,9,4);
		
		System.out.println("-- 정렬 전 ");
		System.out.println(desc.toString());// 배열값 출력
		
		desc.sort();// 내림차순 정려하는 메서스 실행
		
		System.out.println("-- 정렬 후 ");
		System.out.println(desc);
		
		
		

	}

}

