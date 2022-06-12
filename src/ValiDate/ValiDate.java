package ValiDate;

import Services.TableService;

import java.util.Scanner;

public class ValiDate {
    public static final String REGEX_STRING = "[A-Z][\\sA-Za-z]+";

    public static final String REGEX_ID_FAD = "[A-Z]{3}";
    public static final String REGEX_ACCOUNT = "[A-Za-z0-9]{6,10}";
    public static final String REGEX_EMAIL = "[A-Za-z0-9]+@[a-z]+.[com |vn]+";
    public static final String REGEX_NUMB = "[0-9]{1,4}";
    public static final String REGEX_NUM = "[0-9]+";
    static Scanner scanner = new Scanner(System.in);

    public static String validateString (String regex){
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

    public static int validateTable(){
        while (true){
            try {
                int choiceTable = ValiDate.validateNum(ValiDate.REGEX_NUM);
                if ( choiceTable > TableService.tables.size()) throw new Exception();
                return choiceTable;
            } catch (Exception e) {
                System.err.println("The table doesn't exist");
            }
        }
    }
}

