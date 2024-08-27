package com.mysite.noticeexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/readlist";
	}
	
	@GetMapping("/readlist")
	public String readlist(Model model) {
		model.addAttribute("notices", noticeService.readlist());
		return "readlist";
	}
	
	@GetMapping("/readdetail/{id}")
	public String readdetail(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("notice", noticeService.readdetail(id));
		model.addAttribute("notices",commentService.readlist());
		return "readdetail";
	}
	
}
