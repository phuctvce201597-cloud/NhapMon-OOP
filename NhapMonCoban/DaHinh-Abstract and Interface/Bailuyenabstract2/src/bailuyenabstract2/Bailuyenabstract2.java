package bailuyenabstract2;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

abstract class person{
    String id;
    String name;

    public person() {
    }

    
    public person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public void nhap(Scanner sc){
        id = sc.next();
        name = sc.next();
        
    }
    abstract double luong();
    
    public void in(){
        System.out.println(id + " - " + name + luong());
    }
}


class ft extends person{
    
    double salary;

    public ft() {
   
    }
    

    public ft(String id, String name, double salary) {
        super(id, name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void in() {
        super.in(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
        salary = sc.nextDouble();
    }
    
    @Override
    double luong(){
        return salary - salary * 0.1;
    }
    
    
}



class pt extends person{
    
    double workinghours;

    public pt() {
    }

    public pt(String id, String name, double workinghouse) {
        super(id, name);
        this.workinghours = workinghouse;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWorkinghours() {
        return workinghours;
    }
    

    @Override
    public void in() {
        super.in(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); 
        workinghours = sc.nextDouble();
    }
    
    double luong(){
        return workinghours * 50;
    }
    
    
}
public class Bailuyenabstract2 {
     
    static ArrayList<person > list = new ArrayList<>();
    
    static void indanhsach(){
        System.out.println("=== EMPLOYEE LIST ===");
        for(person s : list){
            s.in();
        }
}
    
    static double total(){
        double sum = 0;
        for(person s : list){
            sum += s.luong();
        }
        System.out.printf("\nTotal salary: %.1f\n", sum);
        return 0;
    }
    
    static void max(){
        person max = list.get(0);
        
        for(person s : list){
            if(max.luong() > s.luong()){
                max = s;
            }
            
        }
        System.out.println("\nLowest salary employee:");
        System.out.println(max.getId() + " - " + max.getName() + " - " + max.luong());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
          
            String lenh = sc.next();
            
            if(lenh.equals("1")){
                ft ft = new ft();
                
                ft.nhap(sc);
                list.add(ft);
            }else if(lenh.equals("2")){
                pt truck = new pt();
                
                truck.nhap(sc);
                list.add(truck);
            }
        }
        indanhsach();
        total();
        max();
        
    }
}