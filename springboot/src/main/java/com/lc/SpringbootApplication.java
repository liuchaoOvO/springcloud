package com.lc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.lc.mapper")
public class SpringbootApplication {

	public static void main(String[] args) {
		System.out.print("<!--lc  test upload to  my persional github-->");
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
