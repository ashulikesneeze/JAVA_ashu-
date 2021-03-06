package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	MemberDAO memberDao; 
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public MemberVO login(MemberVO member) {
		if (member == null || member.getMe_id() == null)
			return null;
		MemberVO user = memberDao.getMember(member.getMe_id());
		//로그인에 성공하면 회원정보를 실패하면 null을 반환
		if(user == null)
			return null;
		//matches(원래비번과 암호화된 비번) : 같으면 true 다르면 false
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw()))
			return user;
		return null;
	}
	@Override
	public boolean signup(MemberVO user) {

		//보안 관리를 위해 귀찮더라도 필수!!!
		if(user == null)
			return false;
		//필수항목인 아이디가 null인지 체크
		if(((MemberVO) user).getMe_id()== null)
			return false;
		//필수항목인 비번이 null인지 체크
		if(((MemberVO) user).getMe_pw()==null)
			return false; 
		//아이디 중복 검사 
		if(memberDao.getMember(((MemberVO) user).getMe_id()) != null)
			return false;
		//암호화된 비밀번호/ DAO insert 전에 암호화가 와야함!!
		String encPw = passwordEncoder.encode(user.getMe_pw());
		user.setMe_pw(encPw);
		//정보수정일 경우 updateMember로 
		memberDao.insertMember(user);
		return true; 
		
	}

	
}
