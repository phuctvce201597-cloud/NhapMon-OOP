/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai.same.student.mana;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Student {

    String name;
    double luong;

    public Student() {
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        luong = sc.nextDouble();
    }

    public void in() {
        Double tongluong = luong * 12;
        double thue;
        if (tongluong > 300000000) {
            thue = tongluong * 0.15;

        } else if (tongluong >= 100000000) {
            thue = tongluong * 0.1;

        } else {
            thue = tongluong * 0.05;
        }
        Double luongthucte = tongluong - thue;

        System.out.println("Hello: " + name);
        System.out.println("Your yearly salary: " + tongluong);
        System.out.println("Your income tax: " + luongthucte);
    }
}
