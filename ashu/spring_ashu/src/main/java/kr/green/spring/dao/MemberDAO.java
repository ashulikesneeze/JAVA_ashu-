package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVO;

public interface MemberDAO {
	//get은 select이기 때문에 
	MemberVO getMember(@Param("me_id")String me_id);
	//insertMember는 insert type 이기 때문에 리턴타입이 void 
	void insertMember(@Param("user")MemberVO user);

}
