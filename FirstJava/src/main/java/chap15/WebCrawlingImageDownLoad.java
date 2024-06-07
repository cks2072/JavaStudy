package chap15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebCrawlingImageDownLoad {
	public static void main(String[] args) {
		// 다운로드 파일 위치 설정 : "C:\javaStudy\download
		String image_path =  "C:"+File.separator+"javaStudy"+File.separator+"download"+
				File.separator;
		System.out.println(image_path);
		
		// 이미지 다운
		Document document;
		try {
			document = Jsoup.connect("https://www.namgarambooks.co.kr/").get();
			//System.out.println(document);
			
			Elements elements = (Elements) document.select("#wrap .container .inner .post-item img");
			
			
			// 1.<img>에서 추출 :  "src=이미지 파일 경로 | alt=도서제목 | 이미지 확장자" 
			List<String> list =
								elements.stream()
										.map(element -> {
											
											
											//System.out.println(element.text());
											//return element.toString();
											

											String path = element.attr("src");// 
											
											// src="이미지파일"의 확장자만 추출
											// "abc.efg.txt".splite("\\.") => [0][1][2] => .length() -1 => 2
											String ext = path.split("\\.")[(path.split("\\.").length-1)];
											
											//"abvc.txtesxx" => "jpg"로 처리
											// 4자 이하는 확장자, 확장자가 없으면 jpg로 처리
											ext = ( ext.length() > 4 || "".contentEquals(ext)) ? "jpg": ext ;
											
											// 반환:  이미지src속성값 + alt속성값 + 이미지확장자
											// img태그의 alt속서에 값이 없으면 처리하는 부분
											
											String alt = element.attr("alt").trim();
											int len =  alt.length();
											
											if (len < 1) {
												UUID uuid = UUID.randomUUID();
												alt = "file_"+uuid.toString();
											} 
											
											return element.attr("src") + "|"+ alt +"|" + ext ;
											//return element.attr("src") + "|"+ element.attr("alt")+"|" + ext ;
											
										})
										.collect(Collectors.toList());
			
			list.stream().forEach(System.out::println);
			
			// 2. 다운로드 이미지 파일 리스트
			
			List<String> imgFileList =
					list.stream()
						.map(mapper -> {
							// 다운로드 파일이름 생성 : 저장할 파일이름 생성
							String returnVal = mapper.split("\\|")[1]+"."+mapper.split("\\|")[2];
							System.out.println("path=>"+ image_path+returnVal);
							
							// 이미지가 있는 서버에 URL객체로 통해 접속하여 이미지 가져오기
							URL url;
							try {
								url = new URL("https:"+mapper.split("\\|")[0]);
								try (InputStream in 	= new BufferedInputStream(url.openStream());
									 OutputStream out 	= new BufferedOutputStream(new FileOutputStream(image_path+returnVal))) {
									
									
									// 서버에 있는 이미지 파일을 읽어서 로컬 저장소에 파일로 저장
									for (int i; (i = in.read()) != -1;) {// 파일에 데이터가 있으면 처리
										out.write(i);
									}
									//int i;
									//while( (i =in.read()) != -1) {}
									
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
								
								
							} catch (MalformedURLException e) { System.out.println(e.getMessage());}
							
							return returnVal;
						})
						.collect(Collectors.toList());
			
			//imgFileList.stream().forEach(System.out::println);
			
			// 3. 압축하기
			try ( FileOutputStream fos	= new FileOutputStream(image_path+"book.zip");
				  ZipOutputStream zos 	= new ZipOutputStream(fos)){
				
				imgFileList.stream()
							.forEach(file -> {
								byte[] bytes = new byte[1024];// 블럭 단위
								
								File f = new File(image_path+ file);
								// zip 파일의 output Stream
								try (FileInputStream fis = new FileInputStream(f)) {
									
									ZipEntry zipEntry = new ZipEntry(f.getName());
									
									// 압축할 파일 추가
									zos.putNextEntry(zipEntry);
									
									int length;
									while((length = fis.read(bytes)) != 0) {
										zos.write(bytes, 0, length);	
									}
									
								} catch (Exception e2) {
									System.out.println(e2.getMessage());
								}
								
								// 1개의 이미지 -> 압축처리한 후, 원본 삭제
								//System.out.println(f.getName()+":"+f.exists());
								//if (f.exists()) {
									f.deleteOnExit();  // 프로그램이 종료될 때 파일 또는 디렉토리를 삭제하는 메서드
								//}
							
							});
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
			
			
		} catch (Exception e) { 
			System.out.println(e.getMessage());	
		}
	}
}
