package org.example;

public class MySqlCustomerDal implements ICustomerDal, IRepository {
    @Override
    public void Add() {
        System.out.println("MySqlCustomerDal Add");
    }
}
