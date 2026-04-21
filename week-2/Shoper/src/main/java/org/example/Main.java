package org.example;

public class Main {
    public static void main(String[] args) {

        //Classes are reference type
        CustomerManager customerManager = new CustomerManager(); //class'ın çağırılmaası
        customerManager.Add();
        customerManager.Update();
        customerManager.Remove();

        }



}