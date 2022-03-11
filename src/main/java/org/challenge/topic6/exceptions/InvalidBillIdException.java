package org.challenge.topic6.exceptions;

public class InvalidBillIdException extends RuntimeException{
    public InvalidBillIdException(String message){
        super(message);
    }
}
