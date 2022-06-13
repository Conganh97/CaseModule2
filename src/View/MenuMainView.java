package View;

import Models.Table;

import java.util.Scanner;

public class MenuMainView {
    Scanner sc = new Scanner(System.in);
    public int menuAdmin (){
        while (true){
            try {
                System.out.println("--------Menu admin-------");
                System.out.println("1.|Choose table");
                System.out.println("2.|Display menu");
                System.out.println("3.|Display table");
                System.out.println("4.|Display account");
                System.out.println("5.|Pay");
                System.out.println("6.|Update table");
                System.out.println("7.|Update menu");
                System.out.println("8.|Update account");
                System.out.println("9.|Change rights");
                System.out.println("10.|Sign out");
                return Integer.parseInt(sc.nextLine());
            }
            catch (Exception e) {
                System.err.println("Please enter number");
            }
        }
    }

    public int menuUser (){
        while (true){
            try {
                System.out.println("--------Menu staff-------");
                System.out.println("1.|Choose table");
                System.out.println("2.|Display menu");
                System.out.println("3.|Display table");
                System.out.println("4.|Sign out");
                return Integer.parseInt(sc.nextLine());
            }
            catch (Exception e) {
                System.err.println("Please enter number");
            }
        }
    }
}
