package Controllers;

import Services.AccountService;

public class ControllerMain {
    public ControllerLogin controllerLogin;
    public ControllerMenu controllerMenu;
    public ControllerAccount controllerAccount;
    public ControllerFoodAndDrink controllerFoodAndDrink;
    public ControllerTable controllerTable;

    public ControllerMain() {
        controllerMenu = new ControllerMenu();
        controllerAccount = new ControllerAccount();
        controllerFoodAndDrink = new ControllerFoodAndDrink();
        controllerTable = new ControllerTable();
        controllerLogin = new ControllerLogin();
    }

    public void menu() {
        while (true) {
            int choice = controllerLogin.loginView.menuLogin();
            switch (choice) {
                case 1 -> choiceLogin();
                case 2 -> controllerLogin.choiceRegister();
                case 3 -> {
                    System.out.println("Exit!!");
                    System.exit(0);
                }
                default -> System.out.println("No option !! choose again");
            }
        }
    }

    public void choiceLogin() {
        if (controllerLogin.accountService.login()) {
            System.out.println("Login success!");
            if (AccountService.account.getRights().equals("admin")) {
                int choice = -1;
                while (choice != 9) {
                    System.out.println("Hello " + AccountService.account.getName() + "!!!");
                    choice = controllerMenu.menuMainView.menuAdmin();
                    switch (choice) {
                        case 1 -> controllerMenu.menuMainService.chooseTable();
                        case 2 -> controllerFoodAndDrink.foodAndDrinkService.displayFoodAndDrink();
                        case 3 -> controllerTable.tableService.displayTable();
                        case 4 -> controllerAccount.accountService.displayAccount();
                        case 5 -> controllerMenu.menuMainService.choicePay();
                        case 6 -> controllerTable.choiceTable();
                        case 7 -> controllerFoodAndDrink.choiceFoodAndDrink();
                        case 8 -> controllerAccount.choiceAccount();
                        case 9 -> System.out.println("Sign out");
                        default -> System.out.println("No option ! choose again");
                    }
                }
            } else {
                int choice = -1;
                while (choice != 3) {
                    System.out.println("Hello " + AccountService.account.getName() + "!!!");
                    choice = controllerMenu.menuMainView.menuUser();
                    switch (choice) {
                        case 1 -> controllerMenu.menuMainService.chooseTable();
                        case 2 -> controllerFoodAndDrink.foodAndDrinkService.displayFoodAndDrink();
                        case 3 -> System.out.println("Sign out");
                        default -> System.out.println("No option ! choose again");
                    }
                }
            }
        } else System.out.println("Login fail. Try again!");
    }
}