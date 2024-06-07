package chap15;

import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebCrawlingClass {

	public static void main(String[] args) {
		// 웹 크롤링(Web crawling)
		/*
		 * Document : 웹사이트의 모든 소스코드(HTML,CSS, Javascript)
		 * Elements : Doccument의 특정 범위
		 * Element : HTML 태그일부를 담을 수 있는 최종 요소
		 */
		
		Document document;
		try {
			document = Jsoup.connect("https://www.namgarambooks.co.kr/").get();
			//System.out.println(document);
			Elements elements = (Elements) document.select("#wrap .container .inner .post-item .title ");// .post_item ");
			elements.stream()
					.forEach(name -> System.out.println(name.text()));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("-- 교보문고 : 카테고리 항목 가져오기");
		List<String> category_title = new ArrayList<String>();
		// https://product.kyobobook.co.kr/new/#?page=1&sort=new&year=2024&month=06&week=1&per=20&saleCmdtDvsnCode=KOR&gubun=newGubun&saleCmdtClstCode=
		try {
			document = Jsoup.connect("https://product.kyobobook.co.kr/new/#?page=1&sort=new&year=2024&month=06&week=1&per=20&saleCmdtDvsnCode=KOR&gubun=newGubun&saleCmdtClstCode=").get();
			//System.out.println(document);
			Elements elements = (Elements) document.select("#mainDiv .container_wrapper  > #contents  > .contents_inner > #contents > .tab_wrap  #tabBest01 ul.tabs li.tab_item .tab_text");
			elements.stream()
					.forEach(name ->{ 
						System.out.println(name.text());
						
						category_title.add(name.text());
						});
			
			System.err.println("-- result ");
			System.out.println(category_title);
			
		} catch (Exception e) {}
	}
}
