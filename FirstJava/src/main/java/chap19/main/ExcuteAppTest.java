package chap19.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chap19.member.controller.MemberController;
import chap19.member.controller.MemberControllerImpl;
import chap19.member.vo.MemberVO;

public class ExcuteAppTest {

	public static void main(String[] args) {
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
		

	}

}