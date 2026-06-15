package org.example;

public class CustomerManager implements ICustomerService {

    private ICustomerDal customerDal; //NullPointerException hatası bunu oluşturamadığı için
    //setter injection ile bu hata giderilir



    //constructor injection
 //   public CustomerManager(ICustomerDal customerDal) {
   //     this.customerDal = customerDal;
    //}

    //NullPointerException hatası

    //setter injection
    public void setCustomerDal(ICustomerDal customerDal) {
        this.customerDal = customerDal;
    }

    public void add(){
        //iş kuralları geçtiyse veri erişimini çağır
        // CostumerManager'ın bir constructor'ında bir ICustomerdal istiyoruz yukarıda o yüzden aşağıdaki new'lemeyi silebiliriz
        // CustomerDal customerDal = new CustomerDal();
        //CustomerManager parametre olarak bir ICustomerDal istiyor ve onun add'ini çalıştırıyor.
        //ICustomerDal artık bir referans tip olduğu için bunu implemente eden herkesi CustomerManager'i parametre verebilirsin
        customerDal.add();

    }
}

//bir class başka bir class ı kullandığında onu new'lememelidir. IOC bunun çözümünü sağlayacak
