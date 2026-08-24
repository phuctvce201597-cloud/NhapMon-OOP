package kethua.trung.binhb2;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


class Employee{
    String id;
    String name;
    double baseSalary;

    public Employee() {
    }
    

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
    
    public double income(){
        return baseSalary;
    }
    
    public void nhap(Scanner sc){
        id = sc.next();
        name = sc.next();
        baseSalary = sc.nextDouble();
        
    }
    
    public void in(){
        System.out.println(id + " - " + name + " - " + baseSalary);
    }
}





class Manager extends Employee{
    
    public double bonus;
    
   

    public Manager() {
    }

    public Manager(double bonus) {
        this.bonus = bonus;
    }
    
    public Manager(String id, String name, double baseSalary, double bonus){
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
    
    
    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
        bonus = sc.nextDouble();
    }

    @Override
    public void in() {
       System.out.println(id + " - " + name + " - " + baseSalary + " - " + bonus);
    }

    @Override
    public double income() {
        return baseSalary + bonus;
    }

     
    
    
    
   
    
    
}
public class KethuaTrungBinhb2 {
    
    static ArrayList<Employee> list = new ArrayList<>();
    
    static void indanhsach(){
        for(Employee s : list){
            s.in();
        }
    }
   
    
    
    static void thunhap(){
        for(Employee s : list){
            System.out.println(s.income());
        }
    }
   
    
    
    static void tongluong(){
        double sum = 0;
        for(Employee s : list){
            sum += s.income();
        }
        System.out.println(sum);
    }
   
    
    
    static void nhanvienluongcaonhat(){
        Employee max = list.get(0);
        
        for(Employee s : list){
            if(s.income() > max.income()){
                max = s;
            }
        }
        System.out.println(max.getId() + " - " + max.getName() + " - " + max.income());
    }
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            String lenh = sc.next();
            if(lenh.equals("E")){
                Employee Em = new Employee();
                
                Em.nhap(sc);
                list.add(Em);
                
            }
            else if(lenh.equals("M")){
                Manager Ma = new Manager();
                Ma.nhap(sc);
                list.add(Ma);
            }
        }
        indanhsach();
        thunhap();
        tongluong();
        nhanvienluongcaonhat();
        
    }
}