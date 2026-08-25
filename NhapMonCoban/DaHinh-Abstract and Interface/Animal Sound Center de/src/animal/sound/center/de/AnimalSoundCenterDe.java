package animal.sound.center.de;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


class Animal {
String id;
String name;

    public Animal() {
    }

    public Animal(String id, String name) {
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
    System.out.println(id);
    }
    
    public String sound(){
        return "Never";
    }
}


class Dog extends Animal{
    

    public Dog() {
    }

    public Dog(String id, String name) {
        super(id, name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String sound() {
        return "Gau Gau"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void in() {
       System.out.println(id + " " + name + " is a Dog");
       System.out.println(name + ": " + sound());
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
    }
}

class Cat extends Animal{
    
    public Cat(){
        
    }

    public Cat(String id, String name) {
        super(id, name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String sound() {
        return "Meo Meo"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void in() {
       System.out.println(id + " " + name + " is a Cat");
       System.out.println(name + ": " + sound());
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
    }
}


class Bird extends Animal{

    public Bird(){
        
    }

    public Bird(String id, String name) {
        super(id, name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String sound() {
        return "Chip Chip"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void in() {
      System.out.println(id + " " + name + " is a Bird");
        String sound = null;
       System.out.println(name + ": " + sound());
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
    }

    
}
public class AnimalSoundCenterDe {
    
    static ArrayList<Animal>list = new ArrayList<>();
    
    
    static void indanhsach(){
        for(Animal s : list){
        s.in();
    }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            String type = sc.next();
            
            if(type.equals("DOG")){
                Dog dog = new Dog();
                
                dog.nhap(sc);
                list.add(dog);
            }else if(type.equals("CAT")){
                Cat cat = new Cat();
                
                cat.nhap(sc);
                list.add(cat);
            }else if(type.equals("BIRD")){
                Bird bird = new Bird();
                
                bird.nhap(sc);
                list.add(bird);
            }
                
        }
        indanhsach();
        }
    
        
        
    }
