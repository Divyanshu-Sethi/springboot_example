package vw.manu.web.MVCdemo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vw.manu.web.MVCdemo.dao.EmpDao;
import vw.manu.web.MVCdemo.exception.EmployeeNotFoundException;
import vw.manu.web.MVCdemo.model.Employee;

@RequestMapping("/emprest")
@RestController
public class EmpRestController {
	
	@Autowired
	EmpDao ed;
	
	
	@GetMapping("/emp/{eId}")
	public Employee getEmpByid(@PathVariable int eId) {
		return this.ed.getEmpById(eId);
	}
	
	@GetMapping("/emps")
	public List<Employee> getAllEmp(){
		return this.ed.getAllEmp();
	}
	
	@PostMapping("/addemp")
	public boolean addEmp(@RequestBody Employee employee) {
		return this.ed.addEmp(employee);
	}

}
