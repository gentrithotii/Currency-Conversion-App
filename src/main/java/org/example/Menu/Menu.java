package org.example.Menu;

import java.util.Scanner;

public class Menu {
    private Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
    }

    public void printOutMainMenu() {
        while (true) {
            System.out.println("Currency Converter App");

            System.out.println(" ");

            System.out.println("1. Convert SEK to USD");
            System.out.println("2. Convert USD to SEK");
            System.out.println("3. Convert SEK to Euro");
            System.out.println("4. Convert Euro to SEK");
            System.out.println("0. Exit");

            System.out.println(" ");

            System.out.print("Enter your choice: ");
            int menuChoice = sc.nextInt();
            sc.nextLine();

            switch (menuChoice) {
                case 1:
                    System.out.println("Convert sek to usd");
                    continue;
                case 2:
                    System.out.println("Usd to Sek");
                    continue;
                case 3:
                    System.out.println("SEK to Euro");
                    continue;
                case 4:
                    System.out.println("Euro to SEK");
                    continue;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Wrong menu choice");
                    continue;
            }
            break;
        }
    }
}
