package chap11;

import java.text.CompactNumberFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateClassCollectionTest {

	public static void main(String[] args) {
		// 날짜와 시간, 숫자 처리
		
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		System.out.println(date);
		
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		// 숫자 표시: #,0
		int myMoney = -5000;
		System.out.println(myMoney);
		
		DecimalFormat df = new DecimalFormat("#,###.##");
		System.out.println(df.format(myMoney));
		
		//DecimalFormat df2 = new DecimalFormat("#,###,##0");
		//DecimalFormat df2 = new DecimalFormat("0.0#E0");
		DecimalFormat df2 = new DecimalFormat("(수익)#,##0;(손실)#,##0");
		System.out.println(df2.format(50000));
		System.out.println(df2.format(-50000));
		System.out.println(df2.format(0));
		
		DecimalFormat df3 = new DecimalFormat("##0%");
		System.out.println(df3.format(0.01));
		
		// 숫자를 줄여서 표시
		int users = 14638;
		int views = 1500;
		NumberFormat nf = CompactNumberFormat.getCompactNumberInstance();// 싱글 톤
		System.out.printf("구독자 %s\n", nf.format(users));
		System.out.printf("조회수 %s\n", nf.format(views));
		
		// 날짜, 시간 형식
		Date today = new Date();
		System.out.println("today: "+today);
		
		SimpleDateFormat f1 = new SimpleDateFormat("YYYY년 MM월 dd일 E HH시 MM분 ss초");
		System.out.println(f1.format(date));
		
		// LocalDate : 날짜정보 다루는 클래스 
		LocalDate ldate1 = LocalDate.now();
		System.out.println("localdate:"+ldate1);
		
		LocalDate ldate2 = LocalDate.parse("2023-05-26"); // 문자열 -> 날짜형
		System.out.println(ldate2.plusDays(365));
		
		System.out.printf("%d년은 %s입니다.\n",ldate1.getYear() ,(ldate1.isLeapYear())  );
		System.out.printf("%d년은 %s입니다.\n",ldate2.getYear() ,(ldate2.isLeapYear())  );
		
		System.out.println(ldate1.minusYears(1)+","+ldate1.plusYears(1));
		System.out.println(ldate1.minusMonths(1)+","+ldate1.plusMonths(1));
		System.out.println(ldate1.minusWeeks(1)+","+ldate1.plusWeeks(1));
		System.out.println(ldate1.minusDays(100)+","+ldate1.plusDays(100));
		
		LocalTime time1 = LocalTime.now();
		System.out.println("localTime(): "+time1);
		System.out.println(time1.getHour());
		
		LocalTime time2 = LocalTime.of(11,20,11); // 숫자 -> 시간 개체 전환
		System.out.println(time2+","+time2.plusHours(1));
		
		LocalTime time3 = LocalTime.now(ZoneId.of("Asia/Tokyo"));
		System.out.println(time3);
		
		//ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
		
		
		LocalDateTime time4 = LocalDateTime.now();
		System.out.println(time4);
		
		
		
		
		
		
		
		

	}

}
