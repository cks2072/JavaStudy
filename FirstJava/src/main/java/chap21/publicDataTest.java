package chap21;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class publicDataTest {
	
	public static void main(String[] args) throws Exception {
		// 서울시 문화재 공공데이터
		// 인증키 6342514e75636b733739414e597077
		
		URL url = new URL("http://openapi.seoul.go.kr:8088/6342514e75636b733739414e597077/xml/SebcHeritageInfoEng/1/5/");
		InputStream stream = url.openStream();

	}

}
