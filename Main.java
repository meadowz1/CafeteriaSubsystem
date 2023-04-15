import foodservice.*;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int close = 3;

    Card c1 = new Card();
    Card c2 = new Card();
    Card c3 = new Card();
    Card c4 = new Card();

    cardSetup(c1, 10, 10);
    cardSetup(c2, 20, 20);
    cardSetup(c3, 30, 30);
    cardSetup(c4, 40, 40);

    Terminal t1 = new Terminal();

    FoodDistributor f1 = new FoodDistributor();

    addFoods(f1, 10);

    while (close == 3) {
      Scanner keyboard = new Scanner(System.in);

      System.out.println("----- Food Court Mississauga Secondary School -----");
      System.out.println(
          "\n Welcome to the MSS Food Court. Please enter the number shown on the left to visit that location.");
      System.out.println("\n1. Terminal\n2. Food Distributors\n3. Exit");

      int result = keyboard.nextInt();
      addFoods(f1, 100);
      if (result == 1) {
        terminal(t1, c1, c2, c3, c4);
      } else if (result == 2) {
        FoodDistributor(t1, f1, c1, c2, c3, c4);
      } else if (result == 69) {
        System.out.println("hehe funny number");
      } else {
        close = 4;
      }
    }
  }

  public static int FoodDistributor(Terminal terminal, FoodDistributor foodDis, Card c1, Card c2, Card c3, Card c4) {
    int result;
    Scanner keyboard = new Scanner(System.in);
    addFoods(foodDis, 100);

    System.out.println("----- Food Distributor -----");
    System.out.println("\n Welcome to the Food Distributor. Select an option from below.");
    System.out.println("\n1. View menu. \n2. Purchase an item. \n3. Exit.");
    result = keyboard.nextInt();
    if (result == 1) {
      System.out.println("\n --- Menu --- ");
      foodDis.listFoodItems();
    } else if (result == 2) {
      System.out.println(" --- Purchasing Food ---");
      System.out.println("\nPlease enter what you would like to purchase, as exactly shown on the menu.");
      String foodName = keyboard.next();

      System.out.println("\nWhich card would you like to purchase with? (1, 2, 3, 4)");
      String cardInt = keyboard.next();
      Card card = c1;
      if (cardInt.equals("1")) {
        card = c1;
      }

      else if (cardInt.equals("2")) {
        card = c2;
      }

      else if (cardInt.equals("2")) {
        card = c3;
      }

      else if (cardInt.equals("2")) {
        card = c4;
      }

      else {
        card = c4;
      }

      foodDis.purchaseItem(foodName, card);
    }

    return result;
  }

  public static int terminal(Terminal terminal, Card c1, Card c2, Card c3, Card c4) {
    Scanner keyboard = new Scanner(System.in);
      System.out.println("----- Terminal -----");
      System.out.println("\n   Welcome to the terminal.\n   Pick an option and enter the number below.");
      System.out.println(
          "\n1. Exchange credits within 2 cards. \n2. Top up on credits. \n3. Trade credits for points. \n4. Trade points for credits. \n5. Check card information. \n6. Exit to food court.");
      int result = keyboard.nextInt();

      if (result == 1) {
        System.out.println("\nWhich card would you like to take from? (c1, c2, c3, c4)");
        String cardString = keyboard.next();
        Card card1 = cardIdentifier(cardString, c1, c2, c3, c4);

        System.out.println("\nWhich card would you like to deposit into? (c1, c2, c3, c4)");
        String card2String = keyboard.next();
        Card card2 = cardIdentifier(card2String, c1, c2, c3, c4);

        System.out.println("\nHow many credits would you like to trade over?");
        int creditsTrading = keyboard.nextInt();

        terminal.tradeCredits(creditsTrading, card1, card2);
      } else if (result == 2) {
        System.out.println("\nWhich card would you like to top up credits for? (c1, c2, c3, c4)");
        String cardTopUp = keyboard.next();

        System.out.println("\nHow many credits would you like to top up on? (4 credits = $1)");
        int creditTopUp = keyboard.nextInt();
        System.out.println("\nThank you for paying! \nProcessing transaction...");

        Card card = cardIdentifier(cardTopUp, c1, c2, c3, c4);
        double newCredits = card.getCredit() + creditTopUp;
        card.setCredit(newCredits);
        System.out
            .println("\nThank you for waiting! Your new balance for your card is " + newCredits
                + " credits.");
      } else if (result == 3) {
        System.out.println("\nWhich card would you like to trade your credits to points for? (c1, c2, c3, c4)");
        String cardTopUp = keyboard.next();

        System.out.println("\nHow many credits would you like to trade in? (1 credit = 3 points)");
        int creditTrade = keyboard.nextInt();
        System.out.println("\nThank you for paying! \nProcessing transaction...");

        Card card = cardIdentifier(cardTopUp, c1, c2, c3, c4);
        terminal.setCard1(card);
        terminal.creditsToPointsCard1(creditTrade);
        System.out.println(
            "\nThank you for waiting!\nCredits: " + card.getCredit() + "\nPoints: " + card.getPoints());
      } else if (result == 4) {
        System.out.println("\nWhich card would you like to trade your points to credits for? (c1, c2, c3, c4)");
        String cardTopUp = keyboard.next();

        System.out.println("\nHow many points would you like to trade in? (1 credit = 4 points)");
        int creditTrade = keyboard.nextInt();
        System.out.println("\nThank you for paying! \nProcessing transaction...");

        Card card = cardIdentifier(cardTopUp, c1, c2, c3, c4);
        terminal.setCard1(card);
        terminal.pointsToCreditsCard1(creditTrade);
        System.out.println(
            "\nThank you for waiting!\nCredits: " + card.getCredit() + "\nPoints: " + card.getPoints());
      } else if (result == 5) {
        System.out.println("\nWhich card would you like to check? (c1, c2, c3, c4)");
        String cardTopUp = keyboard.next();

        Card card = cardIdentifier(cardTopUp, c1, c2, c3, c4);
        System.out.println("\n" + card);
      } else {
        result = 3;
      }

      return result;
    }
  

  public static Card cardIdentifier(String cardName, Card c1, Card c2, Card c3, Card c4) {
    Card card = null;
    if (cardName.equals("c1")) {
      card = c1;
    } else if (cardName.equals("c2")) {
      card = c2;
    } else if (cardName.equals("c3")) {
      card = c3;
    } else if (cardName.equals("c4")) {
      card = c4;
    } else {
      card = c1;
    }

    return card;

  }

  public static int startScreen() {

    return 1;
  }

  public static void cardSetup(Card card, int creditStart, int pointStart) {
    card.setCredit(creditStart);
    card.setPoints(pointStart);
  }

  public static void addFoods(FoodDistributor machine, int startingStock) {
    Food sandwich = new Food();
    Food water = new Food();
    Food butterChicken = new Food();
    Food rice = new Food();
    Food hamburger = new Food();
    Food pizza = new Food();
    Food garlicBread = new Food();
    Food naans = new Food();
    Food caesarSalad = new Food();
    Food coke = new Food();

    // Sandwich
    sandwich.setFood("Sandwich");
    sandwich.setPrice(20);
    sandwich.setIngredients("Bread, Lettuce, Tomatoes, Mayonaise.");
    sandwich.setCalories(350);
    sandwich.setPointsAwarded(20);
    sandwich.setStock(startingStock);
    machine.setFood(sandwich);

    // Water
    water.setFood("Water Bottle");
    water.setPrice(3);
    water.setIngredients("500ml of water. Quite simple.");
    water.setCalories(0);
    water.setPointsAwarded(3);
    water.setStock(startingStock);
    machine.setFood(water);

    // Butter Chicken
    butterChicken.setFood("Bowl of Butter Chicken");
    butterChicken.setPrice(30);
    butterChicken.setIngredients("Tomatoes, Turmeric, Chilli Powder, Cashews, and Cream.");
    butterChicken.setCalories(250);
    butterChicken.setPointsAwarded(30);
    butterChicken.setStock(startingStock);
    machine.setFood(butterChicken);

    // Rice
    rice.setFood("Bowl of Rice");
    rice.setPrice(10);
    rice.setIngredients("A boiled bowl of Basmati rice.");
    rice.setCalories(200);
    rice.setPointsAwarded(10);
    rice.setStock(startingStock);
    machine.setFood(rice);

    // Hamburger
    hamburger.setFood("Hamburger");
    hamburger.setPrice(25);
    hamburger.setIngredients("2 Slices of bread, a slice of cheese, and a beef patty.");
    hamburger.setCalories(300);
    hamburger.setPointsAwarded(25);
    hamburger.setStock(startingStock);
    machine.setFood(hamburger);

    // Pizza
    pizza.setFood("Personal-sized Cheese Pizza");
    pizza.setPrice(30);
    pizza.setIngredients("Cooked dough, tomatoes, oregano, and cheese. Quite the simple combo.");
    pizza.setCalories(600);
    pizza.setPointsAwarded(30);
    pizza.setStock(startingStock);
    machine.setFood(pizza);

    // Garlic Bread
    garlicBread.setFood("Slice of Garlic Bread");
    garlicBread.setPrice(12);
    garlicBread.setIngredients("Bread cooked in roasted garlic.");
    garlicBread.setCalories(200);
    garlicBread.setPointsAwarded(12);
    garlicBread.setStock(startingStock);
    machine.setFood(garlicBread);

    // Naans
    naans.setFood("1 Naan");
    naans.setPrice(4);
    naans.setIngredients("Oven-toasted flatbread that goes great with curries.");
    naans.setCalories(100);
    naans.setPointsAwarded(4);
    naans.setStock(startingStock);
    machine.setFood(naans);

    // Caesar Salad
    caesarSalad.setFood("Bowl of Caesar Salad");
    caesarSalad.setPrice(10);
    caesarSalad.setIngredients("Lettuce, Caesar dressing, croutons, parmesan cheese, and black pepper.");
    caesarSalad.setCalories(50);
    caesarSalad.setPointsAwarded(10);
    caesarSalad.setStock(startingStock);
    machine.setFood(caesarSalad);

    // Coke
    coke.setFood("Coke bottle");
    coke.setPrice(3);
    coke.setIngredients("500ml of Coke. Caffienne included.");
    coke.setCalories(150);
    coke.setPointsAwarded(3);
    coke.setStock(startingStock);
    machine.setFood(coke);

  }

}
