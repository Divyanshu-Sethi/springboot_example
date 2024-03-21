package vw.manu.web.MVCdemo.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.classic.Logger;
import vw.manu.web.MVCdemo.model.*;
import vw.manu.web.MVCdemo.dao.EmpDao;
import vw.manu.web.MVCdemo.exception.EmployeeNotFoundException;

@RequestMapping("empwebcontrol")
@Controller
public class EmpWebController {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(EmpWebController.class);
	
	@Autowired
	EmpDao ed;
	
	
	
	@GetMapping("/emps")
	public String getAllEmp(ModelMap map){
		List<Employee> lst = this.ed.getAllEmp();
		map.addAttribute("emps",lst );
		return "getallemp";
	}
	
	@RequestMapping(value="/emp/{empid}",method=RequestMethod.GET)
	public String getAllEmp(@PathVariable int empid, ModelMap map) {
		try {
			Employee e = this.ed.getEmpById(empid);
			map.addAttribute("empid",empid);
			map.addAttribute("emp",e);
		} catch(EmployeeNotFoundException e) {
			map.addAttribute("empexception",e.getMessage());
		}
		return "dispemp";
	}
	
	
	
	@RequestMapping(value="/emp/sal/{empid}",method=RequestMethod.GET)
	public String fetchAnnualSal(@PathVariable int empid, ModelMap map) {
		try {
			Employee e = this.ed.getEmpById(empid);
			double annsal = e.computeAnnualSalary();
			map.addAttribute("empid",empid);
			map.addAttribute("empannsal",annsal);
		} catch(EmployeeNotFoundException e) {
			map.addAttribute("empexception",e.getMessage());
		}
		return "empannsal";
	}
	
	@GetMapping("/")
	public String getEmpForm(Model model) {
		Employee e = new Employee();
		model.addAttribute("employee", e);
		return "empform";
	}
	
	@PostMapping("/empp")
	public String addEmployee(@ModelAttribute("employee") Employee e, ModelMap map) {
		logger.info("postemp: "+e);
		Employee em = this.ed.addEmpp(e);
		map.addAttribute("postedemp", em);
		return "postempdet";
	}
	
	
	
	
	

}
