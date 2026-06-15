package org.example;

public class KronometreThread implements Runnable {

   private Thread t; //thread nesnesi java kütüphanesinden gelen nesne
    //bir thread ı ben diğerinden ayırabilmem için onlara isim ver
    private String threadName;

    //constructor
    public KronometreThread(String threadName) {
        this.threadName = threadName;
        System.out.println("Oluşturuluyor " + threadName);
    }


    @Override
    public void run() { //thread'imizin kendisi
        System.out.println("Çalıştırılıyor: " + threadName);

        try{
            for (int i = 0; i < 10; i++) {
                System.out.println(threadName + " : " + i);
                Thread.sleep(1000); //i yi yaz 1000 milisaniye bekle, yaz bekle mantığında çalışır
            }
        }catch (InterruptedException exception){
        System.out.println("Kesildi : " + threadName);
        }

        System.out.println("Thread bitti : " + threadName);

    } //Java dili paketinden gelen Runnable isimli bir interfaceyi implemente etmesi lazım


    public void start() {
        System.out.println("Thread nesnesi oluşuyor ");
        if (t == null) {
            t = new Thread(this, threadName); //bir class ı çalıştırmak için new lemek lazımdı
            //thread nesnesine konu olan class, ve thread e bir isim
            t.start();
        }
    }

}
