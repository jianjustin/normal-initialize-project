package org.normal.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MemberApplication {

	public static void main(String[] args) {
		System.setProperty("DATABASE_URL","jdbc:mysql://35.229.130.215:33060/test??characterEncoding=utf8&useSSL=false");
	    SpringApplication.run(MemberApplication.class, args);
	}
}
