
package appkean;

import java.util.Scanner;


public class Appkean {

 
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String name;
        int byear;
        
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your birth year; ");
        byear = sc.nextInt();
        
       System.out.println("Hello "+name+" your age is "+ (2025 - byear));
    }
    
}
