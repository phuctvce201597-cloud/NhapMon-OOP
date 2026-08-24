/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

/**
 *
 * @author Admin
 */
interface IProduct{
    public String entry();
    public String print();
}



class ProductCategory implements IProduct{
    private String id;
    private String name;

    public ProductCategory() {
    }

    public ProductCategory(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String entry() {
        return String.format("(%s,%s) is added", this.id, this.name);
    }

    @Override
    public String print() {
        return String.format("(%s,%s)", this.id, this.name);
    }
    
    
}

public abstract class Product implements IProduct {
    private String id;
    private String name;
    private String brand;
    private double price;
    ProductCategory category;

    public Product() {
    }

    public Product(String id, String name, String brand, double price, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    @Override
    public String entry() {
        return String.format("(%s,%s) is added", this.id, this.name);
    }

   @Override
   public abstract String print();
    
    
}

class Smartphone extends Product{
    private int storage;
    private int camera;

    public Smartphone() {
    }

    public Smartphone(String id, String name, String brand, double price, ProductCategory category, int storage, int camera) {
        super(id, name, brand, price, category);
        this.storage = storage;
        this.camera = camera;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    @Override
    public String print() {
       return String.format("(%s,%s,%s,%.1f,%dGB,%dMP): [%s]",
               this.getId(), this.getName(), this.getBrand()
               , this.getPrice(), this.storage, this.camera, this.category.getName());
    }
    
    
}

class Laptop extends Product{
    private int ram;
    private String processor;

    public Laptop() {
    }

    public Laptop(String id, String name, String brand, double price, ProductCategory category, int ram, String processor) {
        super(id, name, brand, price, category);
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
    public String print() {
        return String.format("(%s,%s,%s,%.1f,%dGB,%s): [%s]",
                this.getId(), this.getName(), this.getBrand(),
                this.getPrice(), this.ram, this.processor, this.category.getName());
    }
    
    
}