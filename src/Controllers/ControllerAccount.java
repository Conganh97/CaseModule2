package Controllers;

import Models.Account;
import Services.AccountService;
import View.AccountView;

public class ControllerAccount {
    public AccountService accountService;
    public AccountView accountView;

    public ControllerAccount() {
        accountService = new AccountService();
        accountView = new AccountView();
    }

    public void menuAccount (){
        int choice = -1;
        while (choice != 5) {
            choice = accountView.menuAccount();
            switch (choice){
                case 1:
                    accountService.addAccount(accountService.createAccount());
                    break;
                case 2:
                    accountService.editAccount(accountService.findIndex());
                    break;
                case 3:
                    accountService.deleteAccount(accountService.findIndex());
                    break;
                case 4:
                    accountService.displayAccount();
                    break;
                case 5:
                    System.out.println("Exit!!");
                    break;
            }
        }
    }
}
