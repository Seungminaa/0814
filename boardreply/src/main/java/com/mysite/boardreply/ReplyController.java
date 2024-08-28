package com.mysite.boardreply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/reply/create/{id}")
	public String create(@PathVariable("id") Integer id, @ModelAttribute Reply reply) {
		replyService.create(id,reply);
		
		return "redirect:/readdetail/"+id;
	}
}
