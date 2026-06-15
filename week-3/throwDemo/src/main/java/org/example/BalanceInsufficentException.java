package org.example;

public class BalanceInsufficentException extends Exception {
    //bu class'ın exception olabilmesi için (tüm exception'lar hepsi bir Exception) extends Exception yazılmalı

    String message;
public BalanceInsufficentException(String message) {
    this.message = message;
}
    @Override
    public String getMessage() {
        return this.message;
    }
}
