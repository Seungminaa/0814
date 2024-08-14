package com.example.finalexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository; //객체(빈)생성
	
	public void create(Member member) { // 컨트롤러에서 데이터를 받아서
		memberRepository.save(member);
	}
}
