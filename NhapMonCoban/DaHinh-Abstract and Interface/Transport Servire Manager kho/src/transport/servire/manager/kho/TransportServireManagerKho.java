package transport.servire.manager.kho;


import java.util.ArrayList;
import java.util.Scanner;


class Vehicle{
    String name;
    String id;
    double distance;

    public Vehicle() {
    }

    public Vehicle(String name, String id, double distance) {
        this.name = name;
        this.id = id;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }
    
    public void nhap(Scanner sc){
        name = sc.next();
        id = sc.next();
        distance = sc.nextDouble();
    }
    
    public double chiphi(){
        return distance;
    }
    
    public void in(){
        System.out.println(id + " " + name + " " + chiphi());
    }
    
}





class Taxi extends Vehicle{

    public Taxi() {
    }

    public Taxi(String name, String id, double distance) {
        super(name, id, distance);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public void in() {
        super.in(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double chiphi() {
        return 15000 + distance * 12000;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}





class Bus extends Vehicle{

    public Bus() {
    }

    public Bus(String name, String id, double distance) {
        super(name, id, distance);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public void in() {
        super.in(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double chiphi() {
        return 7000 + distance * 3000;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}





class Bike extends Vehicle{

    public Bike() {
    }

    public Bike(String name, String id, double distance) {
        super(name, id, distance);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public void in() {
        super.in(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double chiphi() {
        return distance * 2000;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
public class TransportServireManagerKho {
    
    
    static ArrayList<Vehicle> list = new ArrayList<>();
    
    //======================
    
    static void indanhsach(){
        for(Vehicle s : list){
            s.in();
        }
    }
    
    
    
    //=======================
    static void seach(String id){
        
        boolean found = false;
        if(list.isEmpty()){
            System.out.println("List is empty");
        }
       
        else{
           for(Vehicle s : list){
               if(s.getId().equals(id)){
                   s.in();
                   found = true;
               }
           }
           if(found == false){
               System.out.println("Not found");
           }
        }
    }
    
    
    //=========================
    static double Total(){
        double sum = 0;
        for(Vehicle s : list){
            sum+= s.getDistance();
        }
        System.out.printf("%.2f\n", sum);
        return 0;
    }
    
    
    //==========================
    static void max(){
        Vehicle max = list.get(0);
        
        for(Vehicle s : list){
            if(s.getDistance() > max.getDistance()){
                max = s;
            }
        }
        System.out.println(max.getId() + " An Taxi " + max.getDistance());
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        
        for(int i = 0; i < n; i++){
            String type = sc.next();
            
            if(type.equals("TAXI")){
                Taxi taxi = new Taxi();
                
                taxi.nhap(sc);
                list.add(taxi);
            }else if(type.equals("BUS")){
                
                Bus bus = new Bus();
                
                bus.nhap(sc);
                list.add(bus);
            }else if(type.equals("BIKE")){
                
                Bike bike = new Bike();
                
                bike.nhap(sc);
                list.add(bike);
            }
        }
        
        
        int q = sc.nextInt();
        
        while(q-- > 0){
            
            String lenh = sc.next();
            
            
            
            if(lenh.equals("PRINT")){
                indanhsach();
                
            }else if(lenh.equals("SEARCH")){
                String id = sc.next();
                seach(id);
                
                
            }else if(lenh.equals("TOTAL")){
                Total();
                
            }else if(lenh.equals("MAX")){
                max();
                
        }
        }
        
        
        
    }
}