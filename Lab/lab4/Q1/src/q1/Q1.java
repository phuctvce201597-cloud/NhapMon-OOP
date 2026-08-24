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
import java.util.Scanner;

public class Q1 {
    //Change the name of input and output file based on practical paper
    String inputFile = "input.txt";
    String outputFile = "output.txt";

    //--VARIABLES - @STUDENT: DECLARE YOUR VARIABLES HERE:
    ArrayList<String> inputs = new ArrayList<>();
    ProductList list = new ProductList();
    
    String output = "";
       
	



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
        Smartphone phone;
        Laptop laptop;
        Table tablet;
        
        for(int i = 0 ;i < inputs.size(); i++){
            String line = inputs.get(i).trim();
            
            if(line.isEmpty()){
                continue;
            }
            
            String[] tokens = line.split(";");
            String command = tokens[0].trim();
            
            
            if(command.equalsIgnoreCase("Smartphone")){
                int price = Integer.parseInt(tokens[1]);
                String brand = tokens[2];
                String moden = tokens[3];
                int year = Integer.parseInt(tokens[4]);
                int storage = Integer.parseInt(tokens[5]);
                double camera = Double.parseDouble(tokens[6]);
                
                phone = new Smartphone(price, brand, moden, year, storage, camera);
                if(list.addProduct(phone)){
                    output += phone.input() + "\n";
                }
            }else if(command.equalsIgnoreCase("Laptop")){
                int price = Integer.parseInt(tokens[1]);
                String brand = tokens[2];
                String moden = tokens[3];
                int year = Integer.parseInt(tokens[4]);
                int ram = Integer.parseInt(tokens[5]);
                String procces = tokens[6];
                
                laptop = new Laptop(price, brand, moden, year, ram, procces);
                if(list.addProduct(laptop)){
                    output += laptop.input() + "\n";
                }
            }else if(command.equalsIgnoreCase("Tablet")){
                int price = Integer.parseInt(tokens[1]);
                String brand = tokens[2];
                String moden = tokens[3];
                int year = Integer.parseInt(tokens[4]);
                double screensize = Double.parseDouble(tokens[5]);
                boolean hasPen = Boolean.parseBoolean(tokens[6]);
                
                tablet = new Table(price, brand, moden, year, screensize, hasPen);
                if(list.addProduct(tablet)){
                    output += tablet.input() + "\n";
                }
            }else if(command.equalsIgnoreCase("printAll")){
                output += "---Product List---\n";
                output += list.displayAll();
                
            }else if(command.equalsIgnoreCase("find")){
                output += "Find result:\n";
                String model = tokens[1];
                
                Product product = list.findProduct(model);
                if(product == null){
                    output += "Not found!\n";
                }else{
                    output += product.print() + "\n";
                }
                
                
            }else if(command.equalsIgnoreCase("search")){
                output += "Search results:\n";
                String brand = tokens[1];
                
                output += list.searchProduct(brand);
                
            }else if(command.equalsIgnoreCase("updatePrice")){
                output += "Update:\n";
                
                String moden = tokens[1];
                int newPrice = Integer.parseInt(tokens[2]);
                Product product = list.updatePrice(moden, newPrice);
                if(product == null){
                    output += "Not found!\n";
                }else{
                    output += product.print() + "\n";
                }
                
                
                
            }else if(command.equalsIgnoreCase("count")){
                String brand = tokens[1];
                int count = list.conntVyBrand(brand);
                output += "Count: " + count + "\n";
                
            }else if(command.equalsIgnoreCase("sortPrice")){
                output += "Sorted by price:\n";
                
                list.sortByPrice();
                output += list.displayAll();
                
            }else if(command.equalsIgnoreCase("sortYear")){
                output += "Sorted by year:\n";
                list.sortByYear();
                output += list.displayAll();
                
            }else if(command.equalsIgnoreCase("maxPrice")){
                output += "Most expensive:\n";
                
                Product product = list.findMostExpensive();
                
                if(product == null){
                    output += "Empty!\n";
                }else{
                    output += product.print() + "\n";
                }
                     
                
            }else if(command.equalsIgnoreCase("remove")){
                int index = Integer.parseInt(tokens[1]);
                Product product = list.removeProduct(index);
                output += "Remove:\n";
                if( product == null){
                    output += "Not exist!\n";
                }else{
                    output += product.print() + "\n";
                }
            }
                
                    
                    
            
        }
        


	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART-------------------------- 
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
