package kr.green.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.utils.UploadFileUtils;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDAO boardDao;
	//업로드할 폴더 경로. 환경에 따라 바꿔줘야함.
	//집
	String uploadPath = "D:\\JAVA_ashu\\upload";
	//학원
	//String uploadPath = "D:\\JAVA_JIK\\upload";

	@Override
	public void registerBoard(BoardVO board, List<MultipartFile> files) throws Exception {
		if(board == null 
			|| board.getBd_title() == null
			|| board.getBd_contents() == null
			|| board.getBd_me_id() ==null)
			return;
		
		boardDao.insertBoard(board);
		System.out.println(files);
		if(files == null)
			return;
		for(MultipartFile tmpFile : files) {
			System.out.println(tmpFile);
			//첨부파일 업로드및 DB에 저장
			//첨부파일이 있고, 첨부파일 이름이 1글자 이상인 경우에만 업로드
			if(tmpFile != null && tmpFile.getOriginalFilename().length() !=0) {
				//서버에 업로드
				String path = UploadFileUtils.uploadFile(
					uploadPath, tmpFile.getOriginalFilename(), tmpFile.getBytes());
				//DB에 저장
				FileVO fileVo = 
					new FileVO(tmpFile.getOriginalFilename(), path, board.getBd_num());
				System.out.println(fileVo);
				boardDao.insertFile(fileVo);
			}
		}
		
	}

	@Override
	public List<BoardVO> getBoardList(String type) {
		return boardDao.getBoardList(type);
	}

	@Override
	public BoardVO getBoard(Integer bd_num) {
		//게시글 번호가 없거나 0이하이면 null을 반환
		//존재할수 없는 게시글을 가져오라고 시킴 
		if(bd_num == null || bd_num <= 0)
			return null;
		//다오에게 일을 시킴
		//게시글하나 = boardDao.게시글검색(게시글번호)
		//BoardVO board = boardDao.getBoard(bd_num);
		//return board;
		return boardDao.getBoard(bd_num);
	}

	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
		//유효하지 않은 게시글 번호이면 삭제할 필요 없음
		//번호가 null이거나 음수, 0인 경우
		if(bd_num == null || bd_num <= 0)
			return;
		
		//게시글번호와 일치하는 게시글을 가져옴
		BoardVO board = boardDao.getBoard(bd_num);
		
		//가져온 게시글이 null이면 삭제할 필요 없음
		if(board == null)
			return;
		
		//게시글 작성자와 로그인한 회원 아이디가 같은지 확인하여 다르면 삭제할 필요 없음
		//board.getBd_me_id()와 user.getMe_id()가 다르면
		if(!board.getBd_me_id().equals(user.getMe_id()))
			return;
		//게시글을 삭제
		//게시글의 bd_del을 Y로 수정
		//다오에게 수정된 게시글을 업데이트하라고 시킴
		//boardDao.게시글삭제(게시글 번호);
		boardDao.deleteBoard(bd_num);
		
		/*
		board.setBd_del("Y");
		board.setBd_del_date(new Date());
		boardDao.updateBoard(board);
		*/
	}

	@Override
	public BoardVO getBoard(Integer bd_num, MemberVO user) {
		//게시글 번호가 유효한지 체크 => 번호가 없거나 0이하이면 작업할 필요 없음
		if(bd_num == null || bd_num <= 0)
			return null;
		//다오에게 게시글을 가져오라고 시킴
		//게시글 = 다오.게시글가져옴(게시글 번호)
		BoardVO board = boardDao.getBoard(bd_num);
		//가져온 게시글이 있으면 작성자와 user와 비교하여 같은 아이디인지 체크
		if(board == null || !board.getBd_me_id().equals(user.getMe_id()))
			return null;
		return board;
	}

	public void updateBoard(BoardVO, boardList<MultipartFile> files, Integer[] fileNums)) {
		//다오에게 게시글 번호와 일치하는 게시글을 가져오라고 시킴
		//게시글 = 다오.게시글가져오기(게시글번호)
		BoardVO dbBoard = boardDao.getBoard(board.getBd_num());
		
		//가져온 게시글의 제목과 내용을 board의 제목과 내용으로 덮어쓰기를 함
		dbBoard.setBd_title(board.getBd_title());
		dbBoard.setBd_contents(board.getBd_contents());
		
		//가져온 게시글의 수정일을 현재 시간으로 업데이트
		dbBoard.setBd_up_date(new Date());
		
		//다오에게 수정된 게시글 정보를 주면서 업데이트 하라고 시킴
		boardDao.updateBoard(dbBoard);
		
		//해당 게시글번호와 일치하는 첨부파일 전체를 가져옴 
		List<Integer> fileNumList = boardDao.selectFileNumList(board.getBd_num());
		//가져온 첨부파일 전체에서 fileNums에 없는 번호들의 첨부파일들을 서버에서 삭제 
		if(fileList != null && fileList.size() != 0) {
			for(fileVO tmpFileVo : fileList) {
				fileList.
			}
	
		}
		//위의 조건문을 거치고 난 뒤 fileList는 삭제살 첨부파일들 
		if(fileList != null && fileList.size() != 0) {
			for(FileVO tmpFileVo : fileList) {
				File f = 
				new File(uploadPath+tmpFileVo.getFi_name().replace("/", File.se))
			}
		}
		//DB에서도 삭제
		deleteFile(fileList);
		//새로 추가된 첨부파일 있으면 서버에 업로드
		
		//새로 추가된 첨부파일을 DB에 추가 
		uploadFile(files, bard)
	}
	@Override
	public List<FileVO> getFileList(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
		return null;
		return boardDao.selectFileList(bd_num); 
	}
	private void uploadFile(List<MultipartFile>files, Integer bd_num) {
		if(files == null)
			return;
		for(MultipartFile tmpFile : files) {
			if(tmp)
		}
	}
}
	
