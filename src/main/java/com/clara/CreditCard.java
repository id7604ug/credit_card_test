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

//    public static boolean isValidCreditCard(String cc) {
//
//        //TODO Replace with your code to process the credit card number, and determine if it is valid.
//        //TODO Make sure all the tests pass!
//        boolean testBool = false;
//
//        return testBool;
//
//    }
    public static boolean isValidCreditCard(String cardNumber){
        // Booleans to check validity
        boolean checkDigit = false;
        boolean checkLength = false;
        boolean checkStartDigit = false;
        // Convert the card number to an array of characters
        char[] cardNumArray = cardNumber.toCharArray();
        // Create boolean to check if the current number should be doubled
        boolean doubleThis = true;
        //todo  Start digit check
        if (cardNumArray)
        // Length check
        if (cardNumArray.length == 16){
            checkLength = true;
        }
        // Number addition
        int cardNumberAdd = 0;
        for (char number : cardNumArray) {
            if (doubleThis){
                if (number * 2 > 9) {
                    cardNumberAdd += 1;
                    cardNumberAdd += (number * 2) - 10;
                    doubleThis = false;
                } else {
                    cardNumberAdd += number * 2;
                    doubleThis = true;
                }
            } else {
                cardNumberAdd += number;
            }
        }
        if (cardNumberAdd % 10 == 0){
            checkDigit = true;
        }

//        // Check if number is valid
//        if (checkDigit && checkLength && checkStartDigit){
//            return true;
//        } else {
//            return false;
//        }

    }



}
