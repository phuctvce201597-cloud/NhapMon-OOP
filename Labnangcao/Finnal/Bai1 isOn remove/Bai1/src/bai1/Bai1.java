/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

interface ISmartPhone{
    public String getDeviceInfo();
    public String checkStatus();
}

abstract class Device{
    private String deviceid;
    private String modelName;

    public Device() {
    }

    public Device(String deviceid, String modelName) {
        this.deviceid = deviceid;
        this.modelName = modelName;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    
    abstract public String addData();
       
    
}

class SmartPhone extends Device implements ISmartPhone{
    private int storage;
    private boolean isOn;

    public SmartPhone() {
    }

    public SmartPhone(String deviceid, String modelName, int storage, boolean isOn) {
        super(deviceid, modelName);
        this.storage = storage;
        this.isOn = isOn;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public boolean isIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

   

    @Override
    public String getDeviceInfo() {
        return String.format("SmartPhone(%s,%s,%d GB,%s)", this.getDeviceid(), this.getModelName(), this.storage, this.checkStatus());
    }

    @Override
    public String checkStatus() {
       if(isOn == true){
           return "On";
       }else{
           return "Off";
       }
    }

    @Override
    public String addData() {
       return String.format("SmartPhone(%s,%s,%d GB,%s) is added",this.getDeviceid(), this.getModelName(), this.storage, this.checkStatus() );
    }
    
    
    
}

public class Bai1 {
    //Change the name of input and output file based on practical paper
    String inputFile = "input.txt";
    String outputFile = "output.txt";

    //--VARIABLES - @STUDENT: DECLARE YOUR VARIABLES HERE:
	String output = "";
        ArrayList<String> inputs = new ArrayList<>();
        ArrayList<SmartPhone> list = new ArrayList<>();



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
        SmartPhone phone;
        
        for(int i = 0; i < inputs.size(); i++){
            String line = inputs.get(i).trim();
            
            if(line.isEmpty()){
                continue;
            }
            
            String[] tokens = line.split(",");
            String command = tokens[0].trim();
            
            if(command.equalsIgnoreCase("Add")){
                String id = tokens[1];
                String name = tokens[2];
                int storage = Integer.parseInt(tokens[3]);
                boolean isOn = Boolean.parseBoolean(tokens[4]);
                
                phone = new SmartPhone(id, name, storage, isOn);
                
                list.add(phone);
                output += phone.addData() + "\n";
            }else if(command.equalsIgnoreCase("print")){
                output += "---Print---\n";
                if(list.isEmpty()){
                    output += "Empty\n";
                }else{
                    for(SmartPhone x : list){
                        output += x.getDeviceInfo() + "\n";
                    }
                }
            }else if(command.equalsIgnoreCase("search")){
                String id = tokens[1];
                
                output += "---Search Result---\n";
                boolean found = false;
                phone = null;
                for(SmartPhone x : list){
                    if(x.getDeviceid().equalsIgnoreCase(id)){
                        phone = x;
                        output += phone.getDeviceInfo() + "\n";
                        found = true;
                        break;
                    }
                }
               
                if(!found){
                    output += "Not found\n";
                }
            }else if(command.equalsIgnoreCase("check")){
                output += "---Check Result---\n";
                String id = tokens[1];
                 boolean found = false;
                 
                for(SmartPhone x : list){
                     if (x.getDeviceid().equalsIgnoreCase(id)) {
                     output += "Device is " + x.checkStatus() + "\n";
                     found = true;
                     break;
                }
                
                }
                 if(!found){
                    output += "Not found\n";
                }
            }else if(command.equalsIgnoreCase("sort")){
                output += "---Sort---\n";
                 if(list.isEmpty()){
                    output += "Empty\n";
                }else{
                      list.sort(Comparator.comparing(SmartPhone::getStorage).reversed());
                    for(SmartPhone x : list){
                        output += x.getDeviceInfo() + "\n";
                    }
                }
          
            }else if(command.equalsIgnoreCase("clear")){
                list.clear();
                output += "* Remove all SmartPhone\n";
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
        Bai1 q = new Bai1();
        q.setFile(args);
        q.read();
        q.solve();
        q.printResult();
    }
	//--END FIXED PART----------------------------    
}
