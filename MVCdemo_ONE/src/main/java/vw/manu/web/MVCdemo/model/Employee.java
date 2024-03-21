package vw.manu.web.MVCdemo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employee {
	
	@Id
	private int empid;
	
	private String empName;
	private double empSalary;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joindate;
	
	
	public Employee() {
		super();
	}
	

	public Employee(int empid, String empName, double empSalary, LocalDate joindate) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.empSalary = empSalary;
		this.joindate = joindate;
	}

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	
	public LocalDate getJoindate() {
		return joindate;
	}


	public void setJoindate(LocalDate joindate) {
		this.joindate = joindate;
	}


	public double computeAnnualSalary() {
		return this.empSalary*12;
	}
	
	public double computeAnnualSalary(double bonus) {
		return this.empSalary*12 + bonus;
	}


	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", empSalary=" + empSalary + ", localdate="
				+ joindate + "]";
	}
	
	

}
