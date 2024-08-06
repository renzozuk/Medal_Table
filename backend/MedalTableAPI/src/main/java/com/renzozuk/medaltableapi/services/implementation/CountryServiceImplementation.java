package com.renzozuk.medaltableapi.services.implementation;

import com.renzozuk.medaltableapi.dto.CountryDTO;
import com.renzozuk.medaltableapi.entities.Country;
import com.renzozuk.medaltableapi.repositories.CountryRepository;
import com.renzozuk.medaltableapi.services.CountryService;
import com.renzozuk.medaltableapi.services.exception.DatabaseException;
import com.renzozuk.medaltableapi.services.exception.ResourceNotFoundException;
import com.renzozuk.medaltableapi.util.CountryComparator;
import com.renzozuk.medaltableapi.util.CountryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static com.renzozuk.medaltableapi.util.CountryConverter.mapToDTO;
import static com.renzozuk.medaltableapi.util.CountryConverter.mapToEntity;

@Service
public class CountryServiceImplementation implements CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImplementation(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public CountryDTO createCountry(CountryDTO countryDTO) {
        try{
            Country country = mapToEntity(countryDTO);

            Country createdCountry = countryRepository.save(country);

            return mapToDTO(createdCountry);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public List<CountryDTO> getAllCountries() {
        return countryRepository.findAll().stream().map(CountryConverter::mapToDTO).sorted(Comparator.comparing(CountryDTO::getName)).toList();
    }

    @Override
    public List<CountryDTO> getAllCountriesReversed() {
        return countryRepository.findAll().stream().map(CountryConverter::mapToDTO).sorted(Comparator.comparing(CountryDTO::getName)).toList().reversed();
    }

    @Override
    public List<CountryDTO> getAllCountriesByGoldMedals() {
        return countryRepository.findAll().stream().sorted(CountryComparator::compareByGoldMedals).map(CountryConverter::mapToDTO).toList();
    }

    @Override
    public List<CountryDTO> getAllCountriesByGoldMedalsReversed() {
        return countryRepository.findAll().stream().sorted(CountryComparator::compareByGoldMedalsReversed).map(CountryConverter::mapToDTO).toList();
    }

    @Override
    public List<CountryDTO> getAllCountriesByAllMedals() {
        return countryRepository.findAll().stream().sorted(CountryComparator::compareByAllMedals).map(CountryConverter::mapToDTO).toList();
    }

    @Override
    public List<CountryDTO> getAllCountriesByAllMedalsReversed() {
        return countryRepository.findAll().stream().sorted(CountryComparator::compareByAllMedalsReversed).map(CountryConverter::mapToDTO).toList();
    }

    @Override
    public CountryDTO getCountryById(String id) {
        return mapToDTO(countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class)));
    }

    @Override
    public CountryDTO getCountryByName(String name) {
        try{
            return mapToDTO(countryRepository.findByName(name));
        }catch(NullPointerException e){
            throw new ResourceNotFoundException(Country.class);
        }
    }

    @Override
    public CountryDTO updateCountry(CountryDTO countryDTO, String id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class));

        return updateCountryData(countryDTO, country);
    }

    @Override
    public CountryDTO updateCountryByName(CountryDTO countryDTO, String name) {
        try{
            Country country = countryRepository.findByName(name);

            return updateCountryData(countryDTO, country);
        }catch(NullPointerException e){
            throw new ResourceNotFoundException(Country.class);
        }
    }

    private CountryDTO updateCountryData(CountryDTO countryDTO, Country country) {
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

    @Override
    public void deleteCountry(String id) {
        countryRepository.delete(countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Country.class)));
    }

    @Override
    public void deleteCountryByName(String name) {
        try{
            countryRepository.delete(countryRepository.findByName(name));
        }catch(NullPointerException e){
            throw new ResourceNotFoundException(Country.class);
        }
    }
}
