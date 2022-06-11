package Services;

import Models.FoodAndDrink;
import Models.Table;
import ValiDate.ValiDate;

import java.util.Scanner;

public class MenuMainService {
    public TableService tableService;
    public FoodAndDrinkService foodAndDrinkService;
    Scanner sc = new Scanner(System.in);

    public void chooseTable() {
        System.out.printf(" | %-15s| %-15s| %-15s","Number of Table","Status","Customer Quantity");
        System.out.println();
        System.out.println("------------------------------------------------------");
        for (Table tb: tableService.tables) {
            System.out.printf(" | %-15s| %-15s| %-15s",tb.getNumberTable(),tb.isEmptyS(),tb.getCustomerQuantity());
            System.out.println();
            System.out.println("------------------------------------------------------");
        }
        System.out.println("Please enter '0' if you want to exit!");
        int choiceTable = ValiDate.validateNum(ValiDate.REGEX_NUM);
        while (choiceTable != 0) {
                int choiceFood;
                do {
                    System.out.println("Choose food or drink");
                    System.out.printf("|%-15s| %-15s| %-15s","ID","Name","Price");
                    System.out.println();
                    System.out.println("------------------------------------------------------");
                    for (FoodAndDrink fd: foodAndDrinkService.foodAndDrinks) {
                        System.out.printf("|%-15s| %-25s| %-15s",fd.getId(),fd.getName(),fd.getAmount());
                        System.out.println();
                        System.out.println("------------------------------------------------------");
                    }
                    System.out.println("Please enter '0' if you want to exit!");
                    choiceFood = ValiDate.validateNum(ValiDate.REGEX_NUM);
                    if (choiceFood == 0) break;
                    tableService.tables.get(choiceTable-1).getFoodAndDrinks().add(foodAndDrinkService.foodAndDrinks.get(choiceFood-1));
                } while (choiceFood != 0);
                break;
        }
    }
}
