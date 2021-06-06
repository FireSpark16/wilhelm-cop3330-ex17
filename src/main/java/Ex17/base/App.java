/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Xander Wilhelm
 */

package Ex17.base;

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        int weight = myApp.getWeight();
        int alco = myApp.getAlco();
        double abv = myApp.getAbv();
        System.out.println(abv);
        int hours = myApp.getHours();
        double ratio = (myApp.getGender()) ? 0.73 : 0.66;
        double BAC = myApp.calc(weight,alco,hours,ratio, abv);
        myApp.output(BAC);
    }

    // This is set to output 3 decimals
    private void output(double BAC) {
        System.out.println("Your BAC is " + String.format("%.3f", BAC));
        if(BAC > 0.08)
            System.out.println("It is not legal for you to drive.");
        else
            System.out.println("It is legal for you to drive.");
    }

    private double calc(int weight, int alco, int hours, double ratio, double abv) {
        System.out.println(weight + " " + alco + " " + hours + " " + ratio + " " + abv);
        System.out.println((alco * abv * 5.14));
        System.out.println((weight * ratio));
        System.out.println((0.15 * hours));

        return ((alco * abv * 5.14) / (weight * ratio)) - (0.015 * hours);
    }

    private boolean getGender() {
        System.out.print("Input 1 for male and 2 for female: ");
        int i = 0;
        boolean retVal = true;
        while (i == 0)
        {
            try {
                i = Integer.parseInt(in.nextLine());
                if(i == 1)
                    retVal = true;
                else if(i == 2)
                    retVal = false;
                else
                {
                    i = 0;
                    System.out.println("Please input 1 or 2.");
                }
            } catch (NumberFormatException e) {
                i = 0;
                System.out.println("Please only input numbers.");
            }
        }
        return retVal;
    }

    private int getWeight() {
        System.out.print("What is your Weight (lbs)? ");
        int i = 0;
        while (i == 0)
        {
            try {
                i = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                i = 0;
                System.out.println("Please only input numbers.");
            }
        }
        return i;
    }

    private double getAbv() {
        System.out.print("What was the abv of the drink(s)? ");
        double i = 0;
        double retVal = 0.0;
        while (i == 0)
        {
            try {
                i = Integer.parseInt(in.nextLine());
                retVal = i / 100;
            } catch (NumberFormatException e) {
                i = 0;
                System.out.println("Please only input numbers.");
            }
        }
        return retVal;
    }

    private int getAlco() {
        System.out.print("How much did you drink (oz)? ");
        int i = 0;
        while (i == 0)
        {
            try {
                i = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                i = 0;
                System.out.println("Please only input numbers.");
            }
        }
        return i;
    }

    private int getHours() {
        System.out.print("How many full hours has it been since your last drink? ");
        int i = 0;
        while (i == 0)
        {
            try {
                i = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                i = 0;
                System.out.println("Please only input numbers.");
            }
        }
        return i;
    }
}
