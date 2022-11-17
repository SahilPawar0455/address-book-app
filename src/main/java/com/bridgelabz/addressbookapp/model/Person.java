package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookAppDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNo;
    private String state;
    private String city;
    private String zipcode;

    public Person(AddressBookAppDTO addressBookAppDTO) {
        this.id = id;
        this.firstName =addressBookAppDTO.getFirstName();
        this.lastName = addressBookAppDTO.getLastName();
        this.address = addressBookAppDTO.getAddress();
        this.phoneNo = addressBookAppDTO.getPhoneNo();
        this.state = addressBookAppDTO.getState();
        this.city = addressBookAppDTO.getCity();
        this.zipcode = addressBookAppDTO.getZipcode();
    }

    public Person(int id, AddressBookAppDTO addressBookAppDTO) {
        this.id = id;
        this.firstName =addressBookAppDTO.getFirstName();
        this.lastName = addressBookAppDTO.getLastName();
        this.address = addressBookAppDTO.getAddress();
        this.phoneNo = addressBookAppDTO.getPhoneNo();
        this.state = addressBookAppDTO.getState();
        this.city = addressBookAppDTO.getCity();
        this.zipcode = addressBookAppDTO.getZipcode();
    }
}
