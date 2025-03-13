package org.example;

import org.example.Currency.CurrencyHelper;
import org.example.Currency.Money;
import org.example.Menu.Menu;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.exchangeCalculations(1);

        Money cashBror = new Money(1000, CurrencyHelper.Currency.USD);
        System.out.println(cashBror.getCurrency());

    }
}