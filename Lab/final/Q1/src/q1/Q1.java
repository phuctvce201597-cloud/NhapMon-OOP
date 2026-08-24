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
    ArrayList<Device> list = new ArrayList<>();

    //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
    //--START FIXED PART--------------------------    
    String fi, fo;

    /**
     * Set input and output file for automatic rating
     *
     * @param args path of input file and path of output file
     */
    public void setFile(String[] args) {
        fi = args.length >= 2 ? args[0] : inputFile;
        fo = args.length >= 2 ? args[1] : outputFile;
    }

    /**
     * Reads data from input file
     */
    public void read() {
        try (Scanner sc = new Scanner(new File(fi))) {
            //--END FIXED PART----------------------------

            //INPUT - @STUDENT: ADD YOUR CODE FOR INPUT HERE:
            int n = Integer.parseInt(sc.nextLine());

            while (sc.hasNextLine()) {
                inputs.add(sc.nextLine());
            }

            //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
            //--START FIXED PART--------------------------    
            sc.close();
        } catch (FileNotFoundException ex) {
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
    public void solve() {
        //--END FIXED PART----------------------------

        //ALGORITHM - @STUDENT: ADD YOUR CODE HERE:
        SmartPhone phone;
        Tablet tab;

        for (int i = 0; i < inputs.size(); i++) {
            String line = inputs.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] tokens = line.split(",");
            String command = tokens[0].trim();
            if (command.equalsIgnoreCase("addPhone")) {
                String id = tokens[1];
                String name = tokens[2];
                String brand = tokens[3];
                double price = Double.parseDouble(tokens[4]);
                int storge = Integer.parseInt(tokens[5]);
                double camera = Double.parseDouble(tokens[6]);
                boolean isOn = Boolean.parseBoolean(tokens[7]);

                boolean found = false;

                for (Device x : list) {
                    if (x.getDeviceId().equalsIgnoreCase(id)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    output += "Duplicate ID\n";
                } else {
                    phone = new SmartPhone(
                            id, name, brand, price,
                            storge, camera, isOn
                    );

                    list.add(phone);
                    output += phone.addData() + "\n";
                }
            } else if (command.equalsIgnoreCase("addTablet")) {
                String id = tokens[1];
                String name = tokens[2];
                String brand = tokens[3];
                double price = Double.parseDouble(tokens[4]);
                double creenSize = Double.parseDouble(tokens[5]);
                boolean hasStylus = Boolean.parseBoolean(tokens[6]);
                boolean isOn = Boolean.parseBoolean(tokens[7]);

                boolean found = false;

                for (Device x : list) {
                    if (x.getDeviceId().equalsIgnoreCase(id)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    output += "Duplicate ID\n";
                } else {
                    tab = new Tablet(
                            id, name, brand, price,
                            creenSize, hasStylus, isOn
                    );

                    list.add(tab);
                    output += tab.addData() + "\n";
                }
            } else if (command.equalsIgnoreCase("print")) {
                output += "---Device List---\n";

                if (list.isEmpty()) {
                    output += "Empty\n";
                } else {
                    for (Device x : list) {
                        output += x.getDeviceInfo() + "\n";
                    }
                }
            } else if (command.equalsIgnoreCase("search")) {
                output += "---Search Result---\n";
                String id = tokens[1];
                boolean found = false;

                for (Device x : list) {
                    if (x.getDeviceId().equalsIgnoreCase(id)) {
                        output += x.getDeviceInfo() + "\n";
                        found = true;
                    }
                }
                if (!found) {
                    output += "Not found\n";
                }

            } else if (command.equalsIgnoreCase("find")) {
                output += "---Find Result---\n";
                String keyword = tokens[1].toLowerCase();

                boolean found = false;

                for (Device x : list) {
                    if (x.getBrand().toLowerCase().contains(keyword)
                            || x.getModeName().toLowerCase().contains(keyword)) {

                        output += x.getDeviceInfo() + "\n";
                        found = true;
                    }
                }
                if (!found) {
                    output += "Not found\n";
                }

            } else if (command.equalsIgnoreCase("updatePrice")) {
                boolean found = false;
                String id = tokens[1];
                double newPrice = Double.parseDouble(tokens[2]);

                for (Device x : list) {
                    if (x.getDeviceId().equalsIgnoreCase(id)) {
                        x.setPrice(newPrice);
                        output += "Updated: " + x.getDeviceId() + "\n";
                        found = true;
                    }
                }
                if (!found) {
                    output += "Not found\n";
                }

            } else if (command.equalsIgnoreCase("check")) {
                boolean found = false;
                String id = tokens[1];

                for (Device x : list) {
                    if (x.getDeviceId().equalsIgnoreCase(id)) {

                        output += "Device is " + x.checkStatus() + "\n";
                        found = true;
                    }
                }
                if (!found) {
                    output += "Not found\n";
                }

            } else if (command.equalsIgnoreCase("remove")) {
                boolean found = false;
                String id = tokens[1];

                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getDeviceId().equalsIgnoreCase(id)) {
                        Device x = list.remove(j);
                        output += "Removed: " + x.getDeviceId() + "\n";
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    output += "Not found\n";
                }

            } else if (command.equalsIgnoreCase("sort")) {
                output += "---Sort By Price---\n";
                if (list.isEmpty()) {
                    output += "Empty\n";
                } else {
                    list.sort(
                            Comparator.comparingDouble(Device::getPrice)
                                    .reversed()
                                    .thenComparing(
                                            Device::getModeName,
                                            String.CASE_INSENSITIVE_ORDER
                                    )
                    );
                    for (Device x : list) {
                        output += x.getDeviceInfo() + "\n";
                    }
                }

            } else if (command.equalsIgnoreCase("count")) {
                String type = tokens[1].toUpperCase();
                int count = 0;

                for (Device x : list) {
                    if (type.equals("ALL")) {
                        count++;

                    } else if (type.equals("PHONE")
                            && x instanceof SmartPhone) {
                        count++;

                    } else if (type.equals("TABLET")
                            && x instanceof Tablet) {
                        count++;

                    } else if (type.equals("ON")
                            && x.checkStatus().equalsIgnoreCase("On")) {
                        count++;

                    } else if (type.equals("OFF")
                            && x.checkStatus().equalsIgnoreCase("Off")) {
                        count++;
                    }
                }

                output += "Number of " + type
                        + " devices: " + count + "\n";
            } else if (command.equalsIgnoreCase("clear")) {
                list.clear();
                output += "Removed all devices\n";

            } else if (command.equalsIgnoreCase("updateStatus")) {
                String id = tokens[1];
                boolean newStatus = Boolean.parseBoolean(tokens[2]);
                boolean found = false;

                for (Device x : list) {
                    if (x.getDeviceId().equalsIgnoreCase(id)) {

                        if (x instanceof SmartPhone) {
                            SmartPhone p = (SmartPhone) x;
                            p.setIsOn(newStatus);
                        } else if (x instanceof Tablet) {
                            Tablet t = (Tablet) x;
                            t.setIsOn(newStatus);
                        }

                        output += "Updated: " + x.getDeviceId() + "\n";
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    output += "Not found\n";
                }
            }
        }

        //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
        //--START FIXED PART-------------------------- 
    }

    /**
     * Write result into output file
     */
    public void printResult() {
        try {
            FileWriter fw = new FileWriter(fo);
            //--END FIXED PART----------------------------

            //OUTPUT - @STUDENT: ADD YOUR CODE FOR OUTPUT HERE:
            fw.write(output);

            //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
            //--START FIXED PART-------------------------- 
            fw.flush();
            fw.close();
        } catch (IOException ex) {
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
