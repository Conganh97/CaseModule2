package View;

import java.util.Scanner;

public class LoginView {
    Scanner sc = new Scanner(System.in);

    public int menuLogin (){
        System.out.println("1.|Login");
        System.out.println("2.|Register");
        System.out.println("3.|Exit");
        return Integer.parseInt(sc.nextLine());
    }
}
