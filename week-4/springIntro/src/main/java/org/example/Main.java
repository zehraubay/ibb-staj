package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       /* ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml") burada xml dosyamızı okuyacağımızı söylüyoruz


        CustomerManager manager = new CustomerManager(context.getBean("database", ICustomerDal.class));




        */

        // ICustomerService customerService = context.getBean("service", ICustomerService.class));
        // bu yukarıdaki kod hata verir new'lemez çünkü CustomerManager constructor'ında parametre olduğu için onu newleyemiyor parantez içine bir şey istiyor. bir bağımlılık var yani
        // customerService.add();

        //CustomerManager manager = new CustomerManager(new CustomerDal()); // IcustomerDal inrerface olduğu için onu direk new'leyemiyoruz ICustomerDal'ı implemente eden (referansını tutan) CustomerDal'ı veriyoruz



       // CustomerManager manager = new CustomerManager(new MySqlCustomerDal());/
        // manager.add();


    }
}


//IOC

//Dependency Injection

/*
bir class oluşturduğunuzda mesela: new Ogrenci(); oluşturulan nesneyi farklı bir sınıf içerisinden de erişmek istenildiğinde her seferinde başka bir class ta new lemektense bir container'ım var bunun içerisine tanımla istediğiniz sınıf içerisinden tanımlamış olduğun nesneyi al ve istediğin sınıfın içerisine enjekte et.
container içerisinde tanımlamaya IOC,
Sınıfların içerisinde enjekte etmeye dependecy injection denir
*/

/*
applicationContext.xml


<context:property-placeholder location="classpath:values.properties"/>

<bean id="database" class ="springIntro.MsSqlCustomerDal"> database isimli bir talep gelirse arka tarafta CustomerDal'ı new liyor. newlenmiş datayı, nesneyi bize veriyor
    //<property name = "connectionString" value = "--Sql Server string--"></property>
      <property name = "connectionString" value = "${database.connectionString}></property>
</bean>

<bean id="service" class ="springIntro.CustomerManager"> biri senden servis isteğinde bulunursa ona direkt CustomerManager'ı ver
<constructor-arg ref= "database"/> //CustomerManager içerisinde ICustomerDal istiyor. yani parametreye bakıyor database kim MsSqlCustomerDal onu ICustomerDal'a atayabilir mi,evet çünkü onu implemente ediyor
<property name = "customerDal" ref = "database"></property> //property'den biri customerDal ise (setter'ımız yani setCustomerDal'a karşılık geliyor) database'in referansını ver yani MsSql. Constructor'ın alternatifidir.

</bean>




*/
