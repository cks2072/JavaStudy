package chap19.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chap19.member.controller.MemberController;
import chap19.member.controller.MemberControllerImpl;
import chap19.member.vo.MemberVO;
import chap19.member.window.RegMemDialog;

public class ExcuteAppTest {

	public static void main(String[] args) {
		
		MemberControllerImpl controller = new MemberControllerImpl();
	
		/*
		Scanner sc = new Scanner(System.in);
		
		MemberControllerImpl controller = new MemberControllerImpl();
		List<MemberVO> listMembers = new ArrayList<MemberVO>();
		
		System.out.print("이름: ");
		String name = sc.nextLine().trim();
		
//		MemberVO vo = MemberVO.builder()
//								.memName(name)
//								.build();
		
		MemberVO vo = new MemberVO();
		vo.setMemName(name);
		
		listMembers =  controller.listMember(vo);
		
		System.out.println("-- 회원 정보 조회 --");
		listMembers.stream().forEach( m -> {
			System.out.println(m);
		});
		
		// 회원 정보 입력
//		System.out.println("-- 회원 정보 입력");
//		MemberVO insertVO = new MemberVO("HONG100", "1234", "홍길동", "서울", "010-1234-4444");
//		
//		int result = controller.regMember(insertVO);
//		
//		System.out.println("result: "+result);
//		if (result > 0) {
//			System.out.println("회원 정보 등록 완료");
//		} else {
//			System.out.println("회원 정보 등록 실패");
//		}
		
		// 회원 정보 수정
		System.out.println("-- 회원 정보 수정");
		MemberVO modifyVO =  MemberVO.builder()
				.memId("HONG200")
				.memName("홍길동200")
				.memPassword("3333")
				.memPhoneNum("010-3333-3333")
				.memAddress("대구")
				.build();
		
		int result = controller.modMember(modifyVO);
		
		System.out.println("result: "+result);
		if (result > 0) {
			System.out.println("회원 정보 수정 완료");
		} else {
			System.out.println("회원 정보 수정 실패");
		}
		
		// 회원 정보 삭제
		System.out.println("-- 회원 정보 삭제");
		MemberVO delVO = MemberVO.builder().memId("HONG100").build();
		
		result = controller.removeMember(delVO);
		if (result > 0) {
			System.out.println("회원 정보 삭제 완료");
		} else {
			System.out.println("회원 정보 삭제 실패");
		}
		*/
		
		new RegMemDialog(controller, "회원등록");
		
	}

}
