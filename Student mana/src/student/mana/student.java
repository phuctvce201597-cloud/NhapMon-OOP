/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.mana;

import java.time.Year;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class student {
    String name;
    String mssv;
    int bYear;

    public student(String name, String mssv, int bYear) {
        this.name = name;
        this.mssv = mssv;
        this.bYear = bYear;
    }

    public String getName() {
        return name;
    }

    public String getMssv() {
        return mssv;
    }

    public int getbYear() {
        return bYear;
    }

    public student() {
    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        mssv = sc.nextLine();
        bYear = sc.nextInt();
    }
    
    public void tinhvain(){
        int age = Year.now().getValue() - bYear;
        String ani[] = {"Monkey", "Rooster", "Dog", "Pig", "Mouse", "Buffalo", "Tiger", "Cat", "Dragon", "Snake", "House", "Goat"};
        
        System.out.println("Hello: "+ name +"!");
        System.out.println("Your mssv: " + mssv);
        System.out.println("You are "+ age +" years old");
        System.out.println("You are " + ani[bYear % 12] + " age");
    }
}
