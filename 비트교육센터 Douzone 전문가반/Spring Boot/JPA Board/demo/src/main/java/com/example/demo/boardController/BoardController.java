package com.example.demo.boardController;

import java.util.List;

import com.example.demo.model.Board1;
import com.example.demo.repository.BoardRepository;
import com.example.demo.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	BoardRepository boardRepository;

	// 루트요청(localhost:8080/board/)시 리스트 보기로
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "redirect:/board/main";
	}

	// 게시판 리스트 보기
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		return "main";
	}
	
	// 게시판 리스트 보기
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String findAll(Model model) {
		List<Board1> list = boardService.findAll();
		System.out.println("list");
		model.addAttribute("list", list);
		return "list";
	}

	// 게시판 글쓰기 창으로 가기
	@RequestMapping(value = "/writeform", method = RequestMethod.GET)
	public String writeform() {
		return "writeform";
	}

	// 게시판 글 쓰기
	@RequestMapping(value = "/write")
	public String write(Board1 board1) {
		boardService.save(board1);
		return "redirect:/board/list";
	}

	// 게시판 글 삭제하기
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value="id", defaultValue="false") int id) {
		boardService.delete(id);
		return "redirect:/board/list";
	}

	// 게시판 글 내용 보기
	@RequestMapping(value = "/read")
	public String detail(@RequestParam(value="id", defaultValue="false") int id, Model model) {
		Board1 board1 = boardService.detail(id);
		System.out.println(board1.toString());
		model.addAttribute("board1", board1);
		return "detail";
	}

	// 게시판 글 수정하기
	@RequestMapping(value = "/update")
	public String update(Board1 board1) {
		System.out.println(board1.toString());
		boardService.update(board1);
		return "redirect:/board/list";
	}


}
