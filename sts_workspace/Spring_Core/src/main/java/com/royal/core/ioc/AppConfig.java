package com.royal.core.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Light light() {
		return new Light();
	}
	
	@Bean
	public Switch switchBean() {
		return new Switch(light());
	}
	
	@Bean
	public Employee employeeBean() {
		return new Employee(101, "Meet", 340000);
	}
}
