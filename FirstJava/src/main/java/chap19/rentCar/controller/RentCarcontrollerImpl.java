package chap19.rentCar.controller;

import java.util.ArrayList;
import java.util.List;

import chap19.rentCar.dao.RentCarDAO;
import chap19.rentCar.dao.RentCarDAOImpl;
import chap19.rentCar.vo.RentCarVO;

public class RentCarcontrollerImpl implements RentCarController {
	
	public RentCarDAO rentcarDAO;
	
	public RentCarcontrollerImpl() {
		rentcarDAO = new RentCarDAOImpl();
	}

	@Override
	public List<RentCarVO> listRent(RentCarVO rentcarVO) {
		
		List<RentCarVO> renlist = new ArrayList<RentCarVO>();
		try {
			renlist  = rentcarDAO.selectRent(rentcarVO);
			
		} catch (Exception e) { System.out.println(e.getMessage()); }
		
		return renlist;
	}

	@Override
	public int regRentCar(RentCarVO rentcarVO) {
		System.out.println("regRentCar() : "+rentcarVO);
		int result = 0;
		try {
			result = rentcarDAO.insertRent(rentcarVO);
		} catch (Exception e) { System.out.println(e.getMessage()); }
		
		return result;
	}

	@Override
	public int modRentCar(RentCarVO rentcarVO) {
		int result = 0;
		
		try {
			result = rentcarDAO.updateRent(rentcarVO);
		} catch (Exception e) { System.out.println(e.getMessage()); }
		
		return result;
	}

	@Override
	public int removeRentCar(RentCarVO rentcarVO) {
		int result = 0;
		
		 try {
			result = rentcarDAO.deleteRent(rentcarVO);
		} catch (Exception e) { System.out.println(e.getMessage()); }
		 
		return result;
	}

	@Override
	public RentCarVO checkNumber(String renId) {
		RentCarVO vo = new RentCarVO();
		
		try {
			vo = rentcarDAO.checkId(renId);
			
		} catch (Exception e) { System.out.println(e.getMessage()); }
		
		return vo;
	}
	
}
