package org.example.Currency;

public class CurrencyHelper {

    public static enum Currency {
        SEK, USD, Euro
    }

    public static final double EXCHANGE_SEK_TO_USD = 0.098;
    public static final double EXCHANGE_USD_TO_SEK = 10.16;
    public static final double EXCHANGE_SEK_TO_EURO = 0.091;
    public static final double EXCHANGE_EURO_TO_SEK = 11.04;

    public static double calculateExchangeSekToUsd(double amount) {
        return amount * EXCHANGE_SEK_TO_USD;
    }
}
