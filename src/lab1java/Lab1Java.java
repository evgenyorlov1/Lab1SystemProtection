package lab1java;

import java.util.Scanner;


public class Lab1Java {

    public static void main(String[] args) {
        System.out.println("Hello!");
        Scanner scanner = new Scanner(System.in);
        while(true) {            
            System.out.println("Enter your name:");            
            String name = scanner.nextLine();                        
            System.out.println("Enter your password:");            
            String password = scanner.nextLine();            
            if(name == "ADMIN") {
                Admin admin = new Admin(password);
            } else {
                User user = new User(name, password);
            }
        }        
    }
    
}
