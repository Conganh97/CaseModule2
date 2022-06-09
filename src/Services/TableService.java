package Services;

import Models.FoodAndDrink;
import Models.Table;
import io.ReadAndWrite;

import java.util.ArrayList;
import java.util.Scanner;

public class TableService {
    ArrayList <Table> tables = new ArrayList<>();

    ReadAndWrite readAndWrite = new ReadAndWrite();
    Scanner sc = new Scanner(System.in);

    public TableService() {
        tables = readAndWrite.read(tables,"table.csv");
    }

    {
        ArrayList <FoodAndDrink> fd1 = new ArrayList<>();
        tables.add(new Table(1,fd1,true));
        ArrayList <FoodAndDrink> fd2 = new ArrayList<>();
        tables.add(new Table(2,fd2,true));
        ArrayList <FoodAndDrink> fd3 = new ArrayList<>();
        tables.add(new Table(3,fd3,true));
        ArrayList <FoodAndDrink> fd4 = new ArrayList<>();
        tables.add(new Table(4,fd4,true));
        ArrayList <FoodAndDrink> fd5 = new ArrayList<>();
        tables.add(new Table(5,fd5,true));
        ArrayList <FoodAndDrink> fd6 = new ArrayList<>();
        tables.add(new Table(6,fd6,true));
        ArrayList <FoodAndDrink> fd7 = new ArrayList<>();
        tables.add(new Table(7,fd7,true));
        ArrayList <FoodAndDrink> fd8 = new ArrayList<>();
        tables.add(new Table(8,fd8,true));
        readAndWrite.write(tables,"table.csv");
    }
    public Table createTable(){
        System.out.println("Enter number of table: ");
        int numberTabler = Integer.parseInt(sc.nextLine());
        ArrayList <FoodAndDrink> foodAndDrinks = new ArrayList<>();
        return new Table(numberTabler, foodAndDrinks, true);
    }

    public void addTable (Table table){
        tables.add(table);
    }

    public int findIndex (){
        System.out.println("Enter number of table: ");
        int numberTable = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < tables.size() ; i++) {
            if (tables.get(i).getNumberTable() == numberTable ) {
                return i;
            }
        } return -1;
    }

    public void deleteTable (int index){
        if (index != -1) {
            tables.remove(index);
        } else System.out.println("This table not exist!");
    }
    public void displayTable (){
        for (Table tab: tables) {
            System.out.println(tab);
        }
    }

    public void editTable(int index){
        if (index != -1 ){
            tables.set(index,createTable());
        } else System.out.println("This food not exist!");
    }
}
