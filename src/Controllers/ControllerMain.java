package Controllers;

import Models.Account;
import Models.FoodAndDrink;
import Models.Table;
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
                    choice1();
                    break;
                case 2:
                    controllerLogin.accountService.addAccount(controllerLogin.accountService.createAccount());
                    break;
                case 3:
                    System.out.println("Exit!!");
                    System.exit(0);
                    break;
            }
        }
    }

    public void choice1() {
        if (controllerLogin.accountService.login()) {
            if (AccountService.account.getRights().equals("admin")) {
                int choice = -1;
                while (choice != 9) {
                    choice = controllerMenu.menuMainView.menuAdmin();
                    switch (choice) {
                        case 1:
                            controllerMenu.menuMainService.chooseTable();
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
                            choice6();
                            break;
                        case 7:
                            choice7();
                            break;
                        case 8:
                            choice8();
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
        }
    }

    public void choice5() {

    }
    public void choice6 (){
        int choice = -1;
        while (choice != 5){
            choice = controllerTable.tableView.menuTable();
            switch (choice){
                case 1:
                    controllerTable.tableService.addTable(controllerTable.tableService.createTable());
                    break;
                case 2:
                    controllerTable.tableService.editTable(controllerTable.tableService.findIndex());
                    break;
                case 3:
                    controllerTable.tableService.deleteTable(controllerTable.tableService.findIndex());
                    break;
                case 4:
                    controllerTable.tableService.displayTable();
                    break;
                default:
                    System.out.println("No option ! choose again");
                    break;
            }
        }

    }
    public void choice7(){
        int choice = -1;
        while (choice != 5){
            choice = controllerFoodAndDrink.foodAndDrinkView.menuFoodAndDrink();
            switch (choice){
                case 1:
                    controllerFoodAndDrink.foodAndDrinkService.addFoodAndDrink(controllerFoodAndDrink.foodAndDrinkService.createFoodAndDrink());
                    break;
                case 2:
                    controllerFoodAndDrink.foodAndDrinkService.editFoodAndDrink(controllerFoodAndDrink.foodAndDrinkService.findIndex());
                    break;
                case 3:
                    controllerFoodAndDrink.foodAndDrinkService.deleteFoodAndDrink(controllerFoodAndDrink.foodAndDrinkService.findIndex());
                    break;
                case 4:
                    controllerFoodAndDrink.foodAndDrinkService.displayFoodAndDrink();
                    break;
                default:
                    System.out.println("No option ! choose again");
                    break;
            }
        }
    }
    public void choice8(){
        int choice = -1;
        while (choice != 5){
            choice = controllerAccount.accountView.menuAccount();
            switch (choice){
                case 1:
                    controllerAccount.accountService.addAccount(controllerAccount.accountService.createAccount());
                    break;
                case 2:
                    controllerAccount.accountService.editAccount(controllerAccount.accountService.findIndex());
                    break;
                case 3:
                    controllerAccount.accountService.deleteAccount(controllerAccount.accountService.findIndex());
                    break;
                case 4:
                    controllerAccount.accountService.displayAccount();
                    break;
                default:
                    System.out.println("No option ! choose again");
                    break;
            }
        }
    }
}