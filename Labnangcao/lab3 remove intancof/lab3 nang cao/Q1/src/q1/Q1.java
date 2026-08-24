/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Q1 {
    //Change the name of input and output file based on practical paper
    String inputFile = "input.txt";
    String outputFile = "output.txt";

    //--VARIABLES - @STUDENT: DECLARE YOUR VARIABLES HERE:
    String output = "";
    ArrayList<String> inputs = new ArrayList<>();
    ArrayList<ProductCategory>  listcate = new ArrayList<>();
    ArrayList<Product> list = new ArrayList<>();
	



	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
    String fi, fo;
    
    /**
     * Set input and output file for automatic rating
     * @param args path of input file and path of output file
     */
    public void setFile (String[] args){
        fi = args.length>=2? args[0]: inputFile;
        fo = args.length>=2? args[1]: outputFile;
    }
    
    /**
     * Reads data from input file
     */
    public void read(){
        try (Scanner sc  = new Scanner(new File(fi))){
    //--END FIXED PART----------------------------

            //INPUT - @STUDENT: ADD YOUR CODE FOR INPUT HERE:
            int n = Integer.parseInt(sc.nextLine());
            
            while(sc.hasNextLine()){
                inputs.add(sc.nextLine());
            }



	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
            sc.close();
        }catch(FileNotFoundException ex){
            System.out.println("Input Exception # " + ex);
        }
    }
    //--END FIXED PART----------------------------
    
    //ALGORITHM - @STUDENT: ADD YOUROWN METHODS HERE (IF NEED):
    

    
	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
    /**
     * Main algorithm
     */
    public void solve(){
    //--END FIXED PART----------------------------

        //ALGORITHM - @STUDENT: ADD YOUR CODE HERE:
        ProductCategory cate;
        Smartphone phone;
        Laptop laptop;
        
        
        for(int i = 0 ; i < inputs.size(); i++){
            String line = inputs.get(i).trim();
            if(line.isEmpty()){
                continue;
            }
            
            String[] tokens = line.split(",");
            String command = tokens[0].trim();
            if(command.equalsIgnoreCase("AddCategory")){
                String id = tokens[1];
                String name = tokens[2];
                cate = new ProductCategory(id, name);
                
                listcate.add(cate);
                output += cate.entry() + "\n";
                
                
            }else if(command.equalsIgnoreCase("PrintCategory")){{
                output += "---PrintCategory---\n";
                if(listcate.isEmpty()){
                    output += "Empty\n";
                }else{
                    for(ProductCategory x : listcate){
                        output += x.print() + "\n";
                    }
                }
            }
                output += "---\n";
            }else if(command.equalsIgnoreCase("AddSmartphone")){
                String id = tokens[1];
                String name = tokens[2];
                String brand = tokens[3];
                double price = Double.parseDouble(tokens[4]);
                String idcate = tokens[5];
                int storage = Integer.parseInt(tokens[6]);
                int camera = Integer.parseInt(tokens[7]);
                
                ProductCategory loai = null;
                
                for(ProductCategory x : listcate){
                    if(x.getId().equalsIgnoreCase(idcate)){
                        loai = x;
                        break;
                    }
                }
                if(loai != null){
                    phone = new Smartphone(id, name, brand, price, loai, storage, camera);
                    list.add(phone);
                    output += phone.entry() + "\n";
                }
                
            }else if(command.equalsIgnoreCase("AddLaptop")){
                String id = tokens[1];
                String name = tokens[2];
                String brand = tokens[3];
                double price = Double.parseDouble(tokens[4]);
                String idcate = tokens[5];
                int ram = Integer.parseInt(tokens[6]);
                String procces = tokens[7];
                
                ProductCategory loai = null;
                
                for(ProductCategory x : listcate){
                    if(x.getId().equalsIgnoreCase(idcate)){
                        loai = x;
                        break;
                    }
                }
                if(loai != null){
                    laptop = new Laptop(id, name, brand, price, loai, ram, procces);
                    list.add(laptop);
                    output += laptop.entry() + "\n";
                }
                
                
            }else if(command.equalsIgnoreCase("PrintProduct")){
                output += "---PrintProduct---\n";
                if(list.isEmpty()){
                    output += "Empty\n";
                }else {
                    for(Product x : list){
                        output += x.print() + "\n";
                    }
                }
                output += "---\n";
            }else if(command.equalsIgnoreCase("PrintSmartphone")){
                output += "---PrintSmartphone---\n";
                boolean found = false;
                
                for(Product x : list){
                    if(x instanceof Smartphone){
                        output += x.print() + "\n";
                        found = true;
                    }
                    
                }
                if(!found){
                    output += "Empty\n";
                }
                output += "---\n";
            }else if(command.equalsIgnoreCase("PrintLaptop")){
                output += "---PrintLaptop---\n";
                boolean found = false;
                
                for(Product x : list){
                    if(x instanceof Laptop){
                        output += x.print() + "\n";
                        found = true;
                    }
                    
                }
                if(!found){
                    output += "Empty\n";
                }
                output += "---\n";
            }else if(command.equalsIgnoreCase("SearchProduct")){
                output += "---Search Result---\n";
                boolean found = false;
                String id = tokens[1];
                for(Product x : list){
                    if(x.getId().equalsIgnoreCase(id)){
                        output += x.print() + "\n";
                         found = true;
                         break;
                    }
                   
                }
                if(!found){
                    output += "Not found\n";
                }
            
                output += "---\n";
            }else if(command.equalsIgnoreCase("FindBrand")){
                output += "---Find Brand---\n";
                 boolean found = false;
                String id = tokens[1];
                for(Product x : list){
                    if(x.getBrand().equalsIgnoreCase(id)){
                        output += x.print() + "\n"; 
                        found = true;
                    }
                   
                }
                if(!found){
                    output += "Not found\n";
                }
                output += "---\n";
            }else if(command.equalsIgnoreCase("RemoveProduct")){
                String id = tokens[1];
                boolean found = false;
                for(int j = 0 ; j < list.size(); j++){
                    if(list.get(j).getId().equalsIgnoreCase(id)){
                        Product x = list.remove(j);
                         output += "(" + x.getId() + ") is removed\n";
                        found = true;
                        break;
                    }
                }
               if(!found){
                   output += "Not found\n";
               }
            
                
            }else if(command.equalsIgnoreCase("SortProduct")){
                output += "---Sort By Price---\n";
                if(list.isEmpty()){
                    output += "Empty\n";
                }else{
                    list.sort(Comparator.comparing(Product::getPrice));
                    for(Product x : list){
                        output += x.print() + "\n";
                    }
                }
                output += "---\n";
            }else if(command.equalsIgnoreCase("UpdatePrice")){
                String id = tokens[1];
                double newPrice = Double.parseDouble(tokens[2]);
                
                boolean found = false;
                for(Product x : list){
                    if(x.getId().equalsIgnoreCase(id)){
                        x.setPrice(newPrice);
                        found = true;
                        output +=  "(" + x.getId() + ") price is updated\n";
                    }
                }
                if(!found){
                    output += "Not found\n";
                }
            }
        


	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART-------------------------- 
    }
    }
    /**
     * Write result into output file
     */
    public void printResult(){
	    try{
            FileWriter fw = new FileWriter(fo);
	//--END FIXED PART----------------------------
                
        	//OUTPUT - @STUDENT: ADD YOUR CODE FOR OUTPUT HERE:
            fw.write(output);



	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART-------------------------- 
            fw.flush();
            fw.close();
        }catch (IOException ex){
            System.out.println("Output Exception # " + ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Q1 q = new Q1();
        q.setFile(args);
        q.read();
        q.solve();
        q.printResult();
    }
	//--END FIXED PART----------------------------    
}
