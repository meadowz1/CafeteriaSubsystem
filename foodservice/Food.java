package foodservice;

public class Food {
    public String name;
    public int calories;
    public int stock;
    public double price;
    public int pointsAwarded;
    public String ingredients;

    public Food() {
        this.name = "Food";
        this.calories = 0;
        this.stock = 0;
        this.price = 0.0;
        this.pointsAwarded = 0;
        this.ingredients = "Air";
    }

    public String getFood() {
        return this.name;
    }

    public int getCalories() {
        return calories;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public int getPointsAwarded() {
        return pointsAwarded;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setFood(String foodName) {
        this.name = foodName;
    }

    public void setCalories(int calorieCount) {
        if (calorieCount >= 0) {
            this.calories = calorieCount;
        }
    }

    public void setStock(int stockAmount) {
        if (stockAmount >= 0) {
            stock = stockAmount;
        }
    }

    public void setPrice(double cost) {
        if (cost >= 0.0) {
            this.price = cost;
        }
    }

    public void setPointsAwarded(int pointsAwarding) {
        if (pointsAwarding >= 0) {
            this.pointsAwarded = pointsAwarding;
        }
    }

    public void setIngredients(String newIngredients) {
        this.ingredients = newIngredients;
    }

    @Override
    public String toString() {
        String info = "\nFood: " + name + "\nCost: " + price + " Credits\nStock: " + stock + "\nPoints Awarded: "
                + pointsAwarded + "\nIngredients: " + ingredients + "\n";
        return info;
    }
}
