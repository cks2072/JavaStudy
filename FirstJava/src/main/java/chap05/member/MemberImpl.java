package chap05.member;

import java.util.ArrayList;

public class MemberImpl implements Member {
//	String memberData;

	// 동적 배열 처리
	ArrayList<MemberVO> members = new ArrayList<MemberVO>();

	@Override
	public MemberVO viewMember(MemberVO vo) {
		
		System.out.println("회원 정보 조회");
		
//		System.out.println(members.indexOf(vo));//있으면 위치, 없으면 -1
		
		int idx = members.indexOf(vo);
//		System.out.println(members.get(idx));
		
		return members.get(idx);
		
	}

	@Override
	public void regMember(MemberVO vo) {
	
		
		// list에 추가
		members.add(vo);
		
		System.out.println("회원 가입되었습니다.");
		System.out.println(members);

	}

	@Override
	public void modMember(MemberVO vo) {

	System.out.println("회원 수정되었습니다.");
	
	}

	@Override
	public void delMember(MemberVO vo) {
//		memberData = "";
		System.out.println(vo.getId()+" 삭제 되었습니다.");
		
	}

	@Override
	public ArrayList<MemberVO> listMember() {
		
		return members;
	}

}




