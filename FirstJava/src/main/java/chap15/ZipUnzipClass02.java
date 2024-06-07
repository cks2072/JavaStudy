package chap15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUnzipClass02 {

	public static void main(String[] args) {
		// Zip and  Unzip : 압축 풀기
		
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
		
		String[] files = new File(path).list();
		System.out.println(Arrays.toString(files));
		
//		String x = "\\abc\\efg\\kkk\\abc.txt";
//		String[] test = x.split("\\.");
//		System.out.println(Arrays.toString(test));
		
		Arrays.stream(files)
				.filter( x -> {
					String[] ext = x.split("\\."); // 경로를 포함한 파일이름과 확장자 분리: [0][1]
					if (ext.length == 2 && "zip".equals(ext[1])) {
						return true;
					}
					return false;
				})
				.forEach( x -> {
					// 압축파일을 추출 => 압축파일이름이 압축풀기 폴더이름으로 사용
					File zipPath = new File(path+x.split("\\.")[0]);
					zipPath.mkdir(); // 폴더 생성
					
					try ( ZipInputStream zis = new ZipInputStream(new FileInputStream(path+x)) ){
						
						ZipEntry zipEntry = null;
						while( (zipEntry = zis.getNextEntry()) != null) { // 압축 파일 요소가 있으면
							String entryFile = path+x.split("\\.")[0]+File.separator+zipEntry.getName();
							
							try (FileOutputStream fos = new FileOutputStream(entryFile)) {
								
								byte[] bytes = new byte[1024];
								
								int length;
								while((length = zis.read(bytes)) != -1) { // 있으면
									fos.write(bytes, 0, length);
									
								}
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
	
				});
				
		
		
		

	}

}
