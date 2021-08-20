package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {"com.*,com.example.demo.*"}) //指定扫描包路径
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

}
