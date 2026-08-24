package hotenbienthanh;

import java.util.Scanner;
import java.util.Arrays;

public class Hotenbienthanh {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao mot chuoi : ");
        String ten = sc.nextLine();

        int n = ten.length();
        
        System.out.print("\nChuoi bien thanh : ");
        for (int i = 0; i < n; i++) {
            char c = ten.charAt(i);

            if (Character.isUpperCase(c)) {
                System.out.print(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                System.out.print(Character.toUpperCase(c));
            } else {
                System.out.print(c);
            }
        }
    }
}
