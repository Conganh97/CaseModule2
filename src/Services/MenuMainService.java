package Services;

import Models.FoodAndDrink;
import Models.Table;
import ValiDate.ValiDate;
import io.ReadAndWrite;

import java.util.Scanner;

public class MenuMainService {
    public TableService tableService;
    ReadAndWrite<Table> tableReadAndWrite = new ReadAndWrite<>();
    ReadAndWrite<FoodAndDrink> foodAndDrinkReadAndWrite = new ReadAndWrite<>();
    Scanner sc = new Scanner(System.in);

    public void chooseTable() {
        displayTable();
        int choiceTableName = ValiDate.validateChooseTable();
        int choiceTable = 0;
        for (int i = 0; i < TableService.tables.size(); i++) {
            if (TableService.tables.get(i).getNumberTable() == choiceTableName) {
                choiceTable = i + 1;
                System.out.println("Enter customer quantity");
                TableService.tables.get(choiceTable - 1).setCustomerQuantity(ValiDate.validateNum(ValiDate.REGEX_NUM));
                break;
            }
        }
        while (choiceTable != 0) {
            int choiceFood = 0;
            do {
                displayDish();
                try {
                    choiceFood = ValiDate.validateNum(ValiDate.REGEX_NUM);
                    if (choiceFood == 0) break;
                    else if (FoodAndDrinkService.foodAndDrinks.get(choiceFood - 1).getAmount() == 0) {
                        System.out.println("The dish is out!!");
                        tableReadAndWrite.write(TableService.tables, "table.csv");
                        foodAndDrinkReadAndWrite.write(FoodAndDrinkService.foodAndDrinks, "foodanddrink.csv");
                        break;
                    } else {
                        TableService.tables.get(choiceTable - 1).getFoodAndDrinks().add(FoodAndDrinkService.foodAndDrinks.get(choiceFood - 1));
                        FoodAndDrinkService.foodAndDrinks.get(choiceFood - 1).setAmount(FoodAndDrinkService.foodAndDrinks.get(choiceFood - 1).getAmount() - 1);
                        TableService.tables.get(choiceTable - 1).setEmpty(false);
                    }
                } catch (Exception e) {
                    System.err.println("The dish doesn't exist");
                }
            } while (choiceFood != 0);
            displaySelectedDish(choiceTable);
            tableReadAndWrite.write(TableService.tables, "table.csv");
            foodAndDrinkReadAndWrite.write(FoodAndDrinkService.foodAndDrinks, "foodanddrink.csv");
            break;
        }
    }

    public void choicePay() {
        int choiceTable = 99;
        while (choiceTable != 0) {
            try {
                displayTableFull();
                int choiceTableName = ValiDate.validateChooseTable();
                for (int i = 0; i < TableService.tables.size(); i++) {
                    if (TableService.tables.get(i).getNumberTable() == choiceTableName) {
                        choiceTable = i;
                        break;
                    }
                }
                if (choiceTableName == 0) break;
                displayBill(choiceTable);
                System.out.println("Do you want to pay?");
                System.out.println("1.|Yes");
                System.out.println("2.|No");
                final String regex = "[1-2]";
                int choicePay;
                while (true) {
                    try {
                        choicePay = ValiDate.validateNum(regex);
                        if (choicePay == 1) {
                            pay(choiceTable);
                            tableReadAndWrite.write(TableService.tables, "table.csv");
                            break;
                        } else {
                            System.out.println("Unpaid!!");
                            break;
                        }
                    } catch (Exception e) {
                        System.err.println("Please enter 1 or 2");
                    }
                }
            } catch (Exception e) {
                System.err.println("The table doesn't exist");
            }
        }
    }

    public void displayDish() {
        System.out.println("Choose food or drink");
        System.out.printf("| %-15s| %-15s| %-25s| %-15s", "No", "ID", "Name", "Price");
        System.out.println();
        System.out.println("------------------------------------------------------");
        int index = 1;
        for (FoodAndDrink fd : FoodAndDrinkService.foodAndDrinks) {
            System.out.printf("| %-15s| %-15s| %-25s| %-15s", index, fd.getId(), fd.getName(), fd.getAmount());
            System.out.println();
            System.out.println("------------------------------------------------------");
            index++;
        }
        System.out.println("Please enter '0' if you want to exit!");
    }

    public void displayTable() {
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

    public void displayTableFull() {
        System.out.printf(" | %-15s| %-15s| %-15s", "Number of Table", "Status", "Customer Quantity");
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

    public void displayBill(int choiceTable) {
        float totalBill = 0;
        System.out.println("---------------------------------Bill--------------------------------- ");
        System.out.printf("| %-15s| %-25s| %-15s| %-15s ", "ID", "Name", "Price", "Amount");
        System.out.println();
        for (FoodAndDrink fd : TableService.tables.get(choiceTable).getFoodAndDrinks()) {
            System.out.printf("| %-15s| %-25s| %-15s| %-15s ", fd.getId(), fd.getName(), fd.getPrice(), "1");
            System.out.println();
            totalBill += fd.getPrice();
        }
        System.out.println("----------------------------------------------------------------------- ");
        System.out.println("                                  Total Bill|" + totalBill);
    }

    public void pay(int choiceTable) {
        float totalBill = 0;
        TableService.tables.get(choiceTable).getFoodAndDrinks().clear();
        TableService.tables.get(choiceTable).setEmpty(true);
        TableService.tables.get(choiceTable).setCustomerQuantity(0);
        for (FoodAndDrink fd : TableService.tables.get(choiceTable).getFoodAndDrinks()) {
            totalBill = totalBill + fd.getPrice();
        }
        System.out.println("Pay success!!!");
    }

    public void displaySelectedDish(int choiceTable) {
        System.out.println("The table's dish list is: ");
        System.out.printf("| %-15s| %-15s| %-25s| %-15s| %-15s ", "No", "ID", "Name", "Price", "Amount");
        System.out.println();
        int index = 0;
        for (FoodAndDrink fd : TableService.tables.get(choiceTable - 1).getFoodAndDrinks()) {
            System.out.printf("| %-15s| %-15s| %-25s| %-15s| %-15s ", (index + 1), fd.getId(), fd.getName(), fd.getPrice(), "1");
            System.out.println();
            index++;
        }
    }

//    public void removeDish() {
//        displayTableFull();
//        int chooseTable = 0;
//        int chooseTableName = ValiDate.validateChooseTable();
//        for (int i = 0; i < TableService.tables.size(); i++) {
//            if (TableService.tables.get(i).getNumberTable() == chooseTableName) {
//                chooseTable = i;
//                break;
//            }
//            if (TableService.tables.get(chooseTable).isEmpty()) {
//            }
//        }
//    }
}