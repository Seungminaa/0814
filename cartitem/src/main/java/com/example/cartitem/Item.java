package com.example.cartitem;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "Integer")
	private Integer pid;
	
	@Column(columnDefinition = "TEXT")
    private String pname;

    private LocalDateTime date; 
	
	@ManyToOne
	private Cart cart;
}
