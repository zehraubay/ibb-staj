package org.example;

import org.example.math.DortIslem;
import org.example.math.Logaritma;
//import math.*

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String isim = scanner.nextLine();
        System.out.println("Hello " + isim);


        DortIslem dortIslem = new DortIslem();
        dortIslem.topla(2,3);

        Logaritma logaritma = new Logaritma();





    }
}