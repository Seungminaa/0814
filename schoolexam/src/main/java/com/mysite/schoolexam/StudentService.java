package com.mysite.schoolexam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	public List<Student> getList() {
		return this.studentRepository.findAll();
	}
	
	public void create(String name) {
        Student s = new Student();
        s.setName(name);
        s.setDate(LocalDateTime.now());
        this.studentRepository.save(s);
    }
	
	public Student getStudent(Integer id) {
		Optional<Student> student = this.studentRepository.findById(id);
		
		return student.get();
		
	}
}
