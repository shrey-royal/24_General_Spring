package com.royal.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.royal.core.ioc.AppConfig;
import com.royal.core.ioc.Employee;
import com.royal.core.ioc.Switch;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreApplication.class, args);
		
		/*
		BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
		Switch switch1 = (Switch) factory.getBean("switch");
		switch1.operate();
		
		Employee e = (Employee) factory.getBean("employee");
		System.out.println(e.toString());
		
		e.setId(1089);
		e.setName("Himesh");
		e.setSalary(334400);
		
		System.out.println(e.toString());
		*/
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Switch sw = context.getBean(Switch.class);
		sw.operate();
		
		System.out.println(context.getBean(Employee.class).toString());
	}

}
