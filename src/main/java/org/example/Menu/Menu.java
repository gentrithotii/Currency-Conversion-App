package org.example.Menu;

import org.example.Currency.ExchangeRateCurrency;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.MessageFormat;

import static org.example.Currency.CurrencyHelper.*;

public class Menu {
    private final Scanner sc;
    private boolean loopExit = false;
    ExchangeRateCurrency exchangeRateCurrency;
    private boolean printResult = false;

    public Menu() {
        sc = new Scanner(System.in);
        exchangeRateCurrency = new ExchangeRateCurrency();
    }

    private void printExchangeRate() {
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
            if (printResult) {
                printResult(exchangeRateCurrency);
            }
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
                String input = sc.nextLine().trim();

                if (!input.matches("-?\\d+")) {
                    System.out.println("Enter a valid number for the menu");
                    continue;
                }

                return Integer.parseInt(input);
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

                    System.out.println("Enter a valid positive Numbers ");

                } else {
                    return userInput;
                }

            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number if EX: 2.5 or whole numbers EX: 1 and use Dot not Comma ");
                sc.next();

            }
        }
    }

    private void printResult(ExchangeRateCurrency exchangeRateCurrency) {
        System.out.println(" ");
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu  HH:mm:ss ");
        String formatedDateTime = dateTime.format(formatter);
        System.out.println(MessageFormat.format("{0} {1} is {2} {3} at date of {4}", exchangeRateCurrency.getAmount(), exchangeRateCurrency.getFromCurrency(), exchangeRateCurrency.getConvertedAmount(), exchangeRateCurrency.getToCurrency(), formatedDateTime));
        System.out.println(" ");
    }

    private void currencySetter(int numChoice) {
        if (numChoice == 1) {
            exchangeRateCurrency.setFromCurrency("SEK");
            exchangeRateCurrency.setToCurrency("USD");
        } else if (numChoice == 2) {
            exchangeRateCurrency.setFromCurrency("USD");
            exchangeRateCurrency.setToCurrency("SEK");

        } else if (numChoice == 3) {
            exchangeRateCurrency.setFromCurrency("SEK");
            exchangeRateCurrency.setToCurrency("Euro");
        } else {
            exchangeRateCurrency.setFromCurrency("Euro");
            exchangeRateCurrency.setToCurrency("SEK");
        }
    }

    private void exchangeCalculations() {
        double userAmount;

        int menuChoice = userChoice();

        switch (menuChoice) {
            case 1:
                currencySetter(menuChoice);
                userAmount = amountToAdd();
                exchangeRateCurrency.setAmount(userAmount);
                exchangeRateCurrency.setConvertedAmount(calculateExchangeSekToUsd(userAmount));
                break;

            case 2:
                currencySetter(menuChoice);
                userAmount = amountToAdd();
                exchangeRateCurrency.setAmount(userAmount);
                exchangeRateCurrency.setConvertedAmount(calculateExchangeUsdToSek(userAmount));
                break;
            case 3:
                currencySetter(menuChoice);
                userAmount = amountToAdd();
                exchangeRateCurrency.setAmount(userAmount);
                exchangeRateCurrency.setConvertedAmount(calculateExchangeSekToEuro(userAmount));
                break;
            case 4:
                currencySetter(menuChoice);
                userAmount = amountToAdd();
                exchangeRateCurrency.setAmount(userAmount);
                exchangeRateCurrency.setConvertedAmount(calculateExchangeEuroToSek(userAmount));
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
            printResult = true;
        }
    }
}
