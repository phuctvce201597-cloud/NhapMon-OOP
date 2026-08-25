package shape.report.manager.tinhdientich;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;






class Shape{
    String id;
    double thongso;

    public Shape() {
    }

    public Shape(String id, double thongso) {
        this.id = id;
        this.thongso = thongso;
       
    }

    public String getId() {
        return id;
    }

    public double getThongso() {
        return thongso;
    }

    
    
    public void nhap(Scanner sc){
        id = sc.next();
        
    }
    
    public void in(){
        System.out.println(id + " ");
    }
    public double dientich(){
    return thongso;
}

   
    
}










class Circle extends Shape{
    double r;

    public Circle() {
    }

    
    public Circle(double r) {
        this.r = r;
    }

    public Circle(String id, double thongso, double r) {
        super(id, thongso);
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public String getId() {
        return id;
    }

    public double getThongso() {
        return thongso;
    }

    @Override
    public double dientich() {
        return r * r * Math.PI;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
        r = sc.nextDouble();
    }

    @Override
    public void in() {
       System.out.println(id + " Circle " + dientich());
    
    }
}






class Rect extends Shape{
    double w;
    double h;

    public Rect() {
    }

    public Rect(double w, double h) {
        this.w = w;
        this.h = h;
    }

    public Rect(String id, double thongso, double w, double h) {
        super(id, thongso);
        this.w = w;
        this.h = h;
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    public String getId() {
        return id;
    }

    public double getThongso() {
        return thongso;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
        w = sc.nextDouble();
        h = sc.nextDouble();
    }
    
    @Override
    public double dientich() {
        return w * h;
    }

    @Override
    public void in() {
       System.out.println(id + " Retangle " + dientich());
    }

}




class Triangle extends Shape{
    double a;
    double b;
    double c;
    public Triangle() {
    }

    public Triangle(double w, double h) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(String id, double thongso, double a, double b, double c) {
        super(id, thongso);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
    
    public double getc(){
        return c;
    }
    
    public String getId() {
        return id;
    }

    public double getThongso() {
        return thongso;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc); //To change body of generated methods, choose Tools | Templates.
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
    }
    
    @Override
    public double dientich() {
        double temp = (a + b + c) / 2;
        
        return Math.sqrt(temp * (temp - a) * (temp - b) * (temp - c));
    }

    @Override
    public void in() {
       System.out.println(id + " Triangle " + dientich());
    }

}





public class ShapeReportManagerTinhdientich {
    
    static ArrayList<Shape> list = new ArrayList<>();
  
  //========================================================  
    static void indanhsach(){
    for(Shape s : list){
        s.in();
    }
}
    
    //======================================================
    static void ablou(double th){
       for(Shape s : list){
           if(s.dientich() >= th){
               s.in();
           }
       }
    }
    
    
    
    // ===================================================
    static void maxarea(){
    Shape max = list.get(0);
    
    for(Shape s : list){
        if(s.dientich() > max.dientich()){
            max = s;
        }
    }
    System.out.println("Max: " + max.getId() + " Circle " + max.dientich());
    
    
    
    
}
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            String type = sc.next();
            
            if(type.equals("CIRCLE")){
                Circle cri = new Circle();
                
                cri.nhap(sc);
                list.add(cri);
            }else if(type.equals("RECT")){
                Rect re = new Rect();
                
                re.nhap(sc);
                list.add(re);
            }else if(type.equals("TRI")){
                Triangle tri = new Triangle();
                
                tri.nhap(sc);
                list.add(tri);
            }
        }
        double th = sc.nextDouble();
        indanhsach();
        System.out.println("Above threshold:");
        ablou(th);
        maxarea();
    }
}