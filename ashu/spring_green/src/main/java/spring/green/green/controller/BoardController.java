package spring.green.green.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.green.green.service.BoardService;
import spring.green.green.vo.BoardVO;
import spring.green.green.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
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
		BoardVO board = boardService.getBoardList(bd_num);
		//확인한 값을 화면에 전달 
		mv.addObject("board",board);
		mv.setViewName("/board/detail");
		return mv;
	}
	
	@RequestMapping(value="/board/register", method=RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {	
		mv.setViewName("/board/register");
		return mv;
	}
	
	@RequestMapping(value="/board/register", method=RequestMethod.POST)
	public ModelAndView boardRegisterPOST(ModelAndView mv, BoardVO board, HttpServletRequest request) {	
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//나중 공지사항 위해서 
		board.setBd_type("일반");
		boardService.registerBoard(board, user); 
		mv.setViewName("redirect:/board/list");
		return mv;
	}

}
