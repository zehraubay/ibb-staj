package org.example;

public class ProductValidator { // ana class static olamıyor ama bu class ın içinde (inner class) başka bir class oluşturmak istediğimiz zaman onun içerisine static yazabiliyoruz.

    static {
        System.out.println("Static Constructing is working");
    }


    public ProductValidator() {
        System.out.println("Constructing is working");
    }

    public static boolean isValid(Product product) {
        if (product.price > 0 && !product.name.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public void birSey() {

    }

    public static class BaskaBirClass { //inner class
        public static void sil() {

        }
    }

}
