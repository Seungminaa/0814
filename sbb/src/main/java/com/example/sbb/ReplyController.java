package com.example.sbb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/reply/create/{id}")
	public String replycreate(@PathVariable("id") Integer id, @RequestParam("content") String content ) {
		
		Board board = boardService.
		return "redirect:/readdetail/"+id;
	}
}
