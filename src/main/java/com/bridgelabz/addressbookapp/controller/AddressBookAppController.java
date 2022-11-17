package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookAppDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.service.IAddressBookAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AddressBookAppController {
    @Autowired
    IAddressBookAppService iAddressBookAppService;

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertPerson(@Valid @RequestBody AddressBookAppDTO addressBookAppDTO){
        return iAddressBookAppService.insertPerson(addressBookAppDTO);
    }

    @GetMapping("/searchAllPerson")
    public ResponseEntity<ResponseDTO> searchAllPersonInAddressBook(){
        return iAddressBookAppService.searchAllPersonInAddressBook();
    }

    @GetMapping("/searchPersonById/{id}")
    public ResponseEntity<ResponseDTO> searchPersonInAddressBook(@PathVariable int id){
        return iAddressBookAppService.searchPersonByIdInAddressBook(id);
    }

    @GetMapping("/searchPersonByName/{firstName}")
    public ResponseEntity<ResponseDTO> searchPersonInAddressBook(@PathVariable String firstName){
        return iAddressBookAppService.findPersonByNameInAddressBook(firstName);
    }

    @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity<ResponseDTO> deletePersonInAddressBook(@PathVariable int id){
        return iAddressBookAppService.deletePersonInAddressBook(id);
    }

    @PutMapping("/updatePersonData/{id}")
    public ResponseEntity<ResponseDTO> editPersonInAddressBook(@PathVariable int id,
                                                               @Valid @RequestBody AddressBookAppDTO addressBookAppDTO){
        return iAddressBookAppService.editPersonInAddressBook(id,addressBookAppDTO);
    }
}
