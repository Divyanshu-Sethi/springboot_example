package vw.divye.springboot.demo2.springbootdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class Springbootdemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootdemo2Application.class, args);
	}

}
