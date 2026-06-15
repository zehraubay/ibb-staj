package org.example;

public class AccountManager {
    private double balance;

    public void deposit(double amount) { // hesaba para yatırma
        balance = getBalance() + amount;
    }

    public void withdraw(double amount) throws BalanceInsufficentException { //hesaptan para çekme
//        1. yöntem
//        if(balance >= amount) {
//            balance = getBalance() - amount;
//        }else{
//            System.out.println("Hesaptan para çekilemedi. Bakiye yetersiz");
//        }
        // 2. yöntem
//        if (balance >= amount) {
//            balance = getBalance() - amount;
//        }else{
//            throw new Exception("Bakiye yetersiz"); //bunu yazınca unhandled exception hatası verir bunun için de public void withdraw(double amount) throws Exception { yapmak lazım
//            //sen bunu handle etmedin dolayısıyla bunu kim kullanacaksa burdan bir exception fırlayacağını bilsin ve o try-catch içine alsın
//        }

        //3. yöntem

        if (balance >= amount) {
            balance = getBalance() - amount;
        } else {
            throw new BalanceInsufficentException("Bakiye yetersiz"); //Yetersiz Bakiye Hatası
            //kendi exception (custom exception) umuzu yazmak için class açarız
        }
    }

    public double getBalance() { //hesaptaki parayı okuma
        return balance;
    }
}
