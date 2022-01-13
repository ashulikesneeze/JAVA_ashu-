package spring.green.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.green.green.dao.BoardDAO;
import spring.green.green.vo.BoardVO;
import spring.green.green.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired 
	BoardDAO boardDao;

	@Override
	public List<BoardVO> getBoardList(String bd_type) {
		return boardDao.selectBoardList(bd_type);
	}

	@Override
	public BoardVO getBoardList(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
		return null;
		
		return boardDao.selectBoard(bd_num); 
	}

	@Override
	public void registerBoard(BoardVO board, MemberVO user) {
		if(board == null || user ==null)
			return;
		if(board.getBd_title() == null || board.getBd_title().trim().length() == 0)
			return;
		if(user.getMe_id() == null || user.getMe_id().trim().length()==0)
			return;
		board.setBd_me_id(user.getMe_id());
		boardDao.insertBoard(board);
	}

}
