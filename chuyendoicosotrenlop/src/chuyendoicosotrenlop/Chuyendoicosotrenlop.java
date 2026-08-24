package chuyendoicosotrenlop;

import java.util.Scanner;
import java.util.Arrays;

public class Chuyendoicosotrenlop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(changeBase(2, 16));
    }
        
        public static String changeBase (int n, int b){
            String result = "";
            char[] rm = {'A', 'B', 'C', 'D', 'E', 'F'};
            while(n > 0){
                int remainder = n % b;
                if(remainder >= 10){
                    result = rm[remainder % 10]+ result;
                }else 
                    {
                       result = remainder + result;
                    }
                n /= b;
                }
            return result;
            }
        }
        
    
