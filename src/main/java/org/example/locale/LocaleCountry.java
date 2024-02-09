package org.example.locale;

import java.util.Locale;

public class LocaleCountry {
    public static void main(String[] args) {
        Locale first_locale = new Locale("English", "US");
        System.out.println("Country: " + first_locale.getCountry());
    }
}
