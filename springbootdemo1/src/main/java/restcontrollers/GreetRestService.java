package restcontrollers;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vw.div.springboot.springbootdemo1.dao.EmpDao;
import vw.div.springboot.springbootdemo1.model.Employee;




@RestController
public class GreetRestService {
	

@Autowired
EmpDao eaod;

	 private static  org.slf4j.Logger LOGGER = LoggerFactory.getLogger(GreetRestService.class);
	@GetMapping("hello")
	public String sayHello()
	{
		LOGGER.debug("sayHello() called");
		return "hey EveryOne !";
		
	}
	

	@GetMapping("emp/{empId}")
	public Employee getEmployee(@PathVariable int empId){
	    Employee emp = eaod.getEmployee(empId);
	    LOGGER.debug("emp found:" + emp);
	    return emp;
	}
}
