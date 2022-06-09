package Services;

import Models.Table;

import java.util.Scanner;

public class MenuMainService {
    TableService tableService = new TableService();

    FoodAndDrinkService foodAndDrinkService = new FoodAndDrinkService();
    Scanner sc = new Scanner(System.in);

//    public void chooseTable() {
//        for (int i = 0; i < tableService.tables.size(); i++) {
//            System.out.println((i + 1)+"." + tableService.tables.get(i).toString());
//        }
//        System.out.println("Please enter '0' if you want to exit!");
//        int choiceTable = Integer.parseInt(sc.nextLine());
//        while (choiceTable != 0) {
//            if (choiceTable == 0) break;
//            try {
//                int choiceFood = -1;
//                while (choiceFood != 0) {
//                    if (choiceFood == 0) break;
//                    for (int i = 0; i < foodAndDrinkService.foodAndDrinks.size(); i++) {
//                        System.out.println((i + 1)+"." + foodAndDrinkService.foodAndDrinks.get(i).toString());
//                    }
//                    System.out.println("Please enter '0' if you want to exit!");
//                    choiceFood = Integer.parseInt(sc.nextLine());
//
//                    tableService.tables.get(choiceTable-1).getFoodAndDrinks().add(foodAndDrinkService.foodAndDrinks.get(choiceFood-1));
//                }
//                break;
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("Choose again!");
//            }
//        }
//    }
}
