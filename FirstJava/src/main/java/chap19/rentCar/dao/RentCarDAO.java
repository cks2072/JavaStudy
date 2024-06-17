package chap19.rentCar.dao;

import java.util.List;

import chap19.rentCar.vo.RentCarVO;

public interface RentCarDAO {

	public List<RentCarVO> selectRent(RentCarVO rentcarVO);

	public int insertRent(RentCarVO rentcarVO);
	
	public int updateRent(RentCarVO rentcarVO);
	
	public int deleteRent(RentCarVO rentcarVO);
	
	public RentCarVO checkId(String renId);

}
