package chap05;

import chap05.member.Member;
import chap05.member.MemberImpl;
import chap05.member.MemberVO;

public class MemberTest {

	public static void main(String[] args) {
		// 구현하는 메서드 (등록, 조회, 수정, 삭제)
		Member member = new MemberImpl(); // 인터페이스 = 인터페이스 구현한 클래스, 업캐스팅
		
		// 회원 정보 초기화

		
		// 1. 
		//MemberVO memberVO = new MemberVO("hong", "1234", "홍길동", "010-0000-0000");
		MemberVO memberVO = MemberVO.builder()
				.id("hong").password("1234").name("홍길동").phoneNum("010-0000-0000")
				.build();
		member.regMember(memberVO); // 등록
		
		// 2.
		memberVO = MemberVO.builder()
				.id("hong2").password("1234").name("동순이").phoneNum("010-0000-1111")
				.build();
		member.regMember(memberVO); // 등록
		
		
		// 회원 정보 조회
		System.out.println("----");
		member.listMember().forEach((m)->{
			System.out.println("------");
			System.out.println(m.getId());
			System.out.println(m.getName());
			System.out.println(m.getPassword());
			System.out.println(m.getPhoneNum());
		});
		
		//MemberVO memberInfo = member.viewMember(memberVO);
		
		//System.out.println("조회결과:"+memberInfo);
//		
//		// 회원 정보 수정
//		memberVO.setName("길순이");
//		memberVO.setPhoneNum("010-1111-1111");
//		
//		System.out.println("----");
//		member.modMember(memberVO);
//		memberInfo = member.viewMember(memberVO);
//		System.out.println(memberInfo);
//		
//		System.out.println("----");
//		member.delMember(memberVO);
//		memberInfo = member.viewMember(memberVO);
//		System.out.println(memberInfo);

	}

}














