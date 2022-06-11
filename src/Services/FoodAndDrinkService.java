package Services;

import Models.FoodAndDrink;
import ValiDate.ValiDate;
import io.ReadAndWrite;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FoodAndDrinkService {
    ReadAndWrite readAndWrite = new ReadAndWrite();
    Scanner sc = new Scanner(System.in);

    public static ArrayList <FoodAndDrink> foodAndDrinks = new ArrayList<>();

    public FoodAndDrinkService() {
        foodAndDrinks = readAndWrite.read(foodAndDrinks,"foodanddrink.csv");
    }

//    {
//        foodAndDrinks.add(new FoodAndDrink("SCL","Spaghetti Classic",100,40));
//        foodAndDrinks.add(new FoodAndDrink("SBO","Spaghetti Bolognese",100,50));
//        foodAndDrinks.add(new FoodAndDrink("SCA","Spaghetti Carbonara",100,40));
//        foodAndDrinks.add(new FoodAndDrink("PSE","Pizza Seafood",100,80));
//        foodAndDrinks.add(new FoodAndDrink("PBE","Pizza Beef",100,80));
//        foodAndDrinks.add(new FoodAndDrink("TBS","Top Blade Steak",100,200));
//        foodAndDrinks.add(new FoodAndDrink("TST","Tenderloin Steak",100,300));
//        foodAndDrinks.add(new FoodAndDrink("PSI","Pepsi",100,20));
//        foodAndDrinks.add(new FoodAndDrink("MJU","Lemon Juice",100,25));
//        foodAndDrinks.add(new FoodAndDrink("PTE","Peach Tea",100,30));
//        readAndWrite.write(foodAndDrinks,"foodanddrink.csv");
//    }

    public FoodAndDrink createFoodAndDrink(){
        System.out.println("Enter id: (Id must be in the form ABC, include letters and no numbers) ");
        String id = ValiDate.validateString(ValiDate.REGEX_ID_FAD);
        System.out.println("Enter name: (Name must have at least 1 uppercase letter and no number)");
        String name = ValiDate.validateString(ValiDate.REGEX_STRING);
        System.out.println("Enter amount: (Amount must have 1-4 number and no letter) ");
        int amount = Integer.parseInt(ValiDate.validateString(ValiDate.REGEX_NUMB));
        System.out.println("Enter price: (Price must have 1-4 number and no letter) ");
        float price = Float.parseFloat(ValiDate.validateString(ValiDate.REGEX_NUMB));
        return new FoodAndDrink(id,name, amount, price);
    }

    public void addFoodAndDrink (FoodAndDrink foodAndDrink){
        foodAndDrinks.add(foodAndDrink);
        System.out.println("Add Food or Drink " +foodAndDrink.getName()+ " success");
        readAndWrite.write(foodAndDrinks,"foodanddrink.csv");
    }

    public int findIndex (){
        System.out.println("Enter name need search: (Name must have at least 1 uppercase letter and no number) ");
        String name = ValiDate.validateString(ValiDate.REGEX_STRING);
        for (int i = 0; i < foodAndDrinks.size() ; i++) {
            if (foodAndDrinks.get(i).getName().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT))) {
                return i;
            }
        } return -1;
    }

    public void deleteFoodAndDrink (int index){
        if (index != -1) {
            foodAndDrinks.remove(index);
            System.out.println("Delete Food or Drink success");
            readAndWrite.write(foodAndDrinks,"foodanddrink.csv");
        } else System.out.println("This food not exist!");
    }
    public void displayFoodAndDrink (){
        System.out.println("----------------------------------Menu food and drink----------------------------------");
        System.out.printf("| %-10s| %-15s| %-25s| %-15s| %-15s","No", "ID","Name","Price","Quantity");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------");
        int i = 1;
        for (FoodAndDrink fd: foodAndDrinks) {
            System.out.printf("|%-10s | %-15s| %-25s| %-15s| %-15s",i, fd.getId(),fd.getName(),fd.getPrice(),fd.getAmount());
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------");
            i++;
        }
    }

    public void editFoodAndDrink(int index){
        if (index != -1 ){
            foodAndDrinks.set(index,createFoodAndDrink());
            System.out.println("Edit Food or Drink success");
            readAndWrite.write(foodAndDrinks,"foodanddrink.csv");
        } else System.out.println("This food not exist!");
    }
}
