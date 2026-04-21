package org.example;
import java.util.Scanner;

public class algorithms {
    public static void main(String[] args) {
        mukemmelSayi();
        armStrong();

    }

    public static void mukemmelSayi() {
        Scanner input = new Scanner(System.in);
        System.out.println("Bir sayı giriniz: ");
        int sayi = input.nextInt();
        int toplam = 0;

        for (int i = 1; i < sayi; i++) {
            if (sayi % i == 0) {
                toplam += i; //total = total + i
            }
        }

        if (toplam == sayi) {
            System.out.println("Mukemmel sayidir");
        } else {
            System.out.println("Mukemmel sayi degildir");
        }
    }


    public static void armStrong() {
        Scanner input = new Scanner(System.in);
        int sayi = input.nextInt();

        int toplam = 0;
        int basamak = 0;
}

}
