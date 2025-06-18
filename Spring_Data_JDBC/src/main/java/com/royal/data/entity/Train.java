package com.royal.data.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Train {
	
	@PositiveOrZero(message = "ID must be zero or positive")
	private int id;
	
	@NotBlank(message = "Train name must not be blank")
	@Size(max = 255, message = "Train name must be at most 255 characters")
	private String name;
	
	@NotBlank(message = "Origin must not be blank")
	@Size(max = 255, message = "Origin must be at most 255 characters")
	private String origin;
	
	@NotBlank(message = "Destination must not be blank")
	@Size(max = 255, message = "Destination must be at most 255 characters")
	private String destination;
}

/*
CREATE TABLE trains(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255),
	origin VARCHAR(255),
	destination VARCHAR(255)
);
*/