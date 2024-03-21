package vw.manu.web.MVCdemo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vw.manu.web.MVCdemo.model.Employee;
import vw.manu.web.MVCdemo.repo.EmpJpaRepo;

@SpringBootApplication
public class MvCdemoApplication  { //implements CommandLineRunner{

	@Autowired
	EmpJpaRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(MvCdemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Employee e1 = new Employee(1,"Manu Chahar",40000,LocalDate.now());
//		repo.save(e1);
//		
//		Employee e2 = new Employee(2,"Mansi Agarwal",30000,LocalDate.of(2023, 05, 3));
//		repo.save(e2);
//	}

}
