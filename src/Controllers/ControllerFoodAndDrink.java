package Controllers;

import Services.FoodAndDrinkService;
import View.FoodAndDrinkView;

public class ControllerFoodAndDrink {
    public FoodAndDrinkView foodAndDrinkView;
    public FoodAndDrinkService foodAndDrinkService;

    public ControllerFoodAndDrink() {
        foodAndDrinkView = new FoodAndDrinkView();
        foodAndDrinkService = new FoodAndDrinkService();
    }

    public void menuFoodAndDrink (){
        int choice = -1;
        while (choice != 5) {
            choice = foodAndDrinkView.menuFoodAndDrink();
            switch (choice){
                case 1:
                    foodAndDrinkService.addFoodAndDrink(foodAndDrinkService.createFoodAndDrink());
                    break;
                case 2:
                    foodAndDrinkService.editFoodAndDrink(foodAndDrinkService.findIndex());
                    break;
                case 3:
                    foodAndDrinkService.deleteFoodAndDrink(foodAndDrinkService.findIndex());
                    break;
                case 4:
                    foodAndDrinkService.displayFoodAndDrink();
                    break;
                case 5:
                    System.out.println("Exit!!");
                    break;
            }
        }
    }
}
