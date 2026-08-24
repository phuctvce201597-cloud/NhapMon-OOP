package bai.pkg1.oop.java;

import java.util.Scanner;
import java.util.Arrays;

public class Bai1OopJava {

    static class Student{
        String name;
        int age;
        String mssv;
        public void in(){
            System.out.println("Name : " + name);
            System.out.println("Age : " + age);
            System.out.println("Ma so : " + mssv);
            
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Student student1 = new Student();
        student1.name = "Phuc";
        student1.age = 20;
        student1.mssv = "CE201507";
        student1.in();
        
    }
}