package com.mysite.noticeexam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;

	//readlist
	List<Comment> readlist() {
		return commentRepository.findAll();
	}
	
}
