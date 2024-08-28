package com.mysite.schoolexam;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/student")
@RequiredArgsConstructor
@Controller
public class StudentController {
	private final StudentService studentService;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Student> studentList = this.studentService.getList();
		
		model.addAttribute("studentList", studentList);		
		return "readlist";
	}
	
	@GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Student student = this.studentService.getStudent(id);
        model.addAttribute("student", student);
        return "readdetail";
    }
	
	@GetMapping("/create")
    public String studentCreate(StudentForm studentForm) {
        return "st_create";
    }
	
	@PostMapping("/create")
    public String studentCreate(@Valid StudentForm studentForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "st_create";
        }
		// TODO 질문을 저장한다.
		this.studentService.create(studentForm.getName());
        return "redirect:/student/list"; // 질문 저장후 질문목록으로 이동
    }
	
}
