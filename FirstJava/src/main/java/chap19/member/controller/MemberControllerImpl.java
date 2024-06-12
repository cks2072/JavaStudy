package chap19.member.controller;

import java.util.ArrayList;
import java.util.List;

import chap19.member.dao.MemberDAO;
import chap19.member.dao.MemberDAOImpl;
import chap19.member.vo.MemberVO;

public class MemberControllerImpl implements MemberController {
	public MemberDAO memberDAO;
	
	public MemberControllerImpl() {
		memberDAO = new MemberDAOImpl();
	}
	
	@Override
	public List<MemberVO> listMember(MemberVO memberVO) {
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		// 회원 정보 조회하는 DAO 를 호출
		try {
			memList = memberDAO.selectMember(memberVO);
			
		} catch (Exception e) { System.out.println(e.getMessage()); }
		
		return null;
	}

	@Override
	public void regMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
	}

}
