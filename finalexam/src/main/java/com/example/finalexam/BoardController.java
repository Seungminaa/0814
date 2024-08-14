package com.example.finalexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/create2")
	public String create2() {
		return "create2";
	}
	
	@PostMapping("/create2")
	public String create2(@ModelAttribute Board board) {
		
		boardService.create(board);
		
		return "index";
	}
}
