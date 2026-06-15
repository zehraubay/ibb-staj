package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      //  ArrayList sehirler = new ArrayList(); //ArrayList bir classtır new lediğimiz den anlıyoruz
        //Arraylist aşağıdaki gibi yazılırsa Arraylist şu an için stringle çalışan generic bir class tır

//        ArrayList<String> sehirler = new ArrayList<String>();
//        sehirler.add("A");
//        sehirler.add("B");
//        sehirler.add("C");
//        // sehirler.add(8); generic yapısını eklemeseydik (<String>) bu hata vermezdi çünkü ArrayList her tipten obje alır
//
//
//    MyList <String> sehirler = new MyList<String>();
//    sehirler.add("A");

        MyList<Customer> sehirler = new MyList<Customer>();
        sehirler.add(new Customer());


        //Tasarım Deseni nedir? belirli standart çözümleri gerçekleştirmek için
    }
}