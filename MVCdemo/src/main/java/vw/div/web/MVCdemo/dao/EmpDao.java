package vw.div.web.MVCdemo.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vw.div.web.MVCdemo.exception.EmployeeNotFoundException;
import vw.div.web.MVCdemo.model.Employee;
import vw.div.web.MVCdemo.repo.EmpJpaRepo;

@Service
public class EmpDao {
	
	@Autowired
	EmpJpaRepo er;
	
	Logger logger = LoggerFactory.getLogger(EmpDao.class);
	
	public Employee getEmpById(int id) {
		Optional<Employee> e = er.findById(id);
		if(e.isPresent()) {
			return e.get();
		} else {
			throw new EmployeeNotFoundException("emp with this emp id not found");
		}
	}
	
	public List<Employee> getAllEmp(){
		logger.debug("All employees of table are retrieved!");
		return er.findAll();
	}
	
	public boolean addEmp(Employee e) {
		er.save(e);
		logger.debug("Employee with values "+e+"added successfully!");
		return true;
	}
	
	public Employee addEmpp(Employee e) {
		er.save(e);
		logger.debug("Employee with values "+e+"added successfully!");
		return e;
	}

}
