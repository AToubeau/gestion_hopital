package com.example.spring.demo.gestion_hopital.bll.exception.alreadyExists;

import com.example.spring.demo.gestion_hopital.bll.exception.HospitalException;

public class AlreadyExistException extends HospitalException {
    public AlreadyExistException(String message) {
        super(message, 409);
    }

    public AlreadyExistException(String message, int status) {
        super(message, status);
    }
}
