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
public class WageEmployee extends Employee {
    private double rate;
    private int hours;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public WageEmployee(double rate, int hours) {
        this.rate = rate;
        this.hours = hours;
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
