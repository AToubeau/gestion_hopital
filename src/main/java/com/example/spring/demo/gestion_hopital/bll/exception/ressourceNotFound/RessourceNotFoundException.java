package com.example.spring.demo.gestion_hopital.bll.exception.ressourceNotFound;

import com.example.spring.demo.gestion_hopital.bll.exception.HospitalException;

public class RessourceNotFoundException extends HospitalException {
    public RessourceNotFoundException(String message) {
        super(message, 404);
    }

    public RessourceNotFoundException(String message, int status) {
        super(message, status);
    }
}
