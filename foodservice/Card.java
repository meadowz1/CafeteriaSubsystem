package foodservice;

public class Card {
    // Constructors
    String password;
    double credit;
    double points;
    String username;

    private int ID;
    private static int cardAmount = 0;

    public Card() {
        this.credit = 0;
        this.points = 0;
        this.ID = cardAmount + 1;
        cardAmount++;
    }

    // Getters and Setters

    public static int getCardAmount() {
        return cardAmount;
    }

    public double getCredit() {
        return credit;
    }

    public double getPoints() {
        return points;
    }

    public void setCredit(double credits) {
        this.credit = credits;
    }

    public void setPoints(double point) {
        this.points = point;
    }

    // Override operation

    @Override
    public String toString() {
        String output = "ID #: " + ID + "\nCredits: " + credit + "\nPoints: " + points;
        return output;
    }

}
