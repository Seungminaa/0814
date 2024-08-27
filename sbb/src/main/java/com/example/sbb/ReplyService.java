package com.example.sbb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
	@Autowired
	private ReplyRepository replyRepository;
	
	public void create(Board board,String content) {
		replyRepository.save();
	}
}
