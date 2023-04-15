package foodservice;

import java.util.ArrayList;

public class Terminal {
  final int DOLLARTOCREDIT = 4;
  final int POINTTOCREDIT = 3;
  int transactions;
  double income;
  Card card1;
  Card card2;
  ArrayList<String> transactionsHistory = new ArrayList<String>();

  // Getters
  public Card getCard1() {
    return card1;
  }

  public Card getCard2() {
    return card2;
  }

  public double getCreditsCard1() {
    return card1.getCredit();
  }

  public double getCreditsCard2() {
    return card2.getCredit();
  }

  public double getPointsCard1() {
    return card1.getPoints();
  }

  public double getPointsCard2() {
    return card2.getPoints();
  }

  // Setters
  public void setCard1(Card cardn1) {
    card1 = cardn1;
  }

  public void setCard2(Card cardn2) {
    card2 = cardn2;
  }

  public void setCard1Credits(double creditAmount) {
    card1.setCredit(creditAmount);
  }

  public void setCard2Credits(double creditAmount) {
    card2.setCredit(creditAmount);
  }

  public void setCard1Points(double pointAmount) {
    card1.setPoints(pointAmount);
  }

  public void setCard2Points(double pointAmount) {
    card2.setPoints(pointAmount);
  }

  // Operations

  /**
  tradeCredits()
  inputs: int, Card, Card
  output: void
  Description: A method that transfers points from the first card into the second.
  */
  public void tradeCredits(int tradingCredits, Card c1, Card c2) {
    double card1Credits = c1.getCredit();
    double card2Credits = c2.getCredit();

    if (card1Credits >= tradingCredits && card2Credits >= tradingCredits) {
      double newCredits1 = card1Credits + tradingCredits;
      double newCredits2 = card2Credits - tradingCredits;
      c1.setCredit(newCredits1);
      c2.setCredit(newCredits2);
      System.out.println("Trade Successful!");
    } else {
      System.out.println("You don't have enough credits to process this trade.");
    }

    double card11Credits = c1.getCredit();
    double card22Credits = c2.getCredit();

    String transaction = "Card 1 \nCredit: " + card11Credits + "\nCard 2 \n Credit: " + card22Credits;
    transactionAddition(transaction);
  }

  /**
  pointsToCreditsCard1()
  inputs: double
  output: void
  Description: Method that takes the points from card1 and makes it into credits.
  */
  public void pointsToCreditsCard1(double pointsTraded) {
    double currentPoints = card1.getPoints();
    double currentCredits = card1.getCredit();

    if (currentPoints < 0) {
      System.out.println("Sorry, you do not have enough points to trade in for credits.");
    }

    else {
      double creditsAdding = pointsTraded / POINTTOCREDIT;
      double newCredits = creditsAdding + currentCredits;
      double removedCredits = currentPoints - pointsTraded;
      card1.setCredit(newCredits);
      card1.setPoints(removedCredits);
      System.out.println(creditsAdding + " credits were added to your account.");
      transactionAddition("Card 1 \nCredits before: " + currentCredits + "\nCredits After: " + newCredits);
    }
  }

  /**
  pointsToCreditsCard2()
  inputs: double
  output: void
  Description: Method that takes the points from card2 and makes it into credits.
  */
  public void pointsToCreditsCard2(double pointsTraded) {
    double currentPoints = card2.getPoints();
    double currentCredits = card2.getCredit();

    if (currentPoints < 0) {
      System.out.println("Sorry, you do not have enough points to trade in for credits.");
    }

    else {
      double creditsAdding = pointsTraded / POINTTOCREDIT;
      double newCredits = creditsAdding + currentCredits;
      double removedCredits = currentPoints - pointsTraded;
      card2.setCredit(newCredits);
      card2.setPoints(removedCredits);
      System.out.println(creditsAdding + " credits were added to your account.");
      transactionAddition("Card 2 \nCredits before: " + currentCredits + "\nCredits After: " + newCredits);
    }
  }

  /**
  creditsToPointsCard1()
  inputs: double
  output: void
  Description: Method that takes the credits from card1 and makes it into points.
  */
  public void creditsToPointsCard1(double creditsTraded) {
    double currentPoints = card1.getPoints();
    double currentCredits = card1.getCredit();

    if (currentCredits < 0) {
      System.out.println("Sorry, you do not have enough credits to trade in for points.");
    }

    else {
      double pointsAdding = creditsTraded * POINTTOCREDIT;
      double newPoints = pointsAdding + currentPoints;
      double removedCredits = currentCredits - creditsTraded;
      card1.setPoints(newPoints);
      card1.setCredit(removedCredits);
      System.out
          .println(pointsAdding + " points were added to your account. \nYour new balance is : " + newPoints);
      transactionAddition("Card 1 \nPoints before: " + currentPoints + "\nPoints After: " + newPoints);
    }
  }

  /**
  creditsToPointsCard2()
  inputs: double
  output: void
  Description: Method that takes the credits from card2 and makes it into points.
  */
  public void creditsToPointsCard2(double creditsTraded) {
    double currentPoints = card2.getPoints();
    double currentCredits = card2.getCredit();

    if (currentCredits < 0) {
      System.out.println("Sorry, you do not have enough credits to trade in for points.");
    }

    else {
      double pointsAdding = creditsTraded * POINTTOCREDIT;
      double newPoints = pointsAdding + currentPoints;
      double removedCredits = currentCredits - creditsTraded;
      card2.setPoints(newPoints);
      card2.setCredit(removedCredits);
      System.out
          .println(pointsAdding + " points were added to your account. \nYour new balance is : " + newPoints);
      transactionAddition("Card 2 \nPoints before: " + currentPoints + "\nPoints After: " + newPoints);
    }
  }

  /**
  
  inputs:
  outputs:
  Description: 
  */
  public void addCreditsCard1(double money) {
    double currentCredits = card1.getCredit();
    double newCredits = money * 4;
    double newNewCredits = currentCredits + newCredits;
    card1.setCredit(newNewCredits);
    transactionAddition("Card 1 \nCredits before: " + currentCredits + "\nCredits After: " + newNewCredits);
  }

  public void addCreditsCard2(double money) {
    double currentCredits = card2.getCredit();
    double newCredits = money * 4;
    double newNewCredits = currentCredits + newCredits;
    card2.setCredit(newNewCredits);
    transactionAddition("Card 2 \nCredits before: " + currentCredits + "\nCredits After: " + newNewCredits);
  }

  public void transactionAddition(String transactionMade) {
    transactionsHistory.add(transactionMade);
    transactions++;
  }

  public void viewTransaction(int transactionNumber) {
    if (transactionNumber > transactions) {
      System.out.println("This transaction does not exist.");
    } else {
      System.out.println(transactionsHistory.get(transactionNumber - 1));
    }
  }
}
