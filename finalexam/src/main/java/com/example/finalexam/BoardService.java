package com.example.finalexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository; //객체(빈)생성
	
	public void create(Board board) { // 컨트롤러에서 데이터를 받아서
		boardRepository.save(board);
	}
}
