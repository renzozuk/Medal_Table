package com.renzozuk.medaltableapi.controllers;

import com.renzozuk.medaltableapi.dto.CountryDTO;
import com.renzozuk.medaltableapi.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
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

    @PutMapping("/{id}/gold/increase")
    public ResponseEntity<CountryDTO> increaseCountryGold(@PathVariable String id) {
        return new ResponseEntity<>(countryService.increaseCountryGold(id), HttpStatus.OK);
    }

    @PutMapping("/name/{name}/gold/increase")
    public ResponseEntity<CountryDTO> increaseCountryGoldByName(@PathVariable String name) {
        return new ResponseEntity<>(countryService.increaseCountryGoldByName(name), HttpStatus.OK);
    }

    @PutMapping("/{id}/gold/decrease")
    public ResponseEntity<CountryDTO> decreaseCountryGold(@PathVariable String id) {
        return new ResponseEntity<>(countryService.decreaseCountryGold(id), HttpStatus.OK);
    }

    @PutMapping("/name/{name}/gold/decrease")
    public ResponseEntity<CountryDTO> decreaseCountryGoldByName(@PathVariable String name) {
        return new ResponseEntity<>(countryService.decreaseCountryGoldByName(name), HttpStatus.OK);
    }

    @PutMapping("/{id}/silver/increase")
    public ResponseEntity<CountryDTO> increaseCountrySilver(@PathVariable String id) {
        return new ResponseEntity<>(countryService.increaseCountrySilver(id), HttpStatus.OK);
    }

    @PutMapping("/name/{name}/silver/increase")
    public ResponseEntity<CountryDTO> increaseCountrySilverByName(@PathVariable String name) {
        return new ResponseEntity<>(countryService.increaseCountrySilverByName(name), HttpStatus.OK);
    }

    @PutMapping("/{id}/silver/decrease")
    public ResponseEntity<CountryDTO> decreaseCountrySilver(@PathVariable String id) {
        return new ResponseEntity<>(countryService.decreaseCountrySilver(id), HttpStatus.OK);
    }

    @PutMapping("/name/{name}/silver/decrease")
    public ResponseEntity<CountryDTO> decreaseCountrySilverByName(@PathVariable String name) {
        return new ResponseEntity<>(countryService.decreaseCountrySilverByName(name), HttpStatus.OK);
    }

    @PutMapping("/{id}/bronze/increase")
    public ResponseEntity<CountryDTO> increaseCountryBronze(@PathVariable String id) {
        return new ResponseEntity<>(countryService.increaseCountryBronze(id), HttpStatus.OK);
    }

    @PutMapping("/name/{name}/bronze/increase")
    public ResponseEntity<CountryDTO> increaseCountryBronzeByName(@PathVariable String name) {
        return new ResponseEntity<>(countryService.increaseCountryBronzeByName(name), HttpStatus.OK);
    }

    @PutMapping("/{id}/bronze/decrease")
    public ResponseEntity<CountryDTO> decreaseCountryBronze(@PathVariable String id) {
        return new ResponseEntity<>(countryService.decreaseCountryBronze(id), HttpStatus.OK);
    }

    @PutMapping("/name/{name}/bronze/decrease")
    public ResponseEntity<CountryDTO> decreaseCountryBronzeByName(@PathVariable String name) {
        return new ResponseEntity<>(countryService.decreaseCountryBronzeByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<CountryDTO> deleteCountry(@PathVariable String id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/name/{name}/delete")
    public ResponseEntity<CountryDTO> deleteCountryByName(@PathVariable String name) {
        countryService.deleteCountryByName(name);
        return ResponseEntity.noContent().build();
    }
}
