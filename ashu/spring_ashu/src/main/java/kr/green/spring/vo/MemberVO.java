package kr.green.spring.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberVO {
	private String me_id;
	private String me_pw;
	private String me_name;
	private String me_gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date me_birth;
	private String me_address;
	private String me_phone;
	public String getMe_id() {
		return me_id;
	}
}
