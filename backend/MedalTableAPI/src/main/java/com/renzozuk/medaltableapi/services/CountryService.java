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
    CountryDTO increaseCountryGold(String id);
    CountryDTO increaseCountryGoldByName(String name);
    CountryDTO decreaseCountryGold(String id);
    CountryDTO decreaseCountryGoldByName(String name);
    CountryDTO increaseCountrySilver(String id);
    CountryDTO increaseCountrySilverByName(String name);
    CountryDTO decreaseCountrySilver(String id);
    CountryDTO decreaseCountrySilverByName(String name);
    CountryDTO increaseCountryBronze(String id);
    CountryDTO increaseCountryBronzeByName(String name);
    CountryDTO decreaseCountryBronze(String id);
    CountryDTO decreaseCountryBronzeByName(String name);
    void deleteCountry(String id);
    void deleteCountryByName(String name);
}
