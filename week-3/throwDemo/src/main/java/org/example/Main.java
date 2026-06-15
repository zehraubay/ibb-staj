package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        AccountManager manager = new AccountManager();
        System.out.println("Hesap = " + manager.getBalance());

        manager.deposit(100);
        System.out.println("Hesap = " + manager.getBalance());

//        manager.withdraw(90);
//        System.out.println("Hesap = " + manager.getBalance());
//
//        manager.withdraw(20);
//        System.out.println("Hesap = " + manager.getBalance());
        //burada - 10 çıktısı veriyor ama hesapta normalde 10 tl kalmışken 20 tl çekemeyeceğimiz için hata veya uyarı vermesi lazım

        try{
            manager.withdraw(90);
        }catch(BalanceInsufficentException exception){
            System.out.println(exception.getMessage());
        }

        try{
            manager.withdraw(20);
        }catch(BalanceInsufficentException exception){
            System.out.println(exception.getMessage());
        }


    }
}