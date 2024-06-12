package chap18.model;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class MovieModel {
	
	//추가
	public void addTitle(String title, List movieList) {
		movieList.add(title);
		System.out.println("추가 완료");
	}

	//삭제
	public void delTitle(String title, List movieList) {
		movieList.remove(title);
		System.out.println("삭제 되었습니다.");
	}
	
	// 저장
	public void saveTitle(List movieList) {
		
		File file = new File("src/main/resources/movieInfo.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			PrintWriter writer = new PrintWriter(bw, true); // autoFlush = true
			
			String items[] = movieList.getItems();
			Arrays.stream(items).forEach( (title) -> {
				writer.println(title); 		// 파일 출력
				System.out.println(title); 	// 콘솔 출력
			});
			
			bw.close();
			writer.close();
			
		} catch (Exception e) {}
		
		System.out.println("저장되었습니다.");
		
	}
}
