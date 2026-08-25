package product.pricing.store.trung.binh;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

class Product{
    String id;
    String name;
    double basePrice;

    public Product() {
    }

    
    public Product(String id, String name, double basePrice) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }
    
    public void nhap(Scanner sc){
        id = sc.next();
        name = sc.next();
        basePrice = sc.nextDouble();   
    }
    
    public void in(){
        System.out.println(id + " " + name + " " + basePrice);
    }
    
    public double giasauthue(){
        return basePrice;
    }
    
}

class Book extends Product{

    public Book() {
    }

    public Book(String id, String name, double basePrice) {
        super(id, name, basePrice);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public double giasauthue() {
        return basePrice - (basePrice * 0.05);
    }

    @Override
    public void in() {
        System.out.println(id + " " + name + " " + giasauthue());
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
    }
}

class Phone extends Product{

    public Phone() {
    }

    public Phone(String id, String name, double basePrice) {
        super(id, name, basePrice);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public double giasauthue() {
        return basePrice - (basePrice * 0.1);
    }

    @Override
    public void in() {
        System.out.println(id + " " + name + " " + giasauthue());
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
    }
}


class Cloth extends Product{

    public Cloth() {
    }

    public Cloth (String id, String name, double basePrice) {
        super(id, name, basePrice);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public double giasauthue() {
        return basePrice - (basePrice * 0.2);
    }

    @Override
    public void in() {
        System.out.println(id + " " + name + " " + giasauthue());
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
    }
}



public class ProductPricingStoreTrungBinh {
    
    static ArrayList<Product> list = new ArrayList<> ();

    static void indanhsach(){
        for(Product s : list){
            s.in();
        }
    }
    
    static void sanphamrenhat(){
        Product max = list.get(0);
        
        for(Product s : list){
            if(max.giasauthue() > s.giasauthue()){
                max = s;
            }
        }
        System.out.println("Cheapest: " + max.getId() + " " + max.getName() + " " + max.giasauthue());
    }
    
    static void tonggiasanpham(){
        double total = 0;
        for(Product s : list){
            total += s.giasauthue();
        }
        System.out.println("Total: " + total);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            String sanpham = sc.next();
            
            if(sanpham.equals("BOOK")){
                Book book = new Book();
                
                book.nhap(sc);
                list.add(book);
            }else if(sanpham.equals("PHONE")){
                Phone phone = new Phone();
                
                phone.nhap(sc);
                list.add(phone);
            }else if(sanpham.equals("CLOTH")){
                Cloth cloth = new Cloth();
                
                cloth.nhap(sc);
                list.add(cloth);
            }
        }
        indanhsach();
        sanphamrenhat();
        tonggiasanpham();
    }
}