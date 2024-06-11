package chap18.controller;

import chap18.model.MovieModel;

public class MovieController {
	
	MovieModel movieModel;
	
	public MovieController() {
		movieModel = new MovieModel();
		
	}
	
	// 추가 기능 요청
	public void addTitle() {
		movieModel.addTitle();
	}
	
	// 저장 기능 요청
	public void saveTitle() {
		movieModel.saveTitle();
	}
	
	// 삭제 기능 요청
	public void delTitle() {
		movieModel.delTitle();
	}

	
}
