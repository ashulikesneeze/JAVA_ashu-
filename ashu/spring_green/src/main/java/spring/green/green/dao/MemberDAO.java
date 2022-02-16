package spring.green.green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import spring.green.green.vo.MemberVO;

public interface MemberDAO {

		void insertMember(@Param("user")MemberVO user);

		MemberVO selectMember(@Param("me_id")String me_id);

		void updateMember(@Param("user")MemberVO inputUser);

		String selectByEmail(@Param("user")MemberVO member);

		List<MemberVO> selectMemberList();

		void updateSession(@Param("user")MemberVO user);

		MemberVO selectMemberBySessionId(@Param("me_session_id")String me_session_id);

}
