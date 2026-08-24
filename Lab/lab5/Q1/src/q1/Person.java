/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

/**
 *
 * @author Admin
 */

class Department{
    private String id;
    private String name;

    public Department() {
    }

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String input(){
        return String.format("Add department: %s - %s", this.id, this.name);
    }
    
    public String print(){
        return String.format("Department: %s - %s", this.id, this.name);
    }
}

public abstract class Person {
    protected String id;
    protected String name;
    protected int yob;
    protected Department department;

    public Person() {
    }

    public Person(String id, String name, int yob, Department department) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    abstract public String input();
    abstract public String print();

   
 
}

class Student extends Person{
    private double gpa;

    public Student() {
    }
    

    public Student(String id, String name, int yob, Department department, double gpa) {
        super(id, name, yob, department);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

  
  

    @Override
    public String input() {
       return String.format("Add student: %s - %s", this.id, this.name);
    }

    @Override
    public String print() {
        return String.format("Student: %s - %s - %d - Department(%s - %s) - GPA: %.1f",
                this.id, this.name, this.yob, this.department.getId(), this.department.getName(), this.gpa);
    }
    
    
    
}



class Lecturer extends Person{
    private double salary;

    public Lecturer() {
    }

    public Lecturer(String id, String name, int yob, Department department, double salary) {
        super(id, name, yob, department);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String input() {
        return String.format("Add lecturer: %s - %s", this.id, this.name);
    }

    @Override
    public String print() {
       return String.format("Lecturer: %s - %s - %d - Department(%s - %s) - Salary: %.1f", 
               this.id, this.name, this.yob, this.department.getId(), this.department.getName(), this.salary);
        
    }
    
    
    
}