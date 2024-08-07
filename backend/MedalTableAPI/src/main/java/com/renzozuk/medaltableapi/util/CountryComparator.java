package com.renzozuk.medaltableapi.util;

import com.renzozuk.medaltableapi.entities.Country;

import static java.lang.Integer.compare;

public class CountryComparator {
    public static int compareByGoldMedals(Country o1, Country o2) {
        return o1.getGoldMedals() == o2.getGoldMedals() ? (o1.getSilverMedals() == o2.getSilverMedals() ? (o1.getBronzeMedals() == o2.getBronzeMedals() ? o1.getName().compareTo(o2.getName()) : compare(o2.getBronzeMedals(), o1.getBronzeMedals())) : compare(o2.getSilverMedals(), o1.getSilverMedals())) : compare(o2.getGoldMedals(), o1.getGoldMedals());
    }

    public static int compareByGoldMedalsReversed(Country o1, Country o2) {
        return o1.getGoldMedals() == o2.getGoldMedals() ? (o1.getSilverMedals() == o2.getSilverMedals() ? compare(o1.getBronzeMedals(), o2.getBronzeMedals()) : compare(o1.getSilverMedals(), o2.getSilverMedals())) : compare(o1.getGoldMedals(), o2.getGoldMedals());
    }

    public static int compareByAllMedals(Country o1, Country o2) {
        return o1.getAllMedals() == o2.getAllMedals() ? (o1.getGoldMedals() == o2.getGoldMedals() ? (o1.getSilverMedals() == o2.getSilverMedals() ? o1.getName().compareTo(o2.getName()) : compare(o2.getSilverMedals(), o1.getSilverMedals())) : compare(o2.getGoldMedals(), o1.getGoldMedals())) : compare(o2.getAllMedals(), o1.getAllMedals());
    }

    public static int compareByAllMedalsReversed(Country o1, Country o2) {
        return o1.getAllMedals() == o2.getAllMedals() ? (o1.getGoldMedals() == o2.getGoldMedals() ? compare(o1.getSilverMedals(), o2.getSilverMedals()) : compare(o1.getGoldMedals(), o2.getGoldMedals())) : compare(o1.getAllMedals(), o2.getAllMedals());
    }
}
