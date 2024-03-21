package vw.manu.web.MVCdemo.repo;

import vw.manu.web.MVCdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpJpaRepo extends JpaRepository<Employee, Integer>{
	
	public Employee findByEmpid(int id);

}
