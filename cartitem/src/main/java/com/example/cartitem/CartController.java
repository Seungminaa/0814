package com.example.cartitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/readlist";
	}
	
	@GetMapping("/readlist")
	public String readlist(Model model) {
		model.addAttribute("carts",cartService.readList());
		return "readlist";
	}
	
	@GetMapping("/readdetail/{id}")
	public String readdetail(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("cart",cartService.readDetail(id));
		return "readdetail";
	}
	
}
