package spring.green.green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import spring.green.green.vo.BoardVO;
import spring.green.green.vo.FileVO;
import spring.green.green.vo.MemberVO;

public interface BoardDAO {
	
	List<BoardVO> selectBoardList(@Param("bd_type")String bd_type);

	BoardVO selectBoard(@Param("bd_num")Integer bd_num);

	void insertBoard(@Param("board")BoardVO board);

	void updateBoard(@Param("board")BoardVO board);

	void deleteBoard(@Param("bd_num")Integer bd_num);

	void insertFile(@Param("file")FileVO file);

	List<FileVO> selectFileList(@Param("bd_num")Integer bd_num);

	void deleteFile(@Param("fi_num")int fi_num);
}
