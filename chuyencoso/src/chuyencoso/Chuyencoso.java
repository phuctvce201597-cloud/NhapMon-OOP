package chuyencoso;

import java.util.Scanner;
import java.util.Arrays;

public class Chuyencoso {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int kq = 0;
        int j = 0;
        int arr[] = new int[100];
        while (n > 0){
            kq = n % 2;
            arr[j] = kq;
            j++;
            n /= 2;
            
        }
      for(int i = j - 1; i >= 0; i--){
          System.out.printf("%d", arr[i]);
       }
    }
}