package com.spring.demo;

import lombok.Value;

public class MySqlCustomerDal implements ICustomerDal {

    @Value("${database.connectinString}") // bir anatosyon ile değeri oku nereden okuyacak properties'in ilgili kısmını
            // values properties imiz var sonra config dosyasında onu belirtiyoruz ilgili propertie'ye gidip o value'ye nerden okuyacağını söylüyoruz
    String connectionString; //tüm veritabanlarının connetionString'i farklı olur yani bağlantı stringi

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public void add() {
        System.out.println("Connection String: " + this.connectionString);
        System.out.println("MySQL veritabanına eklendi");
    }
}

/* hibernate orm çözümüdür.biz veritabanına jdbc ile bağlanıyoruz hibernate de bunu yapar
ancak orm: veritabanındaki tablolarla bizim classları eşleştirip classlar üzerinden
veritabanındaki nesneleri hızlıca map ederecek (yani birbirine ilişkilendirerek)
 verileri hızlı bir şekilde insert,update, delete select edebilmemizi sağlıyor
 */