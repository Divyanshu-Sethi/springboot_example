package vw.div.web.MVCdemo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue	
	private int empid;
	
	@NotNull
	@NotBlank(message="emp name is mandatory")
	@Size(min = 4,message = "Name Should have atleast 2 character")
	private String empName;
    @NotNull(message = "empsalary is mandatory")
	private double empSalary;
	
	@NotNull(message = "emp joining  date is mandatory")
    @Past(message = "Joining date has to be future date")
	//@DateTimeFormat(message = "yyyy-mm-dd")
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
