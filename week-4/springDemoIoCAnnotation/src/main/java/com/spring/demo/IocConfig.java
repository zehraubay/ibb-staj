package com.spring.demo;

import java.lang.module.Configuration;

@Configuration
@ComponentScan("com.springdemo")
@PropertySource("classpath:values.properies")

public class IocConfig {
    @Bean // bean anatasyonu, xml yapısını bununla yönetebiliriz
    public ICustomerDal database() { //mysql ve mssql i döndürmek için
        return new MsSqlCustomerDal();

    }

    @Bean
    public ICustomerService service() {
        return new CustomerManager(database()); //CustomerManager'ın altını çiziyor çünkü CustomerManager'ımızın constructor'ında ICustomerDal'a ihtiyaç var
// yukarıdaki database'i kullanırsak tüm bağımlılıkları tek bir noktadan yönetmiş oluyoruz
    }

}
