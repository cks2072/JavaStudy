package chap15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUnZipClass {

	public static void main(String[] args) {
		// Zip and Unzip : 압축하기
		
		// "C:\javaStudy\java\FirstJava\src\main\java\chap02"
		String path =  "C:"+
				File.separator+"javaStudy"+
				File.separator+"java"+
				File.separator+"FirstJava"+
				File.separator+"src"+
				File.separator+"main"+
				File.separator+"java"+
				File.separator+"chap02"+
				File.separator;
		System.out.println(path);
		
		// 블럭 단위 설정 : 한번 읽어오는 단위
		byte[] bytes = new byte[1024];
		
		// 압축할 파일 목록
		String[] files = new File(path).list();
		System.out.println(Arrays.toString(files));
		
		
		try ( FileOutputStream fos = new FileOutputStream(path+"test.zip");
				ZipOutputStream zos = new ZipOutputStream(fos))  {
			
			Arrays.stream(files)
					.forEach( x -> {
						File f = new File(path+x);
						
						try ( FileInputStream fis = new FileInputStream(f) ){
							ZipEntry zipEntry = new ZipEntry(f.getName());// 압축할 파일이름
							zos.putNextEntry(zipEntry);
							
							int length;
							while( (length = fis.read(bytes)) >= 0) {
								zos.write(bytes, 0, length);
							}
							
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					});
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		

	}

}
