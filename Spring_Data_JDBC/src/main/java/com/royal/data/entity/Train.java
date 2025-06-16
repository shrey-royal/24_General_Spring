package com.royal.data.entity;

import lombok.Data;

@Data
public class Train {
	private int id;
	private String name;
	private String origin;
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