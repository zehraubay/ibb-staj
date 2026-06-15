package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        factorial();
        System.out.println("\n--------------------------\n");

        fibonacci();
        System.out.println("\n--------------------------\n");

        kombinasyon();
        System.out.println("\n--------------------------\n");

        basamakAyirma();
        System.out.println("\n--------------------------\n");
         */

       // polindromSayiveKelime();
        System.out.println("\n--------------------------\n");

        harfArama();
        System.out.println("\n--------------------------\n");
    }

    /*
    public static void factorial() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int sayi = input.nextInt();

        double factorial = 1;
        for (int i = 1; i <= sayi; i++) {
            factorial *= i;
        }

        System.out.println("Factorial of " + sayi + " is " + factorial);
    }


    public static void fibonacci() {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int adet = input.nextInt(); //kaç tane fibonacci sayısı görmek için

        int sayi1 = 0;
        int sayi2 = 1;

        for (int i = 0; i < adet; i++) {
            System.out.print(sayi1 + " ");
            int gecici = sayi1 + sayi2;
            sayi1 = sayi2;
            sayi2 = gecici;
            }

        }

*/

/*
    public static void kombinasyon() {


        //BASİT/TEMEL KOMBİNASYON
        int ust = 6;
        int alt = 2;
        int factorial = 1;
        int factorial2 = 1;
        int factorial3 = 1;
        int payda = ust - alt;

        for (int i = 1; i <= ust; i++) {
            factorial *= i;
        }

        for (int j = 1; j <= alt; j++) {
            factorial2 *= j;
        }

        for (int a = 1; a <= payda; a++) {
            factorial3 *= a;
        }

        int kombinasyon = factorial / (factorial2 * factorial3);

        System.out.println(kombinasyon);


            //KOMBİNASYON
            Scanner input = new Scanner(System.in); // n >= r >= 0
            int ust;
            int alt;
            while (true) {
                System.out.print("Bir n degeri girin: ");
                ust = input.nextInt();
                if (ust > 0){
                    break;
                }
                System.out.println("0 dan buyuk bir n degeri girin");
            }

            while (true) {
                System.out.print("Bir r degeri girin: ");
                alt = input.nextInt();
                if (alt > 0 && alt <= ust){
                    break;
                }
                System.out.println("0 dan buyuk bir r degeri girin");
            }

            int sonuc = faktoriyel(ust) / (faktoriyel(alt) * faktoriyel(ust - alt));
            System.out.println("Faktoriyel sonucu: " + sonuc);
        }

        public static int faktoriyel(int sayi) {
            int sonuc = 1;
            for (int i = 1; i <= sayi; i++) {
                sonuc *= i;
            }
            return sonuc;
        }

        //PRATİK KOMBİNASYON
        Scanner input = new Scanner(System.in); // n >= r >= 0
        int ust;
        int alt;
        while (true) {
            System.out.print("Bir n degeri girin: ");
            ust = input.nextInt();
            if (ust > 0) {
                break;
            }
            System.out.println("0 dan buyuk bir n degeri girin");
        }

        while (true) {
            System.out.print("Bir r degeri girin: ");
            alt = input.nextInt();
            if (alt > 0 && alt <= ust) {
                break;
            }
            System.out.println("0 dan buyuk bir r degeri girin");
        }

        if (alt > ust - alt) {
            alt = ust - alt;
        }

        int pay = 1;
        for (int i = 0; i < alt; i++) {
            pay *= (ust - i);
        }

        int sonuc = pay / faktoriyel(alt);
        System.out.println("Kombinasyon sonucu: " + sonuc);

    }

    public static int faktoriyel(int sayi) {
        int sonuc = 1;
        for (int i = 1; i <= sayi; i++) {
            sonuc *= i;
        }
        return sonuc;
    }


    public static void basamakAyirma() {

        Scanner input = new Scanner(System.in);
        int sayi = input.nextInt();
        int geciciSayi = Math.abs(sayi);
        int sayac = 1;

        while (geciciSayi > 0) {
            int basamakSayi = geciciSayi % 10;
            System.out.println(sayac + ".basamak: " + basamakSayi);
            sayac++;
            geciciSayi = geciciSayi / 10;
        }
        input.close();

    }

    */

    public static void polindromSayiveKelime() {
        Scanner input = new Scanner(System.in);
        System.out.print("Bir sayi girin: ");
        int sayi = input.nextInt();
        int gecici = Math.abs(sayi);
        int ters = 0;

        //tek basamaklı 0-9 da hepsi polindrom sayi, diğerleri sağdan ve soldan okunuşları aynı olan sayılar

        if (sayi < 10) {
            System.out.println(sayi + "bir polindrom sayıdır");
        }

        while (gecici > 0) {
            int basamak = gecici % 10;
            ters = ters * 10 + basamak;
            gecici /= 10;
        }

        if (Math.abs(sayi) == ters) {
            System.out.println(sayi + " bir palindrom sayidir.");
        } else {
            System.out.println(sayi + " bir palindrom sayisi degildir.");
        }

        System.out.println("\n--------------------------\n");

        Scanner input2 = new Scanner(System.in);
        System.out.print("Bir kelime girin: ");
        String kelime = input2.nextLine().toLowerCase();

        char[] harfler = kelime.toCharArray();

        int bas = 0;
        int son = harfler.length - 1;
        boolean palindrom = true;

        while (bas < son) {
            if (harfler[bas] != harfler[son]) {
                palindrom = false;
                break;
            }
            bas++;
            son--;
        }

        if (palindrom) {
            System.out.println(kelime + " bir palindrom kelimedir.");
        } else {
            System.out.println(kelime + " bir palindrom kelime degildir.");
        }
    }

    public static void harfArama() {

        System.out.print("Bir metin girin: ");
        Scanner input = new Scanner(System.in);
        String metin = input.nextLine().toLowerCase();

        System.out.print("Aranacak harfi girin: ");
        Scanner input2 = new Scanner(System.in);
        char aranan = input2.next().toLowerCase().charAt(0);

        int sayac = 0;


        for (int i = 0; i < metin.length(); i++) {
            if (metin.charAt(i) == aranan) {
                sayac++;
            }
        }

        if (sayac > 0) {
            System.out.println(aranan + " harfi metinde " + sayac + " kez gecmektedir");
        } else {
            System.out.println(aranan + " harfi metinde bulunamadi");
        }
    }


}
