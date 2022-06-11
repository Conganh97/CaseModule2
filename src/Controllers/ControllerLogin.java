package Controllers;

import Services.AccountService;
import View.LoginView;

public class ControllerLogin {

    public AccountService accountService;

    public LoginView loginView;

    public ControllerLogin() {
        accountService = new AccountService();
        loginView = new LoginView();
    }
    public void choiceRegister(){
        accountService.addAccount(accountService.createAccount());
    }
}
