package com.company.fleetApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.fleetApp.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
