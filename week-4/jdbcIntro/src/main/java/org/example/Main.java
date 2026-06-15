package org.example;


import java.sql.*;
import java.util.ArrayList;

public class Main {

//    static String userName = "postgres";
//    static String password = "12345678";
//    static String dbUrl = "jdbc:postgresql://localhost:5432/northwind";
// ilk başta bağlandıktan sonra silebilirsin

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        try {
            connection = helper.getConnection();
            String sql = "delete from customers where customer_id = 'DUZCE'";
            statement = connection.prepareStatement(sql);

            int result = statement.executeUpdate();
            System.out.println("Deleted");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }


    }


    public static void selectDemo() throws SQLException {

        Connection connection = null;
        DbHelper helper = new DbHelper();
        //sql sorgusunu javadan çalıştırmak istersek; slstatement (sql cümleciği)
        Statement statement = null;
        ResultSet resultSet = null; //bu sorgunun sonucunda gelen data resultset (sonuçlar topluluğu) olarak java da karşılanması


        try {
            // connection = DriverManager.getConnection(dbUrl, userName, password); ilk başta bağlandıktan sonra gerek yok DbHelper ile bağlantı kuruyorsun sonra
            connection = helper.getConnection();
            // System.out.println("Connected to database");
            statement = connection.createStatement(); //gönderilecek sorgu bu bağlantıya gidecek (elimiz de birden çok bağlantı olabileceği için spesifik bağlantı kurmamız lazım)
            resultSet = statement.executeQuery("select country, region, city from customers "); //bu sorguyu çalıştırıp sonucu da datayı da resultSet e aktar
            //genelde resultSet bir nesne listesi içerisine atılır ki biz listeyi istediğimiz gibi kullanabilelim
            ArrayList<Customer> customers = new ArrayList<Customer>();

            while (resultSet.next()) { //tek tek gez
                //System.out.println(resultSet.getString("city"));
                customers.add(new Customer(
                        resultSet.getString("country"),
                        resultSet.getString("region"),
                        resultSet.getString("city")));
                //array list'i while ın dışında yapıldığından emin olmak lazım yoksa her seferinde new'lenir ve arraylistemizde en son baktığımızda birt ane eleman görürüz
            }
            System.out.println(customers.size());//kaç elemandan oluştuğu
        } catch (SQLException exception) {
            //System.out.println(exception.getMessage());
            helper.showErrorMessage(exception);
        } finally {
            connection.close();
        }


    }


    public static void insertDemo() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null; // Bu parametreleri genelde kullanıcıdan alırız yani kullanıcı ne verirse onu ekleriz
        ResultSet resultSet = null;


        try {
            connection = helper.getConnection();
            //statement = connection.prepareStatement(
            //      "insert into customers (customer_id, company_name, city, region, country, phone) values ('DUZCE', 'Test Şirket', 'Düzce', ' ', 'Türkiye', '0553-7445334')");
            //prepareStatement cümle hazırla/sql hazırla
            //insert into customers (customer_id, company_name, city, region, country, phone) values (?,?,?,?,?,?)"); yaparsak 6 tane parametreyi sıraasıyla kullanıcıdan her gönderilen değer ilgili alanlara sırasıyla eşitlenecek,

            String sql = "insert into customers (customer_id, company_name, city, region, country, phone) values (?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,"DUZCE 2");
            statement.setString(2,"Test Şirket");
            statement.setString(3,"Düzce");
            statement.setString(4," ");
            statement.setString(5,"Türkiye");
            statement.setString(6,"0553-7445334");
            statement.executeUpdate();
            System.out.println("Inserted into database");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public void updateDemo() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        try {
            connection = helper.getConnection();
            String sql = "update customers set region = 'TUR' where customer_id = 'DUZCE'";
            //String sql = "update city set population = 80000,district='Düzce' where id = ?";
            statement = connection.prepareStatement(sql);
            //statement.setInt(1,4000000);

            int result = statement.executeUpdate();
            System.out.println("Updated");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }

    }
}