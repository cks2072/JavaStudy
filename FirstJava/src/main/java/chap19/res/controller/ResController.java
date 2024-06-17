package chap19.res.controller;

import java.util.List;

import chap19.res.vo.ResVO;

public interface ResController {
	
	public List<ResVO> listResInfo(ResVO resVO);
	public int regResInfo(ResVO resVO);
	public int modResInfo(ResVO resVO);
	public int cancelResInfo(ResVO resVO);

}
