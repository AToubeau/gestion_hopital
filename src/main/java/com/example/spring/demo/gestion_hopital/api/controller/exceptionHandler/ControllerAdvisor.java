package com.example.spring.demo.gestion_hopital.api.controller.exceptionHandler;

import com.example.spring.demo.gestion_hopital.bll.exception.HospitalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(HospitalException.class)
    public ResponseEntity<Object> handleHospitalException(HospitalException ex){
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }
}
