package chap19.res.dao;

import java.util.List;

import chap19.res.vo.ResVO;

public interface ResDAO {
	// 회원 정보 조회 기능 처리하는 인터페이스
	public List<ResVO> selectResInfo(ResVO resVO) throws Exception;
	// 회원 정보 등록 기능 처리하는 인터페이스
	public int insertResInfo(ResVO resVO) throws Exception;
	// 회원 정보 수정 기능 처리하는 인터페이스
	public int updateResInfo(ResVO resVO) throws Exception;
	// 회원 정보 삭제 기능 처리하는 인터페이스
	public int deleteResInfo(ResVO resVO) throws Exception;
	
}
