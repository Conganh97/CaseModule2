package Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Table implements Serializable {
    private int numberTable;
    private ArrayList <FoodAndDrink> foodAndDrinks = new ArrayList<>();
    private boolean isEmpty;
    private int customerQuantity;

    public static float restaurantRevenue;

    public Table (int numberTable, ArrayList<FoodAndDrink> foodAndDrinks, boolean isEmpty) {
        this.numberTable = numberTable;
        this.foodAndDrinks = foodAndDrinks;
        this.isEmpty = isEmpty;
    }

    public Table() {
    }

    public int getNumberTable() {
        return numberTable;
    }

    public void setNumberTable(int numberTable) {
        this.numberTable = numberTable;
    }

    public ArrayList<FoodAndDrink> getFoodAndDrinks() {
        return foodAndDrinks;
    }

    public void setFoodAndDrinks(ArrayList<FoodAndDrink> foodAndDrinks) {
        this.foodAndDrinks = foodAndDrinks;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
    public String isEmptyS() {
        if (isEmpty){
            return "Empty";
        }else
            return "Full";
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public String toString() {
        return "Table{" +
                "numberTable=" + numberTable +
                ", foodAndDrinks=" + foodAndDrinks +
                ", isEmpty=" + isEmpty +
                ", customerQuantity=" + customerQuantity +
                '}';
    }

    public int getCustomerQuantity() {
        return customerQuantity;
    }

    public void setCustomerQuantity(int customerQuantity) {
        this.customerQuantity = customerQuantity;
    }
}
