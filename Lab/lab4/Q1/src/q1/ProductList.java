/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Admin
 */
abstract class Product{
    protected int price;
    protected String brand;
    protected String model;
    protected int releaseYear;

    public Product() {
    }

    public Product(int price, String brand, String model, int releaseYear) {
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.releaseYear = releaseYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    
    abstract public String input();
    abstract public String print();
    
}


class Smartphone extends Product{
    private int storage;
    private double camera;

    public Smartphone() {
    }

    public Smartphone(int price, String brand, String model, int releaseYear, int storage, double camera) {
        super(price, brand, model, releaseYear);
        this.storage = storage;
        this.camera = camera;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getCamera() {
        return camera;
    }

    public void setCamera(double camera) {
        this.camera = camera;
    }

    @Override
    public String input() {
        return String.format("Add smartphone: {price=%d, brand=%s, model=%s, releaseYear=%d, storage=%d, camera=%.1f}",
               this.price, this.brand, this.model, this.releaseYear, this.storage, this.camera);
    }

    @Override
    public String print() {
         return String.format("Smartphone: {price=%d, brand=%s, model=%s, releaseYear=%d, storage=%d, camera=%.1f}",
                this.price, this.brand, this.model, this.releaseYear, this.storage, this.camera);
    }
    
    
}

class Laptop extends Product{
    private int ram;
    private String processor;

    public Laptop() {
    }

    public Laptop(int price, String brand, String model, int releaseYear, int ram, String processor) {
        super(price, brand, model, releaseYear);
        this.ram = ram;
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public String input() {
        return String.format("Add laptop: {price=%d, brand=%s, model=%s, releaseYear=%d, ram=%d, processor=%s}", 
                this.price, this.brand, this.model, this.releaseYear, this.ram, this.processor);
    }

    @Override
    public String print() {
         return String.format("Laptop: {price=%d, brand=%s, model=%s, releaseYear=%d, ram=%d, processor=%s}", 
                this.price, this.brand, this.model, this.releaseYear, this.ram, this.processor);
    }
    
    
}

class Table extends Product{
    private double screeSize;
    private boolean hasPen;

    public Table() {
    }

    public Table(int price, String brand, String model, int releaseYear, double screeSize, boolean hasPen) {
        super(price, brand, model, releaseYear);
        this.screeSize = screeSize;
        this.hasPen = hasPen;
    }

    public double getScreeSize() {
        return screeSize;
    }

    public void setScreeSize(double screeSize) {
        this.screeSize = screeSize;
    }

    public boolean isHasPen() {
        return hasPen;
    }

    public void setHasPen(boolean hasPen) {
        this.hasPen = hasPen;
    }

    @Override
    public String input() {
       return String.format("Add tablet: {price=%d, brand=%s, model=%s, releaseYear=%d, screenSize=%.1f, hasPen=%b}",
               this.price, this.brand, this.model, this.releaseYear, this.screeSize, this.hasPen);
    }

    @Override
    public String print() {
         return String.format("Tablet: {price=%d, brand=%s, model=%s, releaseYear=%d, screenSize=%.1f, hasPen=%b}",
               this.price, this.brand, this.model, this.releaseYear, this.screeSize, this.hasPen);
    }
    
    
}
public class ProductList {
    private ArrayList<Product> list = new ArrayList<>();
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public boolean addProduct(Product product){
        if(product == null){
            return false;
        }else{
            list.add(product);
            return true;
        }
    }
    
    public String displayAll(){
        if(list.isEmpty()){
            return "Empty!\n";
        }
        String result = "" ;
       
            for(Product x : list){
                result += x.print() + "\n";
            }
        
    return result;
   }
    public Product findProduct(String model){
        
        for(Product x : list){
            if(x.model.equalsIgnoreCase(model)){
                return x; 
                
            }
        }
        return null;
        
    }
   public String searchProduct(String keyword) {
    String result = "";

    for (Product x : list) {
        if (x.getBrand().toLowerCase().contains(keyword.toLowerCase())
                || x.getModel().toLowerCase().contains(keyword.toLowerCase())) {

            result += x.print() + "\n";
        }
    }

    if (result.isEmpty()) {
        return "Not found!\n";
    }

    return result;
}
    public Product removeProduct(int index){
        if(index < 0 || index >= list.size()){
            return null;
        }else{
            return list.remove(index);
        }
    }
    
   public void sortByPrice() {
    list.sort(
            Comparator.comparingInt(Product::getPrice)
                    .thenComparing(Product::getModel)
    );
    }
   public void sortByYear() {
    list.sort(
            Comparator.comparingInt(Product::getReleaseYear)
                    .reversed()
                    .thenComparingInt(Product::getPrice)
    );
    }
    public Product updatePrice(String moden, int newPrice){
       
        for(Product x : list){
            if(x.model.equalsIgnoreCase(moden)){
                x.setPrice(newPrice);
                return x;
                
                
            }
        }
        return null;
    }
    
    public int conntVyBrand(String brand){
        int count = 0;
        
        for(Product x : list){
            if(x.getBrand().equalsIgnoreCase(brand)){
                count++;
            }
        }
        return count;
    }
    
    public Product findMostExpensive(){
        Product max = null;
        
        for(Product x : list){
            if(max == null 
                    || x.getPrice() > max.getPrice() 
                    || (x.getPrice() == max.getPrice() 
                    && x.getReleaseYear() > max.getReleaseYear())){
                
                max = x;
            }
        }
        return max;
    }
}
