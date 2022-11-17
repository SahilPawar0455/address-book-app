package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookAppDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IAddressBookAppService {
    ResponseEntity<ResponseDTO> insertPerson(AddressBookAppDTO addressBookAppDTO);
    ResponseEntity<ResponseDTO> searchPersonByIdInAddressBook(int id);
    ResponseEntity<ResponseDTO> findPersonByNameInAddressBook(String name);
    ResponseEntity<ResponseDTO> deletePersonInAddressBook(int id);
    ResponseEntity<ResponseDTO> searchAllPersonInAddressBook();
    ResponseEntity<ResponseDTO> editPersonInAddressBook(int id,AddressBookAppDTO addressBookAppDTO);

}
