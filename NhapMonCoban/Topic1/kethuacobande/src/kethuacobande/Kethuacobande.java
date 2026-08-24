package kethuacobande;


import java.util.Scanner;
import java.util.Arrays;

class Person{
    String id;
    String name;
    int age;

    public Person() {
    }

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public void nhap(Scanner sc){
        id = sc.next();
        sc.nextLine();
        name = sc.nextLine();
        age = sc.nextInt();
    }
    
    
}

class Student extends Person {
    
    public double gpa;
    
    
    

    public Student() {
    }

    public Student(double gpa) {
        this.gpa = gpa;
    }

    public Student(String id, String name, int age, double gpa) {
        super(id, name, age);
        this.gpa = gpa;
    }
    
    public double getGpa(){
        return gpa;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
        gpa = sc.nextDouble();
    }
    
    public void in(){
        System.out.println(id + " - " + name + " - " + age + " - " + gpa);
    }
    
}

public class Kethuacobande {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Student st = new Student();
        
        st.nhap(sc);
        
        st.in();
        
        if(st.getGpa() >= 3.6){
            System.out.println("Excellent");
        }else if(st.getGpa() >= 3.0){
            System.out.println("Good");
        }else if(st.getGpa() >= 2.0){
            System.out.println("Average");
        }else{
            System.out.println("Poor");
        }
        
    }
}