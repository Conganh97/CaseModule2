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
        System.out.printf(" | %-15s| %-15s| %-15s", "Number of Table", "Status", "Customer Quantity");
        System.out.println();
        System.out.println("------------------------------------------------------");
        for (Table tb : tableService.tables) {
            System.out.printf(" | %-15s| %-15s| %-15s", tb.getNumberTable(), tb.isEmptyS(), tb.getCustomerQuantity());
            System.out.println();
            System.out.println("------------------------------------------------------");
        }
        System.out.println("Please enter '0' if you want to exit!");
        int choiceTable = ValiDate.validateNum(ValiDate.REGEX_NUM);
        while (choiceTable != 0) {
            int choiceFood = 99;
            do {
                System.out.println("Choose food or drink");
                System.out.printf("|%-15s| %-15s| %-15s", "ID", "Name", "Price");
                System.out.println();
                System.out.println("------------------------------------------------------");
                for (FoodAndDrink fd : foodAndDrinkService.foodAndDrinks) {
                    System.out.printf("|%-15s| %-25s| %-15s", fd.getId(), fd.getName(), fd.getAmount());
                    System.out.println();
                    System.out.println("------------------------------------------------------");
                }
                System.out.println("Please enter '0' if you want to exit!");

                try {
                    choiceFood = ValiDate.validateNum(ValiDate.REGEX_NUM);
                    if (choiceFood == 0) break;
                    else if (foodAndDrinkService.foodAndDrinks.get(choiceFood - 1).getAmount() == 0) {
                        System.out.println("The dish is out!! Please choose different dish");
                        break;
                    } else {
                        tableService.tables.get(choiceTable - 1).getFoodAndDrinks().add(foodAndDrinkService.foodAndDrinks.get(choiceFood - 1));
                        foodAndDrinkService.foodAndDrinks.get(choiceFood - 1).setAmount(foodAndDrinkService.foodAndDrinks.get(choiceFood - 1).getAmount() - 1);
                        tableService.tables.get(choiceTable - 1).setEmpty(false);
                        System.out.println("The table's dish list is: ");
                        System.out.printf("| %-15s| %-25s| %-15s| %-15s ", "ID", "Name", "Price", "Amount");
                        System.out.println();
                        for (FoodAndDrink fd : tableService.tables.get(choiceTable - 1).getFoodAndDrinks()) {
                            System.out.printf("| %-15s| %-25s| %-15s| %-15s ", fd.getId(), fd.getName(), fd.getPrice(), "1");
                            System.out.println();
                        }
                    }
                } catch (Exception e) {
                    System.err.println("The dish doesn't exist");
                }
            } while (choiceFood != 0);
            break;
        }
    }

    public void choicePay() {
        int choiceTable = 99;
        while (choiceTable != 0) {
            try {
                System.out.printf(" | %-15s| %-15s| %-15s", "Number of Table", "Status", "Customer Quantity");
                System.out.println();
                System.out.println("------------------------------------------------------");
                for (Table tb : tableService.tables) {
                    if (!tb.isEmpty()) {
                        System.out.printf(" | %-15s| %-15s| %-15s", tb.getNumberTable(), tb.isEmptyS(), tb.getCustomerQuantity());
                        System.out.println();
                        System.out.println("------------------------------------------------------");
                    }
                }
                System.out.println("Please enter '0' if you want to exit!");
                choiceTable = ValiDate.validateNum(ValiDate.REGEX_NUM);
                if (choiceTable == 0) break;
                float totalBill = 0;
                System.out.println("---------------------------------Bill--------------------------------- ");
                System.out.printf("| %-15s| %-25s| %-15s| %-15s ", "ID", "Name", "Price", "Amount");
                System.out.println();
                for (FoodAndDrink fd : tableService.tables.get(choiceTable - 1).getFoodAndDrinks()) {
                    System.out.printf("| %-15s| %-25s| %-15s| %-15s ", fd.getId(), fd.getName(), fd.getPrice(), "1");
                    System.out.println();
                    totalBill += fd.getAmount();
                }
                System.out.println("----------------------------------------------------------------------- ");
                System.out.println("                                  Total Bill|" + totalBill);
            } catch (Exception e) {
                System.err.println("The table doesn't exist");
            }
        }
    }
}
