package chap15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class File03 {

	public static void main(String[] args) {
		System.out.println("-- 한글 한문자 처리: 3byte구성 , 3회 read() --");
		try ( FileInputStream fis = new FileInputStream("hangul.txt");
			  FileOutputStream fos = new FileOutputStream("hangule2.txt")) {
			
			// 영문자 : 1byte
			// 한글: UTF-8방식 => 3byte, EUC-KR: 2byte
			fos.write( fis.read());
			fos.write( fis.read());
			fos.write( fis.read());
			
		} catch (Exception e) {}
		
		System.out.println("-- 글자단위로 처리: Reader, Writer");
		try ( FileReader fr = new FileReader("hangul.txt");
			  FileWriter fw = new FileWriter("hangule3.txt")) {
			
			fw.write( fr.read());
			fw.write( fr.read());
			fw.write( fr.read());
		} catch (Exception e) {}
		
		

	}

}
