/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap.kethua;

/**
 *
 * @author Admin
 */
public class SalaryEmployee extends Employee{
    
    private double salary;

    public SalaryEmployee(String name, double salary) {
        
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SalaryEmployee() {
        
    }
    
    
    
    
}
