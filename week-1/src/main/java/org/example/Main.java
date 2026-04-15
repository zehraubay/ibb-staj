package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        tekCiftBulma();
        System.out.println("\n--------------------------\n");
        islemOnceligi();
        System.out.println("\n--------------------------\n");
        degiskenAtama();
        System.out.println("\n--------------------------\n");


    }

    public static void tekCiftBulma() {
        Scanner input = new Scanner(System.in);
        System.out.print("Bir sayı girin: ");
        int sayi = input.nextInt();

        if (sayi % 2 == 0) {
            System.out.println("Sonuç: " + sayi + " ÇİFT bir sayıdır.");
        } else {
            System.out.println("Sonuç: " + sayi + " TEK bir sayıdır.");
        }
    }

    public static void islemOnceligi() {

        int sonuc = 20 + 10 / 2 - 6 * 5;
        System.out.println("İşleminin sonucu: " + sonuc);

        int parantezliSonuc = (20 + 10) / 2 - 6 * 5;
        System.out.println("(İşleminin sonucu: " + parantezliSonuc);
    }

    public static void degiskenAtama() {

    }




}