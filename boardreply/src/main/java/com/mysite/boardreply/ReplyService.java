package com.mysite.boardreply;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	public void create(Integer id, Reply reply) {
		Board board = boardService.readdetail(id);
		
		reply.setBoard(board);
		reply.setDate(LocalDateTime.now());
		
		replyRepository.save(reply);
	}
}
