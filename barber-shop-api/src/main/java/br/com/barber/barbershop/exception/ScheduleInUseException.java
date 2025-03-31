package br.com.barber.barbershop.exception;

public class ScheduleInUseException extends  RuntimeException{
    public ScheduleInUseException(String message) {
        super(message);
    }
}
