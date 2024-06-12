package chap18.controller;

import java.awt.*;

import chap18.model.MovieModel;

public class MovieController {
	
	MovieModel movieModel;
	
	public MovieController() {
		movieModel = new MovieModel();
	}
	
	// 추가 기능 요청
	public void addTitle(String title, List MovieList) {
		// 요청에 해당되는 처리기능 수행
		movieModel.addTitle(title, MovieList);
	}
	
	// 저장 기능 요청
	public void saveTitle(List MovieList) {
		// 요청에 해당되는 처리기능 수행
		movieModel.saveTitle(MovieList);
	}
	
	// 삭제 기능 요청
	public void delTitle(String title, List MovieList) {
		// 요청에 해당되는 처리기능 수행
		movieModel.delTitle(title, MovieList);
	}

	
}
