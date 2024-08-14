package com.example.finalexam;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Board {
	
	@Id
	public String title;
	public String content;
	public String author;
}
