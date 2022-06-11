package Models;

import java.io.Serializable;

public class FoodAndDrink implements Serializable {
    private String id;
    private String name;
    private int amount;
    private float price;

    public FoodAndDrink() {
    }

    public FoodAndDrink(String id, String name, int amount, float price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FoodAndDrink{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

}
