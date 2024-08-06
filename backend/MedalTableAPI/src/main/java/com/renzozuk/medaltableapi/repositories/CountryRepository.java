package com.renzozuk.medaltableapi.repositories;

import com.renzozuk.medaltableapi.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
    Country findByName(String name);
}
