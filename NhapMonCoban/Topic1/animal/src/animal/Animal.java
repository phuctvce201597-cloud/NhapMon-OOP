package animal;

import java.util.Scanner;
import java.util.Arrays;

class Student {

    String name;
    int tuoi;
    int animal;


  public void nhap(){
     Scanner sc = new Scanner(System.in);
       name = sc.nextLine();
       tuoi = sc.nextInt();
       animal = sc.nextInt();
}
    
  public void in(){
   System.out.print("Name: "+name);
   System.out.print("Age: "+ tuoi);
   
}
}
public class Animal{
    public static void main(String[] args) {
       
        Student std1 = new Student();
        std1.nhap();
        std1.in();
        
        
    }

}