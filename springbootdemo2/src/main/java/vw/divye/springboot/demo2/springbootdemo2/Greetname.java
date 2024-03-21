package vw.divye.springboot.demo2.springbootdemo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greetname {
	
	@GetMapping("/")
	public String sayHello()
	{
		return "Hello Divyanshu !";
	}

}
