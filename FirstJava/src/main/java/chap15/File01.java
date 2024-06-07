package chap15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class File01 {

	public static void main(String[] args) {
		// 자바 스트림 : 입출력을 도와주는 클래스
		// 바이트데이터(동영상, 이미지, 사운드 등: 1byte 단위)
		// 문자 데이터( 텍스트 : 2byte )
		
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			
			// 경로를 생략하면 프로젝트 폴더가 root("/")이고 root가 현재 위치가 됨. 
			fis = new FileInputStream("pom.xml");
			fos = new FileOutputStream("src/main/resources/hangul2.txt");
			
			int i ; //System.out.println(i);
			while( (i = fis.read()) != -1 ){ // 방금 읽은 내용(데이터)이 있으면 처리
				fos.write(i);
			
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
