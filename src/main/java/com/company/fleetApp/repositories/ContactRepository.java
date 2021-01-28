package com.company.fleetApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.fleetApp.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
