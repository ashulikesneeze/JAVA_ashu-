package spring.green.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.green.green.service.BoardService;
import spring.green.green.vo.BoardVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	//@RequestMapping(value="/board/list")
	public ModelAndView boardListGet(ModelAndView mv) {
		List<BoardVO> list = boardService.getBoardList("일반"); 
		//System.out.println(list);
		mv.addObject("list", list); 
		mv.setViewName("/board/list");
		return mv;
	}

}
