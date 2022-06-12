package Services;

import Models.FoodAndDrink;
import Models.Table;
import ValiDate.ValiDate;

import java.util.Scanner;

public class MenuMainService {
    public TableService tableService;
    public static float restaurantRevenue = 0;
    Scanner sc = new Scanner(System.in);

    public void chooseTable() {

        displayTable();
        int choiceTable = ValiDate.validateNum(ValiDate.REGEX_NUM);
        while (choiceTable != 0) {
            int choiceFood = 99;
            do {
                displayDish();
                try {
                    choiceFood = ValiDate.validateNum(ValiDate.REGEX_NUM);
                    if (choiceFood == 0) break;
                    else if (FoodAndDrinkService.foodAndDrinks.get(choiceFood - 1).getAmount() == 0) {
                        System.out.println("The dish is out!! Please choose different dish");
                        break;
                    } else {
                        TableService.tables.get(choiceTable - 1).getFoodAndDrinks().add(FoodAndDrinkService.foodAndDrinks.get(choiceFood - 1));
                        FoodAndDrinkService.foodAndDrinks.get(choiceFood - 1).setAmount(FoodAndDrinkService.foodAndDrinks.get(choiceFood - 1).getAmount() - 1);
                        TableService.tables.get(choiceTable - 1).setEmpty(false);
                        System.out.println("The table's dish list is: ");
                        System.out.printf("| %-15s| %-25s| %-15s| %-15s ", "ID", "Name", "Price", "Amount");
                        System.out.println();
                        for (FoodAndDrink fd : TableService.tables.get(choiceTable - 1).getFoodAndDrinks()) {
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
                displayTableFull();
                choiceTable = ValiDate.validateNum(ValiDate.REGEX_NUM);
                if (choiceTable == 0) break;
                displayBill(choiceTable);
                System.out.println("Do you want to pay?");
                System.out.println("1.|Yes");
                System.out.println("2.|No");
                final String regex = "[1-2]";
                int choicePay;
                while (true){
                    try {
                        choicePay = ValiDate.validateNum(regex);
                        if (choicePay == 1) {
                            float totalBill = 0;
                            TableService.tables.get(choiceTable-1).getFoodAndDrinks().clear();
                            TableService.tables.get(choiceTable-1).setEmpty(true);
                            TableService.tables.get(choiceTable-1).setCustomerQuantity(0);
                            for (FoodAndDrink fd : TableService.tables.get(choiceTable - 1).getFoodAndDrinks()) {
                                totalBill += fd.getAmount();
                            }
                            restaurantRevenue += totalBill;
                        }
                        else break;
                    } catch (Exception e){
                        System.err.println("Please enter 1 or 2");
                    }
                }
            } catch (Exception e) {
                System.err.println("The table doesn't exist");
            }
        }
    }
    public void displayDish (){
        System.out.println("Choose food or drink");
        System.out.printf("|%-15s| %-15s| %-15s", "ID", "Name", "Price");
        System.out.println();
        System.out.println("------------------------------------------------------");
        for (FoodAndDrink fd : FoodAndDrinkService.foodAndDrinks) {
            System.out.printf("|%-15s| %-25s| %-15s", fd.getId(), fd.getName(), fd.getAmount());
            System.out.println();
            System.out.println("------------------------------------------------------");
        }
        System.out.println("Please enter '0' if you want to exit!");
    }

    public void displayTable (){
        System.out.printf(" | %-15s| %-15s| %-15s", "Number of Table", "Status", "Customer Quantity");
        System.out.println();
        System.out.println("------------------------------------------------------");
        for (Table tb : TableService.tables) {
            System.out.printf(" | %-15s| %-15s| %-15s", tb.getNumberTable(), tb.isEmptyS(), tb.getCustomerQuantity());
            System.out.println();
            System.out.println("------------------------------------------------------");
        }
        System.out.println("Please enter '0' if you want to exit!");
    }
    public void displayTableFull (){System.out.printf(" | %-15s| %-15s| %-15s", "Number of Table", "Status", "Customer Quantity");
        System.out.println();
        System.out.println("------------------------------------------------------");
        for (Table tb : TableService.tables) {
            if (!tb.isEmpty()) {
                System.out.printf(" | %-15s| %-15s| %-15s", tb.getNumberTable(), tb.isEmptyS(), tb.getCustomerQuantity());
                System.out.println();
                System.out.println("------------------------------------------------------");
            }
        }
        System.out.println("Please enter '0' if you want to exit!");

    }
    public void displayBill (int choiceTable){
        float totalBill = 0;
        System.out.println("---------------------------------Bill--------------------------------- ");
        System.out.printf("| %-15s| %-25s| %-15s| %-15s ", "ID", "Name", "Price", "Amount");
        System.out.println();
        for (FoodAndDrink fd : TableService.tables.get(choiceTable - 1).getFoodAndDrinks()) {
            System.out.printf("| %-15s| %-25s| %-15s| %-15s ", fd.getId(), fd.getName(), fd.getPrice(), "1");
            System.out.println();
            totalBill += fd.getAmount();
        }
        System.out.println("----------------------------------------------------------------------- ");
        System.out.println("                                  Total Bill|" + totalBill);
    }
}
