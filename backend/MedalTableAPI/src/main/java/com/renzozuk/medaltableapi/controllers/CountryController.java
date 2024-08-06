package com.renzozuk.medaltableapi.controllers;

import com.renzozuk.medaltableapi.dto.CountryDTO;
import com.renzozuk.medaltableapi.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getCountries() {
        return new ResponseEntity<>(countryService.getAllCountries(), HttpStatus.OK);
    }

    @GetMapping("/reverse")
    public ResponseEntity<List<CountryDTO>> getCountriesReversed() {
        return new ResponseEntity<>(countryService.getAllCountriesReversed(), HttpStatus.OK);
    }

    @GetMapping("/gold")
    public ResponseEntity<List<CountryDTO> >getCountriesByGoldMedals() {
        return new ResponseEntity<>(countryService.getAllCountriesByGoldMedals(), HttpStatus.OK);
    }

    @GetMapping("/gold/reverse")
    public ResponseEntity<List<CountryDTO> >getCountriesByGoldMedalsReversed() {
        return new ResponseEntity<>(countryService.getAllCountriesByGoldMedalsReversed(), HttpStatus.OK);
    }

    @GetMapping("/all-medals")
    public ResponseEntity<List<CountryDTO>> getCountriesByAllMedals() {
        return new ResponseEntity<>(countryService.getAllCountriesByAllMedals(), HttpStatus.OK);
    }

    @GetMapping("/all-medals/reverse")
    public ResponseEntity<List<CountryDTO>> getCountriesByAllMedalsReversed() {
        return new ResponseEntity<>(countryService.getAllCountriesByAllMedalsReversed(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> countryDetail(@PathVariable String id) {
        return new ResponseEntity<>(countryService.getCountryById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CountryDTO> countryDetailByName(@PathVariable String name) {
        return new ResponseEntity<>(countryService.getCountryByName(name), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO) {
        return new ResponseEntity<>(countryService.createCountry(countryDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<CountryDTO> updateCountry(@RequestBody CountryDTO countryDTO, @PathVariable String id) {
        return new ResponseEntity<>(countryService.updateCountry(countryDTO, id), HttpStatus.OK);
    }

    @PutMapping("/name/{name}/update")
    public ResponseEntity<CountryDTO> updateCountryByName(@RequestBody CountryDTO countryDTO, @PathVariable String name) {
        return new ResponseEntity<>(countryService.updateCountryByName(countryDTO, name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<CountryDTO> deleteCountry(@PathVariable String id) {
        countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/name/{name}/delete")
    public ResponseEntity<CountryDTO> deleteCountryByName(@PathVariable String name) {
        countryService.deleteCountryByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
