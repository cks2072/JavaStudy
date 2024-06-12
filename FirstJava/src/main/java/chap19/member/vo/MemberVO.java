package chap19.member.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MemberVO {
	private String memId;
	private String memPassword;
	private String memName;
	private String memAddress;
	private String memPhoneNum;

}
