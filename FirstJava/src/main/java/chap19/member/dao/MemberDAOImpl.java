package chap19.member.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap19.common.base.AbstractBaseDAO;
import chap19.member.vo.MemberVO;

public class MemberDAOImpl extends AbstractBaseDAO implements MemberDAO {

	@Override
	public List<MemberVO> selectMember(MemberVO memberVO) throws Exception {
		
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		String _memName = memberVO.getMemName();
		String sql = "";
		
		if ( _memName != null && _memName.length() !=0) {
			sql = "SELECT * FROM t_member WHERE memName = ? ORDER BY memId";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _memName);
		} else {
			sql = "select * from t_member";
			pstmt = conn.prepareStatement(sql);
		}
		
		rs = pstmt.executeQuery();
		
		  while(rs.next()) {
			  String memId = rs.getString("memId");
			  String memPassword = rs.getString("memPassword");
			  String memName = rs.getString("memName");
			  String memAddress = rs.getString("memAddress");
			  String memPhoneNum = rs.getString("memPhoneNum");
			  
			  MemberVO vo = new MemberVO();
			  vo.setMemId(memId);
			  vo.setMemName(memName);
			  vo.setMemPassword(memPassword);
			  vo.setMemAddress(memAddress);
			  vo.setMemPhoneNum(memPhoneNum);
			  
			  // 생성자를 이용하여 객체 멤버 변수에 DB로부터 받은 값을 전달
//			  MemberVO vo = new MemberVO(memId, memPassword, memAddress, memPhoneNum);
			  
//			  MemberVO vo = memberVO.builder()
//					  .memId(memId)
//					  .memPassword(memPassword)
//					  .memId(memId)
//					  .memName(memName)
//					  .memPhoneNum(memPhoneNum)
//					 .build();
				
			  memList.add(vo);
			  
		  }
		  rs.close();
		
		return null;
	}

	@Override
	public void insertMember(MemberVO memberVO) {

		
	}

	@Override
	public void updateMember(MemberVO memberVO) {

		
	}

	@Override
	public void deleteMember(MemberVO memberVO) {

		
	}

}
