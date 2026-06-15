package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Product product = new Product(1, "Laptop", "Lenovo Laptop", 500, 2, "Siyah"); //yapıcı (constructor) blok çalıştırır. aşağıdaki özellikleri direk parantez içine yazabiliriz
        /*
        product.setName("Laptop");
        product.setDescription("Lenovo Laptop");
        product.setPrice(500.00);
        product.setId(1);
        //product.getId();
*/



        ProductManager productManager = new ProductManager();
        productManager.add(product);

        System.out.println(product.getKod());
    }
}