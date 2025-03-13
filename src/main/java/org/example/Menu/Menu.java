package org.example.Menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.MessageFormat;

import static org.example.Currency.CurrencyHelper.*;

public class Menu {
    private final Scanner sc;
    private boolean loopExit = false;

    public Menu() {
        sc = new Scanner(System.in);
    }

    private void printExchangeRate() {
        System.out.println(" ");
        System.out.println("Currency Converter App");
        System.out.println("The exchange rate for SEK to USD is : " + EXCHANGE_SEK_TO_USD);
        System.out.println("The exchange rate for USD to SEK is: " + EXCHANGE_USD_TO_SEK);
        System.out.println("The exchange rate for SEK to EURO is: " + EXCHANGE_SEK_TO_EURO);
        System.out.println("The exchange rate for Euro to SEK is: " + EXCHANGE_EURO_TO_SEK);
        System.out.println(" ");
    }

    public void startCurrencyConversionApp() {
        while (!loopExit) {
            printExchangeRate();
            printChoiceMenu();
            exchangeCalculations();
        }
    }

    private void printChoiceMenu() {
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert USD to SEK");
        System.out.println("3. Convert SEK to Euro");
        System.out.println("4. Convert Euro to SEK");
        System.out.println("0. Exit");
        System.out.println(" ");
    }

    private int userChoice() {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                return sc.nextInt();

            } catch (Exception e) {
                System.out.println("Enter a valid number for the menu");
                sc.next();
            }
        }
    }

    private double amountToAdd() {
        while (true) {
            try {
                System.out.print("Enter the amount you want to convert: ");
                double userInput = sc.nextDouble();

                if (userInput <= 0) {

                    System.out.println("Enter a valid number");

                } else {

                    return userInput;
                }

            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number");
                sc.next();

            }
        }
    }

    private void printResult(double userValue, double result, String fromCurrency, String toCurrency) {
        System.out.println(" ");
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu  HH:mm:ss ");
        String formatedDateTime = dateTime.format(formatter);
        System.out.println(MessageFormat.format("{0} {1} is {2} {3} at date of {4}", userValue, fromCurrency, result, toCurrency, formatedDateTime));
    }


    private void exchangeCalculations() {
        double result = 0, userValue = 0;
        String fromCurrency = " ", toCurrency = " ";

        int menuChoice = userChoice();

        switch (menuChoice) {
            case 1:
                fromCurrency = "SEK";
                toCurrency = "USD";
                userValue = amountToAdd();
                result = calculateExchangeSekToUsd(userValue);
                break;

            case 2:
                fromCurrency = "USD";
                toCurrency = "SEK";
                userValue = amountToAdd();
                result = calculateExchangeUsdToSek(userValue);
                break;
            case 3:
                fromCurrency = "SEK";
                toCurrency = "Euro";
                userValue = amountToAdd();
                result = calculateExchangeSekToEuro(userValue);
                break;
            case 4:
                fromCurrency = "Euro";
                toCurrency = "SEK";
                userValue = amountToAdd();
                result = calculateExchangeEuroToSek(userValue);
                break;
            case 0:
                loopExit = true;
                break;
            default:
                System.out.println("Wrong menu choice");
        }

        if (menuChoice == 0) {
            System.out.println("Bye have a great time ");
        } else {
            printResult(userValue, result, fromCurrency, toCurrency);
        }
    }
}
