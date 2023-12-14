package br.com.farmaciapjr2.springbootapi.exceptions;

public class ForeignKeyConstraintException extends Exception {
    public ForeignKeyConstraintException(String message) {
        super(message);
    }

    public ForeignKeyConstraintException(String message, Throwable cause) {
        super(message, cause);
    }
}
