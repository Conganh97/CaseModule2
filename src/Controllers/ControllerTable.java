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

    public void menuTable (){
        int choice = -1;
        while (choice != 5) {
            choice = tableView.menuTable();
            switch (choice){
                case 1:
                    tableService.addTable(tableService.createTable());
                    break;
                case 2:
                    tableService.editTable(tableService.findIndex());
                    break;
                case 3:
                    tableService.deleteTable(tableService.findIndex());
                    break;
                case 4:
                    tableService.displayTable();
                    break;
                case 5:
                    System.out.println("Exit!!");
                    break;
            }
        }
    }
}
