package com.renzozuk.medaltableapi.services;

import com.renzozuk.medaltableapi.dto.CountryDTO;
import com.renzozuk.medaltableapi.entities.Country;
import com.renzozuk.medaltableapi.exceptions.DatabaseException;
import com.renzozuk.medaltableapi.exceptions.ResourceNotFoundException;
import com.renzozuk.medaltableapi.repositories.CountryRepository;
import com.renzozuk.medaltableapi.util.CountryComparator;
import com.renzozuk.medaltableapi.util.CountryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.renzozuk.medaltableapi.util.CountryConverter.mapToDTO;
import static com.renzozuk.medaltableapi.util.CountryConverter.mapToEntity;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryDTO> getAllCountriesShuffled() {
        return countryRepository.findAll().stream().map(CountryConverter::mapToDTO).collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
            Collections.shuffle(collected);
            return collected;
        }));
    }

    public List<CountryDTO> getAllCountriesAlphabetically() {
        return countryRepository.findAll().stream().map(CountryConverter::mapToDTO).sorted(Comparator.comparing(CountryDTO::getName)).toList();
    }

    public List<CountryDTO> getAllCountriesAlphabeticallyReversed() {
        return countryRepository.findAll().stream().map(CountryConverter::mapToDTO).sorted(Comparator.comparing(CountryDTO::getName)).toList().reversed();
    }

    public List<CountryDTO> getAllCountriesByGoldMedals() {
        return countryRepository.findAll().stream().sorted(CountryComparator::compareByGoldMedals).map(CountryConverter::mapToDTO).toList();
    }

    public List<CountryDTO> getAllCountriesByGoldMedalsReversed() {
        return countryRepository.findAll().stream().sorted(CountryComparator::compareByGoldMedalsReversed).map(CountryConverter::mapToDTO).toList();
    }

    public List<CountryDTO> getAllCountriesByAllMedals() {
        return countryRepository.findAll().stream().sorted(CountryComparator::compareByAllMedals).map(CountryConverter::mapToDTO).toList();
    }

    public List<CountryDTO> getAllCountriesByAllMedalsReversed() {
        return countryRepository.findAll().stream().sorted(CountryComparator::compareByAllMedalsReversed).map(CountryConverter::mapToDTO).toList();
    }

    public CountryDTO getCountryById(String id) {
        return mapToDTO(countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class)));
    }

    public CountryDTO getCountryByName(String name) {
        try{
            return mapToDTO(countryRepository.findByName(name));
        }catch(NullPointerException e){
            throw new ResourceNotFoundException(Country.class);
        }
    }

    public CountryDTO createCountry(CountryDTO countryDTO) {
        try{
            Country country = mapToEntity(countryDTO);

            Country createdCountry = countryRepository.save(country);

            return mapToDTO(createdCountry);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public CountryDTO updateCountry(CountryDTO countryDTO, String id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class));

        return updateCountryData(countryDTO, country);
    }

    public CountryDTO updateCountryByName(CountryDTO countryDTO, String name) {
        try{
            Country country = countryRepository.findByName(name);

            return updateCountryData(countryDTO, country);
        }catch(NullPointerException e){
            throw new ResourceNotFoundException(Country.class);
        }
    }

    private CountryDTO updateCountryData(CountryDTO countryDTO, Country country) {
        country.setName(countryDTO.getName());
        country.setPhotoPath(countryDTO.getPhotoPath());
        country.setGoldMedals(countryDTO.getGoldMedals() < 0 ? 0 : countryDTO.getGoldMedals());
        country.setSilverMedals(countryDTO.getSilverMedals() < 0 ? 0 : countryDTO.getSilverMedals());
        country.setBronzeMedals(countryDTO.getBronzeMedals() < 0 ? 0 : countryDTO.getBronzeMedals());

        return mapToDTO(countryRepository.save(country));
    }

    public CountryDTO patchCountry(CountryDTO countryDTO, String id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class));

        return patchCountryData(countryDTO, country);
    }

    public CountryDTO patchCountryByName(CountryDTO countryDTO, String name) {
        try{
            Country country = countryRepository.findByName(name);

            return patchCountryData(countryDTO, country);
        }catch(NullPointerException e){
            throw new ResourceNotFoundException(Country.class);
        }
    }

    private CountryDTO patchCountryData(CountryDTO countryDTO, Country country) {
        if(countryDTO.getName() != null){
            country.setName(countryDTO.getName());
        }

        if(countryDTO.getPhotoPath() != null){
            country.setPhotoPath(countryDTO.getPhotoPath());
        }

        if(countryDTO.getGoldMedals() != null){
            country.setGoldMedals(countryDTO.getGoldMedals() < 0 ? 0 : countryDTO.getGoldMedals());
        }

        if(countryDTO.getSilverMedals() != null){
            country.setSilverMedals(countryDTO.getSilverMedals() < 0 ? 0 : countryDTO.getSilverMedals());
        }

        if(countryDTO.getBronzeMedals() != null){
            country.setBronzeMedals(countryDTO.getBronzeMedals() < 0 ? 0 : countryDTO.getBronzeMedals());
        }

        return mapToDTO(countryRepository.save(country));
    }

    public CountryDTO increaseCountryGold(String id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class));

        country.setGoldMedals(country.getGoldMedals() + 1);

        return mapToDTO(countryRepository.save(country));
    }

    public CountryDTO increaseCountryGoldByName(String name) {
        try{
            Country country = countryRepository.findByName(name);

            country.setGoldMedals(country.getGoldMedals() + 1);

            return mapToDTO(countryRepository.save(country));
        }catch(NullPointerException e){
            throw new ResourceNotFoundException(Country.class);
        }
    }

    public CountryDTO decreaseCountryGold(String id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class));

        if(country.getGoldMedals() > 0){
            country.setGoldMedals(country.getGoldMedals() - 1);
        }

        return mapToDTO(countryRepository.save(country));
    }

    public CountryDTO decreaseCountryGoldByName(String name) {
        try{
            Country country = countryRepository.findByName(name);

            if(country.getGoldMedals() > 0){
                country.setGoldMedals(country.getGoldMedals() - 1);
            }

            return mapToDTO(countryRepository.save(country));
        }catch(NullPointerException e){
            throw new ResourceNotFoundException(Country.class);
        }
    }

    public CountryDTO increaseCountrySilver(String id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class));

        country.setSilverMedals(country.getSilverMedals() + 1);

        return mapToDTO(countryRepository.save(country));
    }

    public CountryDTO increaseCountrySilverByName(String name) {
        try{
            Country country = countryRepository.findByName(name);

            country.setSilverMedals(country.getSilverMedals() + 1);

            return mapToDTO(countryRepository.save(country));
        }catch(NullPointerException e){
            throw new ResourceNotFoundException(Country.class);
        }
    }

    public CountryDTO decreaseCountrySilver(String id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class));

        if(country.getSilverMedals() > 0){
            country.setSilverMedals(country.getSilverMedals() - 1);
        }

        return mapToDTO(countryRepository.save(country));
    }

    public CountryDTO decreaseCountrySilverByName(String name) {
        try{
            Country country = countryRepository.findByName(name);

            if(country.getSilverMedals() > 0){
                country.setSilverMedals(country.getSilverMedals() - 1);
            }

            return mapToDTO(countryRepository.save(country));
        }catch(NullPointerException e){
            throw new ResourceNotFoundException(Country.class);
        }
    }

    public CountryDTO increaseCountryBronze(String id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class));

        country.setBronzeMedals(country.getBronzeMedals() + 1);

        return mapToDTO(countryRepository.save(country));
    }

    public CountryDTO increaseCountryBronzeByName(String name) {
        try{
            Country country = countryRepository.findByName(name);

            country.setBronzeMedals(country.getBronzeMedals() + 1);

            return mapToDTO(countryRepository.save(country));
        }catch(NullPointerException e){
            throw new ResourceNotFoundException(Country.class);
        }
    }

    public CountryDTO decreaseCountryBronze(String id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class));

        if(country.getBronzeMedals() > 0){
            country.setBronzeMedals(country.getBronzeMedals() - 1);
        }

        return mapToDTO(countryRepository.save(country));
    }

    public CountryDTO decreaseCountryBronzeByName(String name) {
        try{
            Country country = countryRepository.findByName(name);

            if(country.getBronzeMedals() > 0){
                country.setBronzeMedals(country.getBronzeMedals() - 1);
            }

            return mapToDTO(countryRepository.save(country));
        }catch(NullPointerException e){
            throw new ResourceNotFoundException(Country.class);
        }
    }

    public void deleteCountry(String id) {
        countryRepository.delete(countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class)));
    }

    public void deleteCountryByName(String name) {
        try{
            countryRepository.delete(countryRepository.findByName(name));
        }catch(NullPointerException e){
            throw new ResourceNotFoundException(Country.class);
        }
    }
}
