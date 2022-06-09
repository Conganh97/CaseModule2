package View;

import java.util.Scanner;

public class TableView {
    Scanner sc = new Scanner(System.in);
    public int menuTable (){
        System.out.println("1.|Add table");
        System.out.println("2.|Edit table");
        System.out.println("3.|Delete table");
        System.out.println("4.|Display table");
        System.out.println("5.|Exit");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuTableFull (){
        System.out.println("1.|Check order");
        System.out.println("2.|Pay");
        System.out.println("3.|Order more");
        System.out.println("4.|Edit order");
        System.out.println("6.|Exit");
        return Integer.parseInt(sc.nextLine());
    }
}
