package com.renzozuk.medaltableapi.util;

import com.renzozuk.medaltableapi.entities.Country;

import static java.lang.Integer.compare;

public class CountryComparator {
    public static int compareByName(Country c1, Country c2) {
        return c1.getName().compareToIgnoreCase(c2.getName());
    }

    public static int compareByGoldMedals(Country c1, Country c2) {
        return c1.getGoldMedals() == c2.getGoldMedals() ? (c1.getSilverMedals() == c2.getSilverMedals() ? (c1.getBronzeMedals() == c2.getBronzeMedals() ? c1.getName().compareTo(c2.getName()) : compare(c2.getBronzeMedals(), c1.getBronzeMedals())) : compare(c2.getSilverMedals(), c1.getSilverMedals())) : compare(c2.getGoldMedals(), c1.getGoldMedals());
    }

    public static int compareByAllMedals(Country c1, Country c2) {
        return c1.getAllMedals() == c2.getAllMedals() ? (c1.getGoldMedals() == c2.getGoldMedals() ? (c1.getSilverMedals() == c2.getSilverMedals() ? c1.getName().compareTo(c2.getName()) : compare(c2.getSilverMedals(), c1.getSilverMedals())) : compare(c2.getGoldMedals(), c1.getGoldMedals())) : compare(c2.getAllMedals(), c1.getAllMedals());
    }
}
