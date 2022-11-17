package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookAppDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookAppException;
import com.bridgelabz.addressbookapp.model.Person;
import com.bridgelabz.addressbookapp.repository.AddressBookAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookAppService implements IAddressBookAppService{
    @Autowired
    AddressBookAppRepository addressBookAppRepository;

    @Override
    public ResponseEntity<ResponseDTO> insertPerson(AddressBookAppDTO addressBookAppDTO){
        Person person = new Person(addressBookAppDTO);
        addressBookAppRepository.save(person);
        ResponseDTO responseDTO = new ResponseDTO("Successfully Add in database",person);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseDTO> searchPersonByIdInAddressBook(int id){
        Optional<Person> person = addressBookAppRepository.findById(id);
        if (person.isEmpty()){
           throw new AddressBookAppException("Person is not Found");
        }else {
            ResponseDTO responseDTO = new ResponseDTO(" Successfully getting person",person);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> findPersonByNameInAddressBook(String name){
        List<Person> listperson = addressBookAppRepository.findPersonByFirstName(name);
        if (listperson.isEmpty()){
            throw new AddressBookAppException("Person is not Found");
        }else {
            ResponseDTO responseDTO = new ResponseDTO(" Successfully getting person",listperson);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> deletePersonInAddressBook(int id){
        Optional<Person> person = addressBookAppRepository.findById(id);
        if (person.isEmpty()){
           throw  new AddressBookAppException("Person is not Found");
        }else {
            ResponseDTO responseDTO = new ResponseDTO(" Successfully delete this person",person);
            addressBookAppRepository.delete(person.get());
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> searchAllPersonInAddressBook(){
        List personList = addressBookAppRepository.findAll();
        if (personList.isEmpty()){
           throw  new AddressBookAppException("Person is not Found");
        }else {
            ResponseDTO responseDTO = new ResponseDTO(" Successfully Getting All person",personList);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> editPersonInAddressBook(int id,AddressBookAppDTO addressBookAppDTO){
        Optional<Person> person = addressBookAppRepository.findById(id);
        if (person.isEmpty()){
           throw  new AddressBookAppException("Person is not Found");
        }else {
            Person person1 = new Person(id,addressBookAppDTO);
            addressBookAppRepository.save(person1);
            ResponseDTO responseDTO = new ResponseDTO(" Successfully Update person Information",person1);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
        }
    }
}
