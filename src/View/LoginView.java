package View;

import java.util.Scanner;

public class LoginView {
    Scanner sc = new Scanner(System.in);

    public int menuLogin (){
        while (true){
            try {
                System.out.println("---------Menu login--------");
                System.out.println("1.|Login");
                System.out.println("2.|Register");
                System.out.println("3.|Exit");
                return Integer.parseInt(sc.nextLine());
            }
            catch (Exception e) {
                System.err.println("Please enter number");
            }
        }
    }
}
