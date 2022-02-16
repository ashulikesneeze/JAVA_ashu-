package spring.green.green.service;

import java.util.List;

import spring.green.green.pagination.Criteria;
import spring.green.green.vo.CommentVO;
import spring.green.green.vo.MemberVO;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

	List<CommentVO> selectCommentList(Integer bd_num, Criteria cri);

	int selectCommentCount(Integer bd_num);

	boolean deleteComment(Integer co_num, MemberVO user);

	boolean modifyComment(CommentVO comment, MemberVO user);

}
