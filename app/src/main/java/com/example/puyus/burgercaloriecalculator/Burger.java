package com.example.puyus.burgercaloriecalculator;

/**
 * Created by puyush on 9/13/2016.
 */
public class Burger {

    //Bun Prices
    double bunPrice = 1;
    //Meat Prices
    double[] meatPrices = {5.5, 5, 5, 7.5, 4.5};
    //Topping Prices
    double[] topPrices = {1, .30, .30, .50, 0, 0};

    //Calories
    double[] bunCals = {140, 100};
    double[] meatCals = {240, 180, 190, 95, 80};
    double[] topCals = {60, 20, 20, 30, 100, 60};

    double bunCal = 0;
    double meatPrice = 0;
    double meatCal = 0;
    double totalTopPrice = 0;
    double totalTopCal = 0;
    double userInput = 0;
    public  void setUserInput(double userInput) {
        this.userInput = userInput;
    }
    public void setBun(int pos) {
        bunCal = bunCals[pos];
    }
    public void setMeat(int pos) {
        meatPrice = meatPrices[pos];
        meatCal = meatCals[pos];
    }
    public void setTop(int pos) {
        totalTopPrice += topPrices[pos];
        totalTopCal += topCals[pos];
    }
    public double getMeatPrice() {
        return meatPrice;
    }
    public double getMeatCal() {
        return meatCal;
    }
    public double getBunPrice() {
        return bunPrice;
    }
    public double getBunCal() {
        return bunCal;
    }
    public double getUserInput() {
        return userInput;
    }
    public double getTotalTopPrice() {
        return totalTopPrice;
    }
    public double getTotalTopCal() {
        return totalTopCal;
    }
    public void clearTop() {
        totalTopCal = 0;
        totalTopPrice = 0;
    }

}
