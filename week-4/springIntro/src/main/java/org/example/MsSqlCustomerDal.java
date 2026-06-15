package org.example;

@Component("database") //Anatasyon
public class MsSqlCustomerDal implements ICustomerDal {

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
        System.out.println("MsSql veritabanına eklendi");
    }
}
