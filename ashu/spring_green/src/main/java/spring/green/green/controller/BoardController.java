package spring.green.green.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.green.green.service.BoardService;
import spring.green.green.vo.BoardVO;
import spring.green.green.vo.FileVO;
import spring.green.green.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	String uploadPath = "D:\\JAVA_ashu\\upload"; 
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	//@RequestMapping(value="/board/list")
	public ModelAndView boardListGet(ModelAndView mv) {
		List<BoardVO> list = boardService.getBoardList("일반"); 
		//System.out.println(list);
		mv.addObject("list", list); 
		mv.setViewName("/board/list");
		return mv;
	}
	
	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
	public ModelAndView boardDetailGet(ModelAndView mv, Integer bd_num) {	
		//최대 1개를 가져와야 되기때문에 BoardVO
		BoardVO board = boardService.getBoard(bd_num);
		//여러개를 가져 와야하기 때문에 List
		List<FileVO> fileList = boardService.getFileList(bd_num);
		//확인한 값을 화면에 전달 
		mv.addObject("board",board);
		mv.addObject("fileList",fileList);
		mv.setViewName("/board/detail");
		return mv;
	}
	
	@RequestMapping(value="/board/register", method=RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {	
		mv.setViewName("/board/register");
		return mv;
	}
	
	@RequestMapping(value="/board/register", method=RequestMethod.POST)
	public ModelAndView boardRegisterPOST(ModelAndView mv, BoardVO board,
			HttpServletRequest request, List<MultipartFile> files) {	
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//나중 공지사항 위해서 
		board.setBd_type("일반");
		boardService.registerBoard(board, user, files); 
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        String FormatName = fileName.substring(fileName.lastIndexOf(".")+1);
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+fileName);

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
	@RequestMapping(value="/board/modify", method=RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer bd_num,
			HttpServletRequest request) {	
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		BoardVO board = boardService.getBoard(bd_num);
		
		if(board == null) {
			mv.setViewName("redirect:/board/list");
		} else {
			List<FileVO> fileList = boardService.getFileList(bd_num);
			mv.addObject("fileList", fileList);
			mv.addObject("board", board);
			mv.setViewName("/board/modify"); 
		}
		return mv;
	}
	
	@RequestMapping(value="/board/modify", method=RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv,BoardVO board, 
			HttpServletRequest request,
			List<MultipartFile> files2, Integer [] fileNums) {
		//기존 첨부파일 번호인 fileNums 확인
		//화면에서 수정한 게시글 정보가 넘어오는지 확인
		//System.out.println("게시글 : " + board);
		//서비스에게 게시글 정보를 주면서 업데이트하라고 시킴
		//서비스.게시글업데이트(게시글정보)
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		boardService.modifyBoard(board, user, files2, fileNums);
		//게시글 번호를 넘겨줌
		mv.addObject("bd_num", board.getBd_num());
		mv.setViewName("redirect:/board/detail");
		return mv;
	}
	
	@RequestMapping(value="/board/delete", method=RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv,Integer bd_num, 
		HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		boardService.deleteBoard(bd_num, user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
}
