package vw.div.springboot.springbootdemo1.config;
import  java.util.Objects;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import vw.div.springboot.springbootdemo1.model.Employee;
@ConfigurationProperties("employee")
@Profile("dev")

public class Appconfiguration {
private int employee_id;
private String employee_name;
private double salary;
private int dept_no;


public Appconfiguration() {
	
	
}


public Appconfiguration(int employee_id, String employee_name, double salary, int dept_no) {
	super();
	this.employee_id = employee_id;
	this.employee_name = employee_name;
	this.salary = salary;
	this.dept_no = dept_no;
}


public int getEmployee_id() {
	return employee_id;
}


public void setEmployee_id(int employee_id) {
	this.employee_id = employee_id;
}


public String getEmployee_name() {
	return employee_name;
}


public void setEmployee_name(String employee_name) {
	this.employee_name = employee_name;
}


public double getSalary() {
	return salary;
}


public void setSalary(double salary) {
	this.salary = salary;
}


public int getDept_no() {
	return dept_no;
}


public void setDept_no(int dept_no) {
	this.dept_no = dept_no;
}






}

