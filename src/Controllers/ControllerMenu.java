package Controllers;

import Services.MenuMainService;
import Services.TableService;
import View.MenuMainView;

public class ControllerMenu {
    public MenuMainView menuMainView;
    public MenuMainService menuMainService;

    public ControllerMenu() {
        menuMainView = new MenuMainView();
        menuMainService = new MenuMainService();
    }
}
