package vw.div.springboot.springbootdemo1.model;



public class Employee {
    private int id;
    private String name;
    private String department;

    private double salary;

    public Employee(int id, String name,  double salary, String department) {
        this.id = id;
        this.name = name;
        this.department = department;

        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }



    public double getSalary() {
        return salary;
    }
}