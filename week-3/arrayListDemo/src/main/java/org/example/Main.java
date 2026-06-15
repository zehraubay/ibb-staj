package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
//        int [] sayilar = new int[]{1,2,3};
//        sayilar = new int[4];
//        //burada sayılar artık 4 elemanlı olmuş oldu
//        System.out.println(sayilar[0]);
//        //0 çıktısını verir
//

//        ArrayList sayilar = new ArrayList();
//        sayilar.add(1);
//        sayilar.add(10);
//        sayilar.add("zehra"); //ArrayList, her türlü değeri alır: int,string,class...
//        // System.out.println(sayilar.size()); //.size() eleman sayısını verir
//        System.out.println(sayilar.get(2)); //indeksi verir mesela 2. indeksi getirir
//        //zehra yı verir
//        sayilar.set(2,100); //2. indeksi (0,1,2... diye gider indeksler) artık 100 ile güncelledik
//        System.out.println(sayilar.get(2));
//
//        sayilar.remove(0); //indeksi silmek
//        // remove edilince 3 indeksli array 2 indekse dönüşüyor
//
//        sayilar.clear(); //tüm elemanları siler
//
//        for (Object i : sayilar){  //array bir obje dir
//            System.out.println(i);
//        }
//
//
//        ArrayList<String> sehirler = new ArrayList<>(); //buraya ne yazılırsa array o tipte olur
//        sehirler.add("Ankara");
//        sehirler.add("Dubai");
//        sehirler.remove("İstanbul"); //spesifik olarak yazıp da silebiliriz
//        sehirler.add("Aydın");
//        Collections.sort(sehirler); // sehirleri sırala
//
//        for(String sehir:sehirler) { //artık obje değil string yazmamız gerekiyor
//            System.out.println(sehir);
//        }
//
//
//        ArrayList<Customer> customers = new ArrayList<Customer>();
//
//        customers.add(new Customer(1, "John", "Smith"));
//        customers.add(new Customer(2, "Zehra", "Ubay"));
//        customers.add(new Customer(3, "Hidayet", "Ubay"));
//
//        customers.remove(new Customer(1, "John", "Smith"));
        //burada john silinmez çünkü bu tür objeler referans üzerinden gider her new denildiğinde her bir nesnenin referans tipi/numarası oluşur
        //yani john 101, zehra 102 hidayet 103 olsun remove da yine newlediğimiz için john 104 oldu
        //bu yüzden listeden herhangi bir eleman silinmez


//        Customer zehra = new Customer(2, "Zehra", "Ubay");
//        customers.remove(zehra);
//        //ama dışarıdan tanımlanınca silinir
//
//        for (Customer customer : customers) {  //türü Customers olan customer değişkenlerimi yukarıda arraylistte tanımladığım customers içerisinde ara
//            System.out.println(customer.firstName);
//        }

        HashMap<String, String> sozluk = new HashMap<String, String>();
        sozluk.put("book", "kitap"); //ilki anahtar ikincisi value (değer)
        sozluk.put("table", "masa");
        sozluk.put("computer", "bilgisayar");
        System.out.println(sozluk.size()); //boyutu verir kaç elemandan oluştuğunu yazdık

        for (String item: sozluk.keySet()) { //book,table,computer elemanlarını bir liste olarak ver (key'leri)
            System.out.println("Eleman-" + item + "Değer-" + sozluk.get(item)); //System.out.println(item);
        }


        sozluk.remove("table");

        System.out.println(sozluk);
        System.out.println(sozluk.get("book")); // book'un value değerini verir

        sozluk.clear();














    }
}