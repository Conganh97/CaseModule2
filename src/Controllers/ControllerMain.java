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
                case 1:
                    choiceLogin();
                    break;
                case 2:
                    controllerLogin.choiceRegister();
                    break;
                case 3:
                    System.out.println("Exit!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("No option !! choose again");
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
                        case 1:
                            controllerMenu.menuMainService.chooseTable();
                            break;
                        case 2:
                            controllerFoodAndDrink.foodAndDrinkService.displayFoodAndDrink();
                            break;
                        case 3:
                            controllerTable.tableService.displayTable();
                            break;
                        case 4:
                            controllerAccount.accountService.displayAccount();
                            break;
                        case 5:
                            choice5();
                            break;
                        case 6:
                            controllerTable.choiceTable();
                            break;
                        case 7:
                            controllerFoodAndDrink.choiceFoodAndDrink();
                            break;
                        case 8:
                            controllerAccount.choiceAccount();
                            break;
                        case 9:
                            System.out.println("Sign out");
                            break;
                        default:
                            System.out.println("No option ! choose again");
                            break;
                    }
                }
            } else {
                int choice = -1;
                while (choice != 3) {
                    choice = controllerMenu.menuMainView.menuUser();
                    switch (choice) {
                        case 1:
                            break;
                        case 2:
                            controllerFoodAndDrink.foodAndDrinkService.displayFoodAndDrink();
                            break;
                        case 3:
                            System.out.println("Sign out");
                            break;
                        default:
                            System.out.println("No option ! choose again");
                            break;
                    }
                }
            }
        } else System.out.println("Login fail. Try again!");
    }
        public void choice5() {

        }

    }