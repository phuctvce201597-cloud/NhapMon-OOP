package nângcaonhat.menu;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;



class Staff {
    String id;
    String name;

    public Staff() {
    }
    
    public Staff(String id, String name) {
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
    
    public void in(){
        System.out.println(id + " - " + name);
    }
    
    public double income(){
        return 0;
    }
}



class FullTimeStaff extends Staff{
    double salary;
    double allowance;

    public FullTimeStaff() {
    }

    public FullTimeStaff(double salary, double allowance) {
        this.salary = salary;
        this.allowance = allowance;
    }

    public FullTimeStaff(String id, String name, double salary, double allowance) {
        super(id, name);
        this.salary = salary;
        this.allowance = allowance;
    }

    public double getSalary() {
        return salary;
    }

    public double getAllowance() {
        return allowance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public double income() {
        return salary * allowance; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void in() {
        System.out.println(id + " - " + name + " - " + salary + " - " + allowance );
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
        salary = sc.nextDouble();
        allowance = sc.nextDouble();
    }

}

    class PartTimeStaff extends Staff{
        
        int hours;
        double rate;

        public PartTimeStaff() {
        }

        public PartTimeStaff(int hours, double rate) {
            this.hours = hours;
            this.rate = rate;
        }

        public PartTimeStaff(String id, String name, int hours, double rate) {
            super(id, name);
            this.hours = hours;
            this.rate = rate;
        }

        public int getHours() {
            return hours;
        }

        public double getRate() {
            return rate;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public double income() {
            return hours + rate; //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void in() {
           System.out.println(id + " - " + name + " - " + hours + " - " + rate);
        }

        @Override
        public void nhap(Scanner sc) {
            super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
            hours = sc.nextInt();
            rate = sc.nextDouble();
        }
        
        
    } 


public class NângcaonhatMenu {
    
    static ArrayList<Staff> list = new ArrayList<>(); 
   
      
    
    static void Printf(){
        if(list.isEmpty()){
            System.out.println("Khong Co Gi De In");
        }else{
        for(Staff s : list){
            s.in();
        }
        }
    }
    
    static void Search(String find){
         
        boolean found = false;
        for(Staff s : list){
            if(s.getId().equals(find)){
               found = true;
               s.in();
               break;
            }
            }
        if(found == false){
            System.out.println("Not found");
        }
        
    }
    
    static void Delete(String dele){
        boolean xoa = false;
        for(int i =0; i < list.size(); i++){
            
            if(list.get(i).getId().equals(dele)){
                xoa = true;
                list.remove(i);
                System.out.println("Deleted");
                break;
            }
        }
        if(xoa == false){
            System.out.println("Not found");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
           String lenh = sc.next();
           
           if(lenh.equals("ADD")){
               
               
               String kitu = sc.next();
               if(kitu.equals("F")){
                   FullTimeStaff ft = new FullTimeStaff();
                   
                   ft.nhap(sc);
                   list.add(ft);
                   
               }else if(kitu.equals("P")){
                    PartTimeStaff pt = new PartTimeStaff();
                    
                    pt.nhap(sc);
                    list.add(pt);
               }
               
               
               
               
               
           }else if(lenh.equals("PRINT")){
               Printf();
               
               
           }else if(lenh.equals("SEARCH")){
               String find = sc.next();
              Search(find);
              
              
           }else if(lenh.equals("DELETE")){
               String find = sc.next();
               Delete(find);
               
               
           }else if (lenh.equals("PRINT")){
               Printf();
           }
        }
        
        
    }
}

