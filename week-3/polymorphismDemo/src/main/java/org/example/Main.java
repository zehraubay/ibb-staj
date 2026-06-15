package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//    EmailLogger logger = new EmailLogger();
//    logger.Log("Log mesaji");

        //Overriding (üzerine yazma)
        // int[] sayilar = new int[]{1,5, "jdeuf" }; (hata verir)
        // ama base logger file,database ve email logglerların annesi olduğu için hata vermez

//        BaseLogger[] loggers = new BaseLogger[]{new FileLogger(), new EmailLogger(), new DatabaseLogger()};
//        for (BaseLogger logger : loggers) { //BaseLogger türünde loggerslar(istediğimiz isim verebiliriz): nereden loggersta
//            logger.Log("Log mesajı");
//        }

        CustomerManager customerManager = new CustomerManager(new DatabaseLogger());
        customerManager.add();

    }
}
