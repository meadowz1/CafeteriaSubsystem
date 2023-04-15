package foodservice;

import java.util.ArrayList;

public class FoodDistributor {
    Card card;
    ArrayList<Food> foodItems = new ArrayList<Food>();

    public int getCurrentVariety() {
        return foodItems.size();
    }

    public String getFoodName(int index) {
        Food food = foodItems.get(index);
        String foodName = food.getFood();
        return foodName;
    }

    public int getCurrentStock(String foodName) {
        for (int i = 0; i < foodItems.size(); i++) {
            Food foodItem = foodItems.get(i);
            String foodName1 = foodItem.getFood();
            if (foodName1.equals(foodName)) {
                return foodItem.getStock();
            }
        }
        return 0;
    }

    public Food getFoodInfo(String foodName) {
        for (int i = 0; i < foodItems.size(); i++) {
            Food foodItem = foodItems.get(i);
            String foodName1 = foodItem.getFood();
            if (foodName1.equals(foodName)) {
                return foodItem;
            }
        }
        return null;
    }

    public void setFood(Food food) {
        foodItems.add(food);
    }

    public void listFoodItems() {
        for (int i = 0; i < 10; i++) {
            System.out.println(foodItems.get(i));
        }
    }

      public void itemPurchased(Food item) {
        int oldStock = item.getStock();
        oldStock--;
        item.setStock(oldStock);
    }

    public void pointsAwarded(Food item, Card card) {
        int pointsGiving = item.getPointsAwarded();
        double currentPoints = card.getPoints();
        double pointsTotal = currentPoints + pointsGiving;
        card.setPoints(pointsTotal);
        System.out.println("You've been awarded " + pointsGiving + " points for your order. Your new points balance is "
                + pointsTotal + " points.");
    }

    public void purchaseItem(String foodName, Card card)  {
    Food foodBuying = null;
    for (int i = 0; i < 10; i++) {
      String food = getFoodName(i);
      if (food.contains(foodName)) {
        Food foodBought = foodItems.get(i);
        foodBuying = foodBought;
        i = 10;
      }
      else {
        Food foodBought = null;
        foodBuying = foodBought;
      }
      
    }
    
    if (foodBuying == null) {
        System.out.println("Sorry, this food item is not available.");
    } else if (getCurrentStock(foodName) < 1) {
        System.out.println("Sorry, we are out of stock.");
    } else if (isBalanceEnough(foodBuying.getPrice(), card.getCredit())) {
        double newBalance = card.getCredit() - foodBuying.getPrice();
        card.setCredit(newBalance);
        itemPurchased(foodBuying);
        pointsAwarded(foodBuying, card);
        System.out.println("Thank you for your purchase of " + foodBuying.getFood() + ". Your new balance is " + newBalance + ".");
    } else {
        System.out.println("Sorry, you do not have enough credit to purchase this item.");
    }
}


    public Food getFoodItem(String foodName) {
        for (int i = 0; i < foodItems.size(); i++) {
            Food foodItem = foodItems.get(i);
            String foodName1 = foodItem.getFood();
            if (foodName1.equals(foodName)) {
                return foodItem;
            }
        }
        return null;
    }

    public boolean isBalanceEnough(double foodCost, double currentCredit) {
        if (foodCost <= currentCredit) {
            return true;
        } else {
            return false;
        }
    }
}
