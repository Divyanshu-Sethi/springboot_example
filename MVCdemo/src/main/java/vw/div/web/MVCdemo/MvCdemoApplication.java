package vw.div.web.MVCdemo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vw.div.web.MVCdemo.model.Employee;
import vw.div.web.MVCdemo.repo.EmpJpaRepo;

@SpringBootApplication
public class MvCdemoApplication  { //implements CommandLineRunner{

	@Autowired
	EmpJpaRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(MvCdemoApplication.class, args);
	
	
	}


}
