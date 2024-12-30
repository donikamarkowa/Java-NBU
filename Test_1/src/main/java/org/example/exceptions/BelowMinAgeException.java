package org.example.exceptions;

public class BelowMinAgeException extends  Exception{
    private int age;

    public BelowMinAgeException(String message, int age) {
        super(message);
        this.age = age;
    }

    @Override
    public String toString() {
        return "BelowMinAgeException{" +
                "age=" + age +
                '}';
    }
}
