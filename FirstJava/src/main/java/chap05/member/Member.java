package chap05.member;

import java.util.ArrayList;

// 구현할 메서드 
public interface Member {
	
	public MemberVO viewMember(MemberVO vo);	// 회원 조회 메서드
	public void regMember(MemberVO vo); 	// 회원등록 메서드
	public void modMember(MemberVO vo); 	// 회원 정보 수정 메서드
	public void delMember(MemberVO vo); 	// 회원 정보 삭제 메서드
	
	public ArrayList<MemberVO> listMember(); // 회원 전체 조회 메서드
}
