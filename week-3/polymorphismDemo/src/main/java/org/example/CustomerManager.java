package org.example;

public class CustomerManager {
    private BaseLogger logger;

    public CustomerManager(BaseLogger logger) { //bu class'ı kullanmak istiyorsam bana çalıştığın loggerın kim olduğunu söyle
    //bu class'ın constructor'ı new'lerken çalışır
    this.logger = logger;
    }

    public void add(){
        System.out.println("Add Customer");
//        DatabaseLogger logger = new DatabaseLogger();
        // her "new" yaptığımızda bağımlı bir sistem haline getiriyoruz
//        logger.Log("Log mesaj");
        this.logger.log("Log mesajı");
    }
}
