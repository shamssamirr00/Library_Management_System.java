package com.library.util;
import java.util.Scanner;

public class InputUtil {
    private Scanner scanner ;
    public InputUtil(){
        scanner=new Scanner(System.in);
    }
    public String readString(String message){
        System.out.print(message);
        return scanner.nextLine();
    }
    public int readInt(String message){
        while(true){
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            }catch ( NumberFormatException e){
                System.out.print("Please enter a number");
            }
        }
    }
}
