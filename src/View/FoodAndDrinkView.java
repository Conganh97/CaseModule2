package View;

import java.util.Scanner;

public class FoodAndDrinkView {
    Scanner sc = new Scanner(System.in);
    public int menuFoodAndDrink (){
        System.out.println("1.|Add food or drink");
        System.out.println("2.|Edit food or drink");
        System.out.println("3.|Delete food or drink");
        System.out.println("4.|Display all");
        System.out.println("5.|Exit");
        return Integer.parseInt(sc.nextLine());
    }
}
