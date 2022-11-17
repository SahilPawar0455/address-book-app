package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookAppRepository extends JpaRepository<Person,Integer> {
    @Query(value = "SELECT * FROM person where first_name = :first_name", nativeQuery = true)
    List<Person> findPersonByFirstName(String first_name);
}
