package com.example.cartitem;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
	
	@Autowired
	private CartRepository boardRepository;
	
	//readList
	List<Cart> readList(){
		return boardRepository.findAll();
	}
	
	//readList
	Cart readDetail(Integer id) {
		Optional<Cart> ob = boardRepository.findById(id);
		return ob.get();
	}
}
