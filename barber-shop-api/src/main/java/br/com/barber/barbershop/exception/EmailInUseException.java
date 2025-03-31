package br.com.barber.barbershop.exception;

public class EmailInUseException extends  RuntimeException{
    public EmailInUseException(String message) {
        super(message);
    }
}
