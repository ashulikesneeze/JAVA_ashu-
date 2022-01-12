package spring.green.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.green.green.dao.BoardDAO;
import spring.green.green.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired 
	BoardDAO boardDao;

	@Override
	public List<BoardVO> getBoardList(String bd_type) {
		return boardDao.selectBoardList(bd_type);
	}

}
