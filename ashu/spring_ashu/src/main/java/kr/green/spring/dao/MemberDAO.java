package kr.green.spring.dao;

import kr.green.spring.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(@Param("me_id")String me_id);

}