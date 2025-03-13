package org.example.Menu;

import org.example.Currency.CurrencyHelper;

import java.util.Scanner;

import static org.example.Currency.CurrencyHelper.*;

public class Menu {
    private Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
    }

    private void printExchangeRate() {
        System.out.println("Currency Converter App");
        System.out.println("The exchange rate for SEK to USD is : " + EXCHANGE_SEK_TO_USD);
        System.out.println("The exchange rate for USD to SEK is: " + EXCHANGE_USD_TO_SEK);
        System.out.println("The exchange rate for SEK to EURO is: " + EXCHANGE_SEK_TO_EURO);
        System.out.println("The exchange rate for Euro to SEK is: " + EXCHANGE_EURO_TO_SEK);
    }

    public void startCurrencyConversionApp() {

    }

    private void printChoiceMenu() {
        System.out.println(" ");
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert USD to SEK");
        System.out.println("3. Convert SEK to Euro");
        System.out.println("4. Convert Euro to SEK");
        System.out.println("0. Exit");
        System.out.println(" ");
    }

    private int userChoice() {
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    public void exchangeCalculations(int menuChoice) {
        double result;

        switch (menuChoice) {
            case 1:
                result = calculateExchangeSekToUsd(1000);
                System.out.println(result);

            case 2:
                System.out.println("Usd to Sek");

            case 3:
                System.out.println("SEK to Euro");

            case 4:
                System.out.println("Euro to SEK");

            case 0:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Wrong menu choice");

        }

    }
}
