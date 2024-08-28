package com.mysite.schoolexam;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class StudentForm {
	@NotEmpty(message="이름은 필수항목입니다.")
    private String name;

}
