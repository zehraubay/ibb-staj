package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

    private String userName = "postgres";
    private String password = "12345678";
    private String dbUrl = "jdbc:postgresql://localhost:5432/northwind";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, userName, password);
    }

    public void showErrorMessage(SQLException exception) { //veritabanıyla ilgili hataları yönetsin, hata olursa sqlexception çözsün
        System.out.println("Error : " + exception.getMessage()); //getMessage veritabanında oluşan hata mesajını döndürür
        System.out.println("Error code : " + exception.getErrorCode());
    }
}