package chap19.rentCar.controller;

import java.util.List;

import chap19.rentCar.vo.RentCarVO;

public interface RentCarController {

	public List<RentCarVO> listRent(RentCarVO rentcarVO);
	
	public int regRentCar(RentCarVO rentcarVO);
	
	public int modRentCar(RentCarVO rentcarVO);
	
	public int removeRentCar(RentCarVO rentcarVO);
	
	public RentCarVO checkNumber(String renId);
	
}
