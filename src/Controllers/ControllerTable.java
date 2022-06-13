package Controllers;

import Services.TableService;
import View.TableView;

public class ControllerTable {
    public TableService tableService;
    public TableView tableView;

    public ControllerTable() {
        tableService = new TableService();
        tableView = new TableView();
    }


    public void choiceTable (){
        int choice = -1;
        while (choice != 5){
            choice = tableView.menuTable();
            switch (choice) {
                case 1 -> tableService.addTable(tableService.createTable());
                case 2 -> tableService.editTable(tableService.findIndex());
                case 3 -> tableService.deleteTable(tableService.findIndex());
                case 4 -> tableService.displayTable();
                case 5 -> System.out.println("Back menu!");
                default -> System.out.println("No option ! choose again");
            }
        }
    }
}
