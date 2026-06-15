package org.example;

public class ProductManager {
    public void add(Product product) {
       //ProductValidator validator = new ProductValidator();

       if (ProductValidator.isValid(product)) { //Biz new'i kaldırırsak hata verir, ProductValidator da public static yapmamız gerkeiyor
           System.out.println("Eklendi");
       }else{
           System.out.println("Hata");
       }

       //ProductValidator productValidator = new ProductValidator();
        // productValidator.birSey();
    }

    //bir methodu static yaptığımız zaman class ismiyle direk çağırabiliyoruz
    //bir fonksiyonu çağıracağımız zaman onu new'lememiz gerekiyor
    //Constructor yapıcı bir blok ne new leyince çalışır
}
