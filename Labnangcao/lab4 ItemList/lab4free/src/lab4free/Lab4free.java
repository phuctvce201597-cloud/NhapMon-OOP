/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4free;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab4free {
    //Change the name of input and output file based on practical paper
    String inputFile = "input.txt";
    String outputFile = "output.txt";

    //--VARIABLES - @STUDENT: DECLARE YOUR VARIABLES HERE:
    String output = "";
    
    ArrayList<String> inputs = new ArrayList<>();
    ItemList list = new ItemList();
	



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
        Vase vase;
        Statue sta;
        
        for(int i = 0; i < inputs.size(); i++){
            String line = inputs.get(i).trim();
            
            if(line.isEmpty()){
                continue;
            }
            
            String[] tokens = line.split(";");
            String command = tokens[0].trim();
            
            if(command.equalsIgnoreCase("Vase")){
                int value = Integer.parseInt(tokens[1]);
                String creator = tokens[2];
                int height = Integer.parseInt(tokens[3]);
                String materical = tokens[4];
                
                vase = new Vase(value, creator, height, materical);
                
               if(list.addItem(vase)){
                   output += vase.input() + "\n";
               }
            }else if(command.equalsIgnoreCase("Statue")){
                int value = Integer.parseInt(tokens[1]);
                String creator = tokens[2];
                int weight = Integer.parseInt(tokens[3]);
                String colour = tokens[4];
                
                sta = new Statue(value, creator, weight, colour);
                
                  if(list.addItem(sta)){
                   output += sta.input() + "\n";
                  } 
            }else if(command.equalsIgnoreCase("printAll")){
                output += "---Item List---\n";
                output += list.displayAll() + "\n";
            }else if(command.equalsIgnoreCase("find")){
                String creator = tokens[1];
                
                output += "Search result:\n";
                
                Item item = list.findItem(creator);
                
                if(item == null){
                    output += "Not exist!\n";
                }else{
                    output += item.print() + "\n";
                }
            }else if(command.equalsIgnoreCase("sort")){
                if(list.isEmpty()){
                    output += "Empty\n";
                }else{
                    output += "Sorted list:\n";
                   list.sortItem();
                   output += list.displayAll() + "\n";
                }
            }else if(command.equalsIgnoreCase("remove")){
                int index = Integer.parseInt(tokens[1]);
                output += "Remove:\n";
                list.removeItem(index);
                output += list.displayAll() + "\n";
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
        Lab4free q = new Lab4free();
        q.setFile(args);
        q.read();
        q.solve();
        q.printResult();
    }
	//--END FIXED PART----------------------------    
}
