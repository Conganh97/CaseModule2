package ValiDate;

import Models.FoodAndDrink;
import Models.Table;
import Services.FoodAndDrinkService;
import Services.TableService;

import java.util.ArrayList;
import java.util.Scanner;

public class ValiDate {
    public static final String REGEX_STRING = "[A-Z][\\sA-Za-z]+";

    public static final String REGEX_ID_FAD = "[A-Z]{3}";
    public static final String REGEX_ACCOUNT = "[A-Za-z0-9]{6,10}";
    public static final String REGEX_EMAIL = "[A-Za-z0-9]+@[a-z]+.[com |vn]+";
    public static final String REGEX_NUMB = "[0-9]{1,4}";
    public static final String REGEX_NUM = "[0-9]+";
    static Scanner scanner = new Scanner(System.in);

    public static String validateString(String regex) {
        while (true) {
            String name = scanner.nextLine();
            if (name.matches(regex)) {
                return name;
            }
            System.err.println("Enter the wrong format, re-enter :");
        }
    }

    public static int validateNum(String regex) {
        while (true) {
            String choice = scanner.nextLine();
            if (choice.matches(regex)) {
                return Integer.parseInt(choice);
            } else System.err.println("Enter the wrong format, re-enter :");
        }
    }

    public static int validateChooseTable() {
        while (true) {
            try {
                int choiceTable = ValiDate.validateNum(ValiDate.REGEX_NUM);
                return choiceTable;
            } catch (Exception e) {
                System.err.println("The table doesn't exist");
            }
        }
    }

    public static int valaidateTableNum() {
        while (true) {
            try {
                System.out.println("Enter number of table: (Number of table must have 1-4 number and no letter)");
                int numberTable = ValiDate.validateNum(ValiDate.REGEX_NUMB);
                for (int i = 0; i < TableService.tables.size(); i++) {
                    if (TableService.tables.get(i).getNumberTable() == numberTable) throw new Exception();
                }
                return numberTable;
            } catch (Exception e) {
                System.err.println("Number of table is exist! Enter again");
            }
        }
    }

    public static String validateIdFAD() {
        while (true) {
            try {
                System.out.println("Enter id: (Id must be in the form ABC, include letters and no numbers) ");
                String id = ValiDate.validateString(ValiDate.REGEX_ID_FAD);
                for (int i = 0; i < FoodAndDrinkService.foodAndDrinks.size(); i++) {
                    if (FoodAndDrinkService.foodAndDrinks.get(i).getId().equals(id)) throw new Exception();
                }
                return id;
            } catch (Exception e) {
                System.err.println("Id food and drink is exist! Enter again");
            }
        }
    }
}

