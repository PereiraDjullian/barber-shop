package br.com.barber.barbershop.exception;

public class PhoneInUseException extends RuntimeException{
    public PhoneInUseException(String message) {
        super(message);
    }
}
