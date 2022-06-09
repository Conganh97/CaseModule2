package Services;

import Models.FoodAndDrink;
import io.ReadAndWrite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class FoodAndDrinkService {
    ReadAndWrite readAndWrite = new ReadAndWrite();
    Scanner sc = new Scanner(System.in);
    ArrayList <FoodAndDrink> foodAndDrinks = new ArrayList<>();

    public FoodAndDrinkService() {
        foodAndDrinks = readAndWrite.read(foodAndDrinks,"foodanddrink.csv");
    }

    {
        foodAndDrinks.add(new FoodAndDrink("SC","Spaghetti Classic",100,40));
        foodAndDrinks.add(new FoodAndDrink("SB","Spaghetti Bolognese",100,50));
        foodAndDrinks.add(new FoodAndDrink("SCA","Spaghetti Carbonara",100,40));
        foodAndDrinks.add(new FoodAndDrink("PS","Pizza Seafood",100,80));
        foodAndDrinks.add(new FoodAndDrink("PB","Pizza Beef",100,80));
        foodAndDrinks.add(new FoodAndDrink("TBS","Top Blade Steak",100,200));
        foodAndDrinks.add(new FoodAndDrink("TS","Tenderloin Steak",100,300));
        foodAndDrinks.add(new FoodAndDrink("PS","Pepsi",100,20));
        foodAndDrinks.add(new FoodAndDrink("MJ","Lemon Juice",100,25));
        foodAndDrinks.add(new FoodAndDrink("PT","Peach Tea",100,30));
        readAndWrite.write(foodAndDrinks,"foodanddrink.csv");
    }

    public FoodAndDrink createFoodAndDrink(){
        System.out.println("Enter id: ");
        String id = sc.nextLine();
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter amount: ");
        int amount = Integer.parseInt(sc.nextLine());
        System.out.println("Enter price: ");
        float price = Float.parseFloat(sc.nextLine());
        return new FoodAndDrink(id,name, amount, price);
    }

    public void addFoodAndDrink (FoodAndDrink foodAndDrink){
        foodAndDrinks.add(foodAndDrink);
    }

    public int findIndex (){
        System.out.println("Enter name need search: ");
        String name = sc.nextLine();
        for (int i = 0; i < foodAndDrinks.size() ; i++) {
            if (foodAndDrinks.get(i).getName().equals(name)) {
                return i;
            }
        } return -1;
    }

    public void deleteFoodAndDrink (int index){
        if (index != -1) {
            foodAndDrinks.remove(index);
        } else System.out.println("This food not exist!");
    }
    public void displayFoodAndDrink (){
        for (FoodAndDrink fd: foodAndDrinks) {
            System.out.println(fd);
        }
    }

    public void editFoodAndDrink(int index){
        if (index != -1 ){
            foodAndDrinks.set(index,createFoodAndDrink());
        } else System.out.println("This food not exist!");
    }
}
