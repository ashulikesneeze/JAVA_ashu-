package spring.green.green.service;

import spring.green.green.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO user);

	MemberVO login(MemberVO user);

}
