package spring.green.green.service;

import java.util.List;

import spring.green.green.vo.BoardVO;


public interface BoardService {

	List<BoardVO> getBoardList(String bd_type);

}
