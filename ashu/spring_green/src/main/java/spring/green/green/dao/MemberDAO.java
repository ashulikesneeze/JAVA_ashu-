package spring.green.green.dao;

import org.apache.ibatis.annotations.Param;

import spring.green.green.vo.MemberVO;

public interface MemberDAO {

		void insertMember(@Param("user")MemberVO user);

		MemberVO selectMember(@Param("me_id")String me_id);

}
