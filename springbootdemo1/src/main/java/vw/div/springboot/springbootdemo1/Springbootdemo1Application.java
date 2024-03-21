package vw.div.springboot.springbootdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "restcontrollers","vw.div.springboot.springbootdemo1"})
public class Springbootdemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootdemo1Application.class, args);
		
	}

}
