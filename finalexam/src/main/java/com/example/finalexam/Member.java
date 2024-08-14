package com.example.finalexam;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Member {
	
	@Id
	public String id;
	public String pw;
	public String name;
}
