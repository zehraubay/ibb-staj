package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WomeGameCalculator womanGameCalculator = new WomeGameCalculator();
        womanGameCalculator.hesapla();

        CustomerManager customerManager = new CustomerManager();
        customerManager.databaseManager = new OracleDatabaseManager();
        customerManager.getCustomers();
    }
}