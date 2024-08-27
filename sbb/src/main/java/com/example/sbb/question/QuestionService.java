package com.example.sbb.question;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	
    public List<Question> getList() {
        return this.questionRepository.findAll();
    }
    
    // 1개의 데이터를 조회할때는 반드시 Optional 로 조회한다. 
 	// 그 이유는 데이터가 없을 경우 시스템이 다운된다. 그것을 방지하기 위해 Optional 로 조회하면 데이터가 없어도 일단 다운이 되지 않는다. 
    // crud 에서 readdetail 과 update 두 곳에서 반드시 optional 을 사용하자.
    public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if (question.isPresent()) {
			return question.get();
		}else {
			throw new DataNotFoundException("question not found");
		}
//		Optional<Question> question = this.questionRepository.findById(id);
//		return question.get();
    }
}
