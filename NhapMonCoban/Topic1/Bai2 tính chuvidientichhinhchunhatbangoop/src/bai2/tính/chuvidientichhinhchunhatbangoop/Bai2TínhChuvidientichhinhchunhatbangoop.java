package bai2.tính.chuvidientichhinhchunhatbangoop;


import java.util.Scanner;
import java.util.Arrays;


class hinhchunhat{
    double dai;
    double rong;
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        dai = sc.nextDouble();
        rong = sc.nextDouble();
    }
    
    public void in(){
        System.out.printf("Area: %.2f", dai*rong);
        System.out.printf("\nPerimeter: %.2f", (dai+rong) * 2);
    }
}
public class Bai2TínhChuvidientichhinhchunhatbangoop {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
         hinhchunhat hcn = new hinhchunhat();
         hcn.nhap();
         hcn.in();
        
    }
}