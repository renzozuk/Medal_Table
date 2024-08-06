package com.renzozuk.medaltableapi.services;

import com.renzozuk.medaltableapi.dto.CountryDTO;

import java.util.List;

public interface CountryService {
    CountryDTO createCountry(CountryDTO countryDTO);
    List<CountryDTO> getAllCountries();
    List<CountryDTO> getAllCountriesReversed();
    List<CountryDTO> getAllCountriesByGoldMedals();
    List<CountryDTO> getAllCountriesByGoldMedalsReversed();
    List<CountryDTO> getAllCountriesByAllMedals();
    List<CountryDTO> getAllCountriesByAllMedalsReversed();
    CountryDTO getCountryById(String id);
    CountryDTO getCountryByName(String name);
    CountryDTO updateCountry(CountryDTO countryDTO, String id);
    CountryDTO updateCountryByName(CountryDTO countryDTO, String name);
    void deleteCountry(String id);
    void deleteCountryByName(String name);
}
