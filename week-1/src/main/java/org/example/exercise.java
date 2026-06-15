package org.example;

public class exercise {

    public static void main(String[] args) {
/*
        variables();
        System.out.println("\n--------------------------\n");
        conditionals();
        System.out.println("\n--------------------------\n");
        demo1();
        System.out.println("\n--------------------------\n");
        switchDemo();
        System.out.println("\n--------------------------\n");
        loopDemo();
        System.out.println("\n--------------------------\n");
        arrays();
        System.out.println("\n--------------------------\n");
        demo2();
        System.out.println("\n--------------------------\n");
        multiDimensionalArray();
        System.out.println("\n--------------------------\n");
        strings();
        System.out.println("\n-------------------------\n");
        kalinInceSesliBulma();
        System.out.println("\n--------------------------\n");
        arkadasSayi();
        System.out.println("\n-------------------------\n");
        sayiBulma();
        System.out.println("\n-------------------------\n");
        abc();
        System.out.println("\n-------------------------\n");
        int sonuc = topla(5,3);
        System.out.println(sonuc);

        int toplam = topla2(5,5,8,9);
        System.out.println(toplam);
        */



    }

/*
    public static void variables() {

        System.out.println("Degiskenler Fonksiyonu");

        System.out.println("Java");

        int ogrenciSayisi = 12;
        String mesaj = "Öğrenci Sayisi";
        System.out.println(mesaj + ogrenciSayisi);

        double zehra = 5.5;
        char karakter = 'A';
        char karakter2 = 'b';

        boolean dogruMu = true;


    }

    public static void conditionals() {

        System.out.println("Degiskenler Fonksiyonu");

        int sayi = 15;
        //if(sayi<21){
        //  System.out.println("sayi 21 den kücüktür");
        //}else{
        //  System.out.println("sayi 20 den kücük degildir");
        //}

        if (sayi < 20) {
            System.out.println("sayi 20 den kucuktur");
        } else if (sayi == 20) {
            System.out.println("sayi 20 ye esittir");
        } else {
            System.out.println("sayi 20 den buyuktur");
        }
    }

    public static void demo1() {
        //3 sayıdan en büyüğünü bulma
        int sayi1 = 20;
        int sayi2 = 25;
        int sayi3 = 2;
        int enBuyuk = sayi1;

        if (enBuyuk < sayi2) {
            enBuyuk = sayi2;
        }
        if (enBuyuk < sayi3) {
            enBuyuk = sayi3;
        }
        System.out.println("En büyük sayı:" + enBuyuk);
    }

    public static void switchDemo() {
        //dallandırma, bir öğrencinin bir sınavdan aldığı nota göre ona mesaj vermeye yönelik puan sistemi
        char grade = 'A';
        switch (grade) {
            case 'A': //Eğer not A ise
                System.out.println("Geçtiniz");
                break;
            case 'B':
                System.out.println("Sınırdan geçtiniz");
                break;
            case 'C':
                System.out.println("Kaldınız");
                break;
            case 'D':
            case 'E':
                System.out.println("Başarısız");
                break;
            default:
                System.out.println("Geçersiz");
        }
//Control + shift + alt + L ile tüm dosya düzene girer.
    }

    private static void loopDemo() {
        //for
        for (int i = 1; i <= 10; i += 2) { //i++ = i=i+1
            System.out.println(i);
        }
        System.out.println("For döngüsü bitti");

        //while
        int i = 2;
        while (i < 10) {
            System.out.println(i);
            i += 2;
        }
        System.out.println("While döngüsü bitti");

        //Do-while
        int j = 0;
        do {
            System.out.println(j);
            j += 2;
        } while (j < 10);
        System.out.println("Do-while döngüsü bitti");
    }

    public static void arrays() {
        String[] ogrenciler = new String[10];
        ogrenciler[0] = "Fatma";
        ogrenciler[1] = "Zehra";
        ogrenciler[2] = "Ubay";

        for (int i = 0; i < ogrenciler.length; i++) { //ogrenciler.length (öğrencilerin eleman sayısı)
            System.out.println(ogrenciler[i]);
        }

        for (String ogrenci : ogrenciler) {//Ogrenciker dizisindeki her bir elemanı gez ve gezerken o anki elemana takma isim ver(ogrenci)
            System.out.println(ogrenci);
        }
    }

    public static void demo2() {
        double[] myArray = {1.2, 5.7, 8.4, 9.3}; //double[] myArray = new double[4];
        double total = 0;
        double enBuyuk = myArray[0];

        for (double number : myArray) {
            if (enBuyuk < number) {
                enBuyuk = number;
            }
            total += number; // total = total + number
            System.out.println(number);

        }
        System.out.println("Toplam = " + total);
        System.out.println("En buyuk sayi = " + enBuyuk);
    }

    public static void multiDimensionalArray() {
        String[][] city = new String[3][3];
        city[0][0] = "İstanbul";
        city[0][1] = "Bursa";
        city[0][2] = "Bilecik";
        city[1][0] = "Ankara";
        city[1][1] = "Konya";
        city[1][2] = "Kayseri";
        city[2][0] = "Diyarbakır";
        city[2][1] = "Şanlıurfa";
        city[2][2] = "Gaziantep";

        for (int i = 0; i <= 2; i++) {
            System.out.println("\n--------------------------\n");
            for (int j = 0; j <= 2; j++) {
                System.out.println(city[i][j]);
            }
        }
    }

    public static void strings() {

        String mesaj = "Mesaj gönderildi";
        System.out.println(mesaj);


        System.out.println("Eleman sayısı:" + mesaj.length()); //mesajda 5 krakter var
            System.out.println("5. eleman: " + mesaj.charAt(4));
            System.out.println(mesaj.concat(" gönderildi."));
            System.out.println(mesaj.startsWith("m")); //büyük-küçük harf duyarlılığı vardır
            System.out.println(mesaj.endsWith(".")); //boolean olarak dönerler

            char[] karakterler = new char[5];
            mesaj.getChars(0,5, karakterler, 0);
            System.out.println(karakterler);

            System.out.println(mesaj.indexOf("a"));
            System.out.println(mesaj.lastIndexOf("m"));

        String newMessage = mesaj.replace(' ', '-');
        System.out.println(newMessage);

        //System.out.println(mesaj.replace(' ','-'));

        System.out.println(mesaj.substring(5, 10));

        for (String kelime : mesaj.split(" ")) {
            System.out.println(kelime);
        }

        System.out.println(mesaj.toLowerCase());
        System.out.println(mesaj.toUpperCase());
        System.out.println(mesaj.trim());
    }

    public static void kalinInceSesliBulma() {
        char harƒ = 'E';

        switch (harƒ) {
            case 'A':
            case 'I':
            case 'O':
            case 'U':
                System.out.println("Kalın sesli harf");
                break;
            default:
                System.out.println("İnce sesli harf");

        }
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

    public static void arkadasSayi(){
        int sayi1 = 220;
        int sayi2 = 284;
        int sayi1toplam = 0;
        int sayi2toplam = 0;

        for(int i = 1; i < sayi1; i++){
            if(sayi1 % i == 0){
                sayi1toplam += i;
            }
        }

        for(int j = 1; j< sayi2; j++){
            if(sayi2 % j == 0){
                sayi2toplam += j;
            }
        }

        if(sayi1 == sayi2toplam){   //if(sayi1==sayi2toplam && sayi2 == sayi1toplam)
            if(sayi2 == sayi1toplam){
                System.out.println("Arkadas sayilardir");
            }else{
                System.out.println("Arkadas sayilar degildir");
            }
        }
    }


    public static void sayiBulma(){
        int[] sayilar = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int aranacak = 5;
        boolean varMi = false;

        for(int i = 0; i < sayilar.length; i++){ // for (int sayi : sayilar)
            if(sayilar[i] == aranacak){ // if(sayi==aranacak)
                varMi = true;
                break;
            }
        }

        if(varMi){
            System.out.println("Sayi vardir");
        }else{
            System.out.println("Sayi yoktur");
        }

    }


    public static int topla(int a, int b) {
        return a+b;
    }

    public static int topla2(int... sayilar){
        int toplam = 0;
        for(int sayi:sayilar){
            toplam += sayi;
        }
        return toplam;
    }
*/


}

