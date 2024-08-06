package com.renzozuk.medaltableapi.util;

import com.renzozuk.medaltableapi.dto.CountryDTO;
import com.renzozuk.medaltableapi.entities.Country;

public class CountryConverter {
    public static CountryDTO mapToDTO(Country country) {
        return new CountryDTO(country.getId(), country.getName(), country.getPhotoPath(), country.getGoldMedals(), country.getSilverMedals(), country.getBronzeMedals());
    }

    public static Country mapToEntity(CountryDTO countryDTO) {
        return new Country(countryDTO.getId(),
                countryDTO.getName(),
                countryDTO.getPhotoPath(),
                countryDTO.getGoldMedals() != null ? (countryDTO.getGoldMedals() < 0 ? 0 : countryDTO.getGoldMedals()) : 0,
                countryDTO.getSilverMedals() != null ? (countryDTO.getSilverMedals() < 0 ? 0 : countryDTO.getSilverMedals()) : 0,
                countryDTO.getBronzeMedals() != null ? (countryDTO.getBronzeMedals() < 0 ? 0 : countryDTO.getBronzeMedals()) : 0);
    }
}
