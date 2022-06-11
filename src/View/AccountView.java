package View;

import java.util.Scanner;

public class AccountView {
    Scanner sc = new Scanner(System.in);
    public int menuAccount (){
        System.out.println("--------Menu Account-------");
        while (true){
            try {
                System.out.println("1.|Add account");
                System.out.println("2.|Edit account");
                System.out.println("3.|Delete account");
                System.out.println("4.|Display all");
                System.out.println("5.|Exit");
                return Integer.parseInt(sc.nextLine());
            }
            catch (Exception e) {
                System.err.println("Please enter number");
            }
        }
    }
}
