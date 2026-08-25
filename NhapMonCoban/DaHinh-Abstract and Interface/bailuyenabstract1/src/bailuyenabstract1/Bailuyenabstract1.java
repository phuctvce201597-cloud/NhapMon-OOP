package bailuyenabstract1;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

abstract class Vahicle{
    String id;
    String name;

    public Vahicle() {
    }
    
    

    public Vahicle(String id, String name) {
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
        System.out.println(id + " - " + name + " - " + fee());
    }
    
    
    abstract double fee();
}


class Bikedelivery extends Vahicle{
   
    double distance;

    public Bikedelivery() {
    }

    public Bikedelivery(double distance) {
        this.distance = distance;
    }

    public Bikedelivery(String id, String name,double distance) {
        super(id, name);
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
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
        distance = sc.nextDouble();
    }
    
    
    @Override
    double fee() {
        return distance * 5000;
    }
    
}



class Truckdelivery extends Vahicle{
    
    double weight;

    public Truckdelivery() {
    }

    public Truckdelivery(double weight) {
        this.weight = weight;
    }

    public Truckdelivery(String id, String name, double weight) {
        super(id, name);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
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
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.\
        weight = sc.nextDouble();
    }
    
    @Override
    double fee(){
        return weight * 12000;
    }
}

public class Bailuyenabstract1 {
    
    static ArrayList<Vahicle > list = new ArrayList<>();
    
    static void indanhsach(){
        System.out.println("=== DELIVERY LIST ===");
        for(Vahicle s : list){
            s.in();
        }
}
    
    static double total(){
        double sum = 0;
        for(Vahicle s : list){
            sum += s.fee();
        }
        System.out.printf("Total fee: %.1f\n", sum);
        return 0;
    }
    
    static void max(){
        Vahicle max = list.get(0);
        
        for(Vahicle s : list){
            if(max.fee() < s.fee()){
                max = s;
            }
            
        }
        System.out.println(max.getId() + " - " + max.getName() + " - " + max.fee());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
          
            String lenh = sc.next();
            
            if(lenh.equals("1")){
                Bikedelivery bike = new Bikedelivery();
                
                bike.nhap(sc);
                list.add(bike);
            }else if(lenh.equals("2")){
                Truckdelivery truck = new Truckdelivery();
                
                truck.nhap(sc);
                list.add(truck);
            }
        }
        indanhsach();
        total();
        max();
        
    }
}