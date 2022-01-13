package spring.green.green.service;

import java.util.List;

import spring.green.green.vo.BoardVO;
import spring.green.green.vo.MemberVO;


public interface BoardService {

	List<BoardVO> getBoardList(String bd_type);

	BoardVO getBoardList(Integer bd_num);

	void registerBoard(BoardVO board, MemberVO user);

}
