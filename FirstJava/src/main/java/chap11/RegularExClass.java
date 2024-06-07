package chap11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExClass {

	public static void main(String[] args) {
		// 정규 표현식
		String str = "1234567890";
		
		Pattern p = Pattern.compile("^[0-9]*$");
		Matcher m = p.matcher(str);
		
		System.err.println(m.find());
		
		System.out.println(str.matches("^[0-9]*$"));
		
		// 대문자와 숫자만 입력하는 6자리의 문자열 검사
		
		String[] str2 = {"ASDF12", "123456", "QWERTY","as234aa", "1324kkk"};
		String regex ="^[0-9A-Z]{6}$";
		
		for (String data : str2) {
			System.out.printf("%s\t %b\n",data, data.matches(regex));
		}
		
		String target = "sample@sample.com, test@test.co.kr, example@example.com";
		String regex1 = "([\\w]*@[\\w]*.com)"; // "\w" -> [0-9a-zA-Z]와 도일
		
		Pattern pattern = Pattern.compile(regex1);
		Matcher matcher = pattern.matcher(target);
		
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
		
		// 치환 : 숫자가 아닌값 제거
		String[] str3 = {"ASDF12", "123456", "QWERTY","as234aa", "1324kkk"};
		String regex3 = "[^0-9]";
		
		for (String data : str3) {
			System.out.printf("%s\t %S\n",data, data.replaceAll(regex3, ""));
		}
				
		// 주민번호
		
		String no = "주민등록번호: 010101-1234567 " +"주민등록번호: 020202-2234567 ";
		String regex4 = "[0-9]{6}-[0-9]{7}";
		
		Pattern p4 = Pattern.compile(regex4);
		Matcher m4 = p4.matcher(no);
		
		System.out.println("-- 주민번호");
		while(m4.find()) {
			System.out.print(m4.group() + "-> ");
			
			String newNo = m4.group().substring(0,7) + "****"+m4.group().substring(11);
			System.out.println(newNo);
		}

	}

}
