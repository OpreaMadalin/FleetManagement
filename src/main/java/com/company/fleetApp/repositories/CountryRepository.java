package com.company.fleetApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.fleetApp.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
