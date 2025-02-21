package com.example.spring.demo.gestion_hopital.bll.exception;

public class HospitalException extends RuntimeException {
    private final int status;
    private final Object message;

    public HospitalException(String message) {
        super(message);
        this.status = 500;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public HospitalException(String message, int status) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message.toString();
    }

    @Override
    public String toString() {
        StackTraceElement elem = Thread.currentThread().getStackTrace()[0];
        return String.format("%s throw in %s at %s: %d with message : %s",
                this.getClass().getSimpleName(),
                elem.getMethodName(),
                elem.getFileName(),
                elem.getLineNumber(),
                this.getMessage()
        );
    }
}