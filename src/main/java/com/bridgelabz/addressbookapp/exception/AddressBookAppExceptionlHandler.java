package com.bridgelabz.addressbookapp.exception;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class AddressBookAppExceptionlHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMessages = errorList.stream().map(objectErr -> objectErr.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request ",errMessages);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @ExceptionHandler(AddressBookAppException.class)
    public ResponseEntity<ResponseDTO> handleException(AddressBookAppException exception){
        ResponseDTO responseDTO = new ResponseDTO("Address Book App Exception",exception.getMessage());
        return new  ResponseEntity<> (responseDTO,HttpStatus.BAD_REQUEST);
    }
}
