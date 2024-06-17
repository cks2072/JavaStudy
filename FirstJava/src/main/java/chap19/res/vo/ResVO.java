package chap19.res.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResVO {
	// 예약번호
	private String resNumber;
	private String resCarNumber; // 예약 차번호
	private Date resDate; 
	private Date useBeginDate;
	private Date returnDate;
	private String resUserId;// 예약자 아이디
}



