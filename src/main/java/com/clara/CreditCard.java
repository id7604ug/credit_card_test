package com.clara;

import java.util.Scanner;

/**
 * Created by we4954cp on 8/31/2016.
 */
public class CreditCard {

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Ask user for credit card number. store number as a String.
        System.out.println("Please enter the credit card number, digits only:");
        String ccNumber = stringScanner.nextLine();
        boolean isValid = isValidCreditCard(ccNumber);

        if (isValid) {
            System.out.println("This seems to be a valid credit card number");
        } else {
            System.out.println("This is **not** a valid credit card number.");
        }

        stringScanner.close();
    }


    public static boolean isValidCreditCard(String cardNumber){
        // Booleans to check validity
        boolean checkDigit = false;
        boolean checkLength = false;
        boolean checkStartDigit = false;
        // Convert the card number to an array of characters
        char[] cardNumArray = cardNumber.toCharArray();
        // Create boolean to check if the current number should be doubled
        boolean doubleThis = true;
        // Start digit check
        if (cardNumArray[0] == '4'){
            checkStartDigit = true;
        }

        // Length check
        if (cardNumArray.length == 16){
            checkLength = true;
        }
        // Check digit check- Number addition
        int cardNumberAdd = 0;
        for (int currentNumber : cardNumArray) {
            // Create varaible to store the integer value of the current card number
            // Character.getNumericValue(char c) gets the value of the char
            // http://stackoverflow.com/questions/19388037/converting-characters-to-integers-in-java
            // http://docs.oracle.com/javase/7/docs/api/java/lang/Character.html#getNumericValue%28char%29
            int number = Character.getNumericValue(currentNumber);
            // Check if the current number should be doubled
            if (doubleThis){
                // Check if the doubled number is higher than 10
                if (number * 2 > 9) {
                    cardNumberAdd += 1;
                    cardNumberAdd += (number * 2) - 10;
                    doubleThis = false;
                } else {
                    cardNumberAdd += number * 2;
                    doubleThis = false;
                }
            } else {
                cardNumberAdd += number;
                doubleThis = true;
            }
        }
        if (cardNumberAdd % 10 == 0){
            checkDigit = true;
        }
        // Return the result of the calculations
        return (checkDigit && checkLength && checkStartDigit);


    }



}
