package vw.div.springboot.springbootdemo1.dao;


import org.springframework.stereotype.Service;

import vw.div.springboot.springbootdemo1.model.Employee;

import java.util.List;

@Service
public class EmpDao {
    List<Employee> employeeList;

    public EmpDao() {
        employeeList = List.of(
                new Employee(1, "Ram", 1000, "HR"),
                new Employee(2, "Rita", 2000, "Finance"),
                new Employee(3, "Gita", 3000, "Admin")
        );
    }

    public Employee getEmployee(int id) {
        return employeeList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
    public void updateEmployee(int id, Employee employee) {
        for (int i = 0; i < employeeList.size(); i++) {
            Employee e = employeeList.get(i);
            if (e.getId() == id) {
                employeeList.set(i, employee);
                return;
            }
        }
    }
    public void deleteEmployee(int id) {
        employeeList.removeIf(e -> e.getId() == id);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
 