package studentlistbasicnangcao;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

class sanpham{
    
   String id;
   String name;
   double price;

    public sanpham(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public sanpham() {
    }
   
   

   public void nhap(Scanner sc){
       id = sc.next();
       name = sc.next();
       price = sc.nextDouble();
   }
   
   public void in(){
       System.out.println(id + " | " + name + " | " + price);
   }
}

public class Studentlistbasicnangcao {
    
    static ArrayList<sanpham> list = new ArrayList<>();
    static ArrayList<sanpham> newlist  = new ArrayList<>();
    
    
    static void indanhsach(){
        for(sanpham s : list){
            s.in();
        }
    }
    
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     
        int n = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < n; i++){
            sanpham sp = new sanpham();
            
            sp.nhap(sc);
            list.add(sp);
           
        }
        
        String sanphamtim = sc.next();
        String sanphamxoa = sc.next();
        
        System.out.println("=== PRODUCT LIST ===");
        
        indanhsach();
            
        System.out.println("\n=== SEARCH RESULT ===");
        for(sanpham s : list){
            if(s.getId().equals(sanphamtim)){
                s.in();
            }
        }
        
        System.out.println("\n=== AFTER DELETE ===");
        
        for(sanpham x : list){
            if(!x.getId().equals(sanphamxoa)){
               newlist.add(x);
            }
        }
        
        for(sanpham s : newlist){
            s.in();
        }
        
    }
}