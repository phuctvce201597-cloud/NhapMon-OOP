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
import java.util.Locale;
import java.util.Scanner;

public class Q1 {

    //Change the name of input and output file based on practical paper
    String inputFile = "input.txt";
    String outputFile = "output.txt";

    //--VARIABLES - @STUDENT: DECLARE YOUR VARIABLES HERE:
    String output = "";
    ArrayList<String> inputs = new ArrayList<>();
    ArrayList<Department> listde = new ArrayList<>();
    ArrayList<Person> list = new ArrayList<>();

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
        Department de;
        Student stu;
        Lecturer lec;

        for (int i = 0; i < inputs.size(); i++) {
            String line = inputs.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] tokens = line.split(",");
            String command = tokens[0].trim();
            if (command.equalsIgnoreCase("AddDepartment")) {
                String id = tokens[1];
                String name = tokens[2];

                boolean found = false;

                for (Department x : listde) {
                    if (x.getId().equalsIgnoreCase(id)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    output += "Department already exists: " + id + "\n";
                } else {
                    de = new Department(id, name);
                    listde.add(de);
                    output += de.input() + "\n";
                }
            } else if (command.equalsIgnoreCase("AddStudent")) {
                String id = tokens[1];
                String name = tokens[2];
                int yob = Integer.parseInt(tokens[3]);
                String ma = tokens[4];
                double gpa = Double.parseDouble(tokens[5]);

                boolean found = false;

                // Kiem tra trung person id
                for (Person x : list) {
                    if (x.getId().equalsIgnoreCase(id)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    output += "Person already exists: " + id + "\n";
                } else {
                    Department loai = null;

                    // Tim department
                    for (Department x : listde) {
                        if (x.getId().equalsIgnoreCase(ma)) {
                            loai = x;
                            break;
                        }
                    }

                    // Neu department chua ton tai thi tao moi
                    if (loai == null) {
                        loai = new Department(ma, "");
                        listde.add(loai);
                    }

                    stu = new Student(id, name, yob, loai, gpa);
                    list.add(stu);
                    output += stu.input() + "\n";
                }
            } else if (command.equalsIgnoreCase("AddLecturer")) {
                String id = tokens[1];
                String name = tokens[2];
                int yob = Integer.parseInt(tokens[3]);
                String ma = tokens[4];
                double salary = Double.parseDouble(tokens[5]);

                boolean found = false;

                // Kiem tra trung person id
                for (Person x : list) {
                    if (x.getId().equalsIgnoreCase(id)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    output += "Person already exists: " + id + "\n";
                } else {
                    Department loai = null;

                    // Tim department
                    for (Department x : listde) {
                        if (x.getId().equalsIgnoreCase(ma)) {
                            loai = x;
                            break;
                        }
                    }

                    // Neu department chua ton tai thi tao moi
                    if (loai == null) {
                        loai = new Department(ma, "");
                        listde.add(loai);
                    }

                    lec = new Lecturer(id, name, yob, loai, salary);
                    list.add(lec);
                    output += lec.input() + "\n";
                }
            } else if (command.equalsIgnoreCase("PrintDepartment")) {
                output += "---Department List---\n";
                if (listde.isEmpty()) {
                    output += "Empty\n";
                } else {
                    for (Department x : listde) {
                        output += x.print() + "\n";
                    }
                }

            } else if (command.equalsIgnoreCase("PrintPerson")) {
                output += "---Person List---\n";
                if (list.isEmpty()) {
                    output += "Empty\n";
                } else {
                    for (Person x : list) {
                        output += x.print() + "\n";
                    }
                }
            } else if (command.equalsIgnoreCase("SearchPerson")) {
                output += "---Search Result---\n";
                String name = tokens[1];

                boolean found = false;

                for (Person x : list) {
                    if (x.getName().toLowerCase().contains(name.toLowerCase())) {
                        output += x.print() + "\n";
                        found = true;
                    }
                }
                if (!found) {
                    output += "Not found\n";
                }

            } else if (command.equalsIgnoreCase("FindPerson")) {
                output += "---Find Result---\n";
                String id = tokens[1];

                boolean found = false;

                for (Person x : list) {
                    if (x.getId().equalsIgnoreCase(id)) {
                        output += x.print() + "\n";
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    output += "Not found\n";
                }

            } else if (command.equalsIgnoreCase("UpdatePerson")) {
                String id = tokens[1];
                double newvalue = Double.parseDouble(tokens[2]);

                boolean found = false;

                for (Person x : list) {
                    if (x.getId().equalsIgnoreCase(id) && x instanceof Student) {
                        stu = (Student) x;
                        stu.setGpa(newvalue);
                         output += String.format(
                    Locale.US,
                    "Update student GPA: %s - %.1f\n",
                    stu.getId(),
                    stu.getGpa()
            );
                        found = true;
                        break;

                    } else if (x.getId().equalsIgnoreCase(id) && x instanceof Lecturer) {
                        lec = (Lecturer) x;
                        lec.setSalary(newvalue);
                         output += String.format(
                    Locale.US,
                    "Update lecturer salary: %s - %.1f\n",
                    lec.getId(),
                    lec.getSalary()
            );
                        found = true;
                        break;
                    }

                }
                if (!found) {
                    output += "Not found\n";
                }

            } else if (command.equalsIgnoreCase("RemovePerson")) {
                String id = tokens[1];
                boolean found = false;

                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).id.equalsIgnoreCase(id)) {
                        Person x = list.remove(j);
                        output += "Remove person: " + x.getId() +"\n";
                        found = true;
                        break;

                    }
                }
                if (!found) {
                    output += "Not found\n";
                }

            } else if (command.equalsIgnoreCase("SortPerson")) {
                output += "---Sorted Person List---\n";

                if (list.isEmpty()) {
                    output += "Empty\n";
                } else {
                    list.sort(
                            Comparator.comparing(
                                    Person::getName,
                                    String.CASE_INSENSITIVE_ORDER
                            ).thenComparing(
                                    Person::getId,
                                    String.CASE_INSENSITIVE_ORDER
                            )
                    );

                    for (Person x : list) {
                        output += x.print() + "\n";
                    }
                }

            } else if (command.equalsIgnoreCase("CountPerson")) {
                String departmentId = tokens[1].trim();
                int count = 0;

                for (Person x : list) {
                    if (x.getDepartment().getId().equalsIgnoreCase(departmentId)) {
                        count++;
                    }
                }

                output += "Number of persons in department "
                        + departmentId + ": " + count + "\n";
            } else if (command.equalsIgnoreCase("ClearPerson")) {
                list.clear();
                output += "* Clear person list\n";

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
