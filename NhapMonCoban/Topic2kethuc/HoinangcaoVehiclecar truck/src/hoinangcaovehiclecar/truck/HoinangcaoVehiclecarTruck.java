package hoinangcaovehiclecar.truck;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

//                          ============ ClASS CHA ===============
class Vehicle{
    String id;
    String name;
    int year;

    public Vehicle() {
    }
    
    public double tax(){
        return 0;
    }

    public Vehicle(String id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
    
    public void nhap(Scanner sc){
        id = sc.next();
        name = sc.next();
        year = sc.nextInt();
        
    }
     public void in(){
        System.out.println(id + " - " + name + " - " + year);
    }
}
    
  //        ===========class car ===============
    
    class Car extends Vehicle{
        int seats;

        public Car() {
        }
        
        public Car(String id, String name, int year, int seats){
          this.id = id;
          this.name = name;
          this.year = year;
          this.seats = seats;
        }

        public int getSeats() {
            return seats;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }

        @Override
        public void in() {
            System.out.println(id + " - " + name + " - " + year + seats);
        }

        @Override
        public void nhap(Scanner sc) {
            super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
            seats = sc.nextInt();
        }

        @Override
        public double tax() {
            return seats * 100; //To change body of generated methods, choose Tools | Templates.
        }
    }
    


//                           ======== class con ==============
    class Motorbike extends Vehicle{
        int enginecc;

        public Motorbike(int enginecc) {
            this.enginecc = enginecc;
        }
        
          
        public Motorbike(String id, String name, int year, int enginecc){
          this.id = id;
          this.name = name;
          this.year = year;
          this.enginecc = enginecc;
        }

    public Motorbike() {
    }

   

        public int getEnginecc() {
            return enginecc;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }

        @Override
        public void in() {
            System.out.println(id + " - " + name + " - " + year + " - " + enginecc);
        }

        @Override
        public void nhap(Scanner sc) {
            super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
            enginecc = sc.nextInt();
        }

        @Override
        public double tax() {
            return enginecc * 2; //To change body of generated methods, choose Tools | Templates.
        }
}
    


//                               ===== class con ============
    class Truck extends Vehicle{
        double loadTons;

        public Truck() {
        }


        public Truck(String id, String name, int year, double loadTons) {
            super(id, name, year);
            this.loadTons = loadTons;
        }

        public double getLoadTons() {
            return loadTons;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }

        @Override
        public void in() {
            System.out.println(id + " - " + name + " - " + year + " - " + loadTons); 
        }

        @Override
        public void nhap(Scanner sc) {
            super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
            loadTons = sc.nextDouble();
        }

        @Override
        public double tax() {
            return loadTons * 500;
        }
         
    }
   


//                                        === HAM =====
public class HoinangcaoVehiclecarTruck {
    
    static ArrayList<Vehicle> list = new ArrayList<>();
    
    
    
                          //  =======In danh sach=======
    
    static void indanhsach(){
        for(Vehicle s : list){
            s.in();
        }
    }
    
    
                        //    ======== Xe Thue cao ============
    
    static void xecothuecaonhat(){
        Vehicle max = list.get(0);
        
        for(Vehicle s : list){
            if(max.tax() < s.tax()){
                max = s;
            }
        }
        max.in();
    }
    
    
                          // =========== TONGTHUE ==============
    
    static void tongthue(){
        
        double tongthue = 0;
        
        for(Vehicle s : list){
            tongthue += s.tax();
        }
        
        System.out.println(tongthue);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            String lenh = sc.next();
            
            
            if(lenh.equals("V")){
                Vehicle ve = new Vehicle();
                
                ve.nhap(sc);
                list.add(ve);
                
                
            }else if(lenh.equals("C")){
                Car car = new Car();
                
                car.nhap(sc);
                list.add(car);
                
                
            }else if(lenh.equals("M")){
                Motorbike mo = new Motorbike();
                
                mo.nhap(sc);
                list.add(mo);
            
            
            }else if(lenh.equals("T")){
                Truck tru = new Truck();
                
                tru.nhap(sc);
                list.add(tru);
           
        }
        
    }
        indanhsach();
        
        xecothuecaonhat();
        
        tongthue();
        
}
    
}