package com.spring.demo;

public class CustomerManager implements ICustomerService {

    //CustomerManager bir tane eklemke yapacak (add()) sonra customerDal'ı çağıracak
    //CustomerManager constructor'ında bir injection'a ihtiyaç duyuyor yani bana bir ICustomerDal ver diyor
    private ICustomerDal customerDal;

    //constructor injection
   public CustomerManager(ICustomerDal customerDal) {
        this.customerDal = customerDal;
    }

    public void add(){
       //iş kuralları
        customerDal.add();

    }
}

