package spring.green.green.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import spring.green.green.pagination.Criteria;
import spring.green.green.vo.BoardVO;
import spring.green.green.vo.FileVO;
import spring.green.green.vo.LikesVO;
import spring.green.green.vo.MemberVO;


public interface BoardService {

	List<BoardVO> getBoardList(String string);

	BoardVO getBoard(Integer bd_num);

	void registerBoard(BoardVO board, MemberVO user, List<MultipartFile> files);

	void modifyBoard(BoardVO board, MemberVO user, List<MultipartFile> files2, Integer[] fileNums);

	void deleteBoard(Integer bd_num, MemberVO user);

	List<FileVO> getFileList(Integer bd_num);

	List<BoardVO> getBoardList(Criteria cri);

	int getTotalCount(Criteria cri);

	void updateViews(Integer bd_num);

	String likes(LikesVO likes, MemberVO user);

	String views(LikesVO likes, MemberVO user);

	}
