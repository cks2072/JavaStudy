package chap19.main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ArrayStack;

import chap19.member.controller.MemberController;
import chap19.member.controller.MemberControllerImpl;
import chap19.member.vo.MemberVO;
import chap19.member.window.RegMemDialog;
import chap19.res.controller.ResController;
import chap19.res.controller.ResControllerImpl;
import chap19.res.dao.ResDAO;
import chap19.res.vo.ResVO;

public class ExcuteAppTest {

	public static void main(String[] args, MemberVO member) {
		
		MemberControllerImpl controller = new MemberControllerImpl();
		/*
		Scanner sc = new Scanner(System.in);
		
		
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
		System.out.println("-- 회원 정보 입력");
		MemberVO insertVO = new MemberVO("HONG100", "1234", "홍길동", "서울", "010-1234-4444");
		
		int result = controller.regMember(insertVO);
		
		System.out.println("result: "+result);
		if (result > 0) {
			System.out.println("회원 정보 등록 완료");
		} else {
			System.out.println("회원 정보 등록 실패");
		}
		
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
		

//		new RegMemDialog(controller, "회원 등록");
		
		System.out.println("-- 렌트카 예약 등록");
		ResController resController = new ResControllerImpl();
		
		// Conver java.util.Date to java.sql.date
		java.util.Date utilDate = new java.util.Date();
		long milliSeconds = utilDate.getTime();
		Date sqlDate = new Date(milliSeconds);
		
		System.out.println("-- utilDate:"+utilDate);
		System.out.println("-- sqlDate:"+sqlDate);

		// Convert LocalDate to java.sql.Date
		//LocalDate.now();
		LocalDate localDate = LocalDate.of(2024, 3, 1);
		Date sqlDate2 	= Date.valueOf(localDate);	
		Date startDate 	= Date.valueOf(localDate.plusDays(1));
		Date endDate 	= Date.valueOf(localDate.plusDays(3));
		
		System.out.println("-- localDate:"+localDate);
		System.out.println("-- sqlDate2:"+sqlDate2);
		
		// Conver java.sql.Date -> LocalDate
		LocalDate localDate3 = sqlDate2.toLocalDate();
		System.out.println("-- sql.Date-> localDate:"+localDate3);
		
		
		ResVO resVO = ResVO.builder()
				.resNumber("100")
				.resCarNumber("2000")
				.resDate(sqlDate2)
				.useBeginDate(startDate)
				.returnDate(endDate)
				.resUserId("hong100")
				.build();
		
		System.out.println("-- resVO:"+resVO);
		
		
//		int result = resController.regResInfo(resVO);
//		System.out.println("-- 예약 등록 result:"+result);
		
//		System.out.println("-- 예약 변경");
//		LocalDate localDate2 = LocalDate.of(2024, 4, 1);
//		Date sqlDate3 	= Date.valueOf(localDate2);	
//		Date startDate2 = Date.valueOf(localDate2.plusDays(1));
//		Date endDate2 	= Date.valueOf(localDate2.plusDays(3));
//		
//		ResVO resVO2 = ResVO.builder()
//				.resNumber("100")
//				.resCarNumber("1000")
//				.resDate(sqlDate3)
//				.useBeginDate(startDate2)
//				.returnDate(endDate2)
//				.resUserId("hong200")
//				.build();
//		
//		System.out.println("-- resVO2:"+resVO2);
//		int result = resController.modResInfo(resVO2);
//		System.out.println("-- 예약 변경 result:"+result);
		

		System.out.println("-- 예약 취소");
		ResVO removeResVO = ResVO.builder()
				.resNumber("100")
				.build(); 
		
		System.out.println("-- removeResVO:"+removeResVO);
		
//		int result3 = resController.cancelResInfo(removeResVO);
//		System.out.println("-- 예약 삭제 result:"+result3);
		
		
		System.out.println("-- 예약 조회");
		ResVO listVO = ResVO.builder()
				.resNumber(null)
				.build(); 
		
		List<ResVO> listResInfo = new ArrayList<ResVO>();
		listResInfo = resController.listResInfo(listVO);
		listResInfo.forEach( resInfo -> {
			MemberController memberController = new MemberControllerImpl();
			MemberVO memverVO = MemberVO.builder()
									.memId(resInfo.getResNumber())
									.build();
			
			System.out.println("---- 렌트카 예약 조회 List");
			System.out.println("예약자:"+resInfo.getResUserId());
			MemberVO members = memberController.checkId(resInfo.getResUserId());
			System.out.println("예약자 이름: "+member.getMemName());
			System.out.println("예약자 전화번호: "+member.getMemName());
			System.out.println("예약자 주소: "+member.getMemName());
			System.out.println("------");
			
			System.out.println("차번호:"+resInfo.getResCarNumber());
			System.out.println("예약신청일:"+resInfo.getResDate());
			System.out.println("렌탈 시작일:"+resInfo.getUseBeginDate());
			System.out.println("렌탈 마지막일:"+resInfo.getResCarNumber());
			
		});
	}

}
