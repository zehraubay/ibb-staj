package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // reader.close dosya açıkken çalışır (yan, kapatmaya çalışır) dosya açık değilse, dosya yoksa throws IOException ifadesini ekler
        //dosyayı bulamadığı zaman kapatılacak bir şey de yok ama finally her zaman çalışmak zorunda olduğu için, kapatılacak bir şey olmadığını IOException ile aktarmak gerekiyor
        //check exception dır. diğer yöntemi yine try-catch yapmaktır
        //dosyaları hıclızca okumak için bellekte önce dosyayı belleğe alan ve oradan okunmasını sağlayan bir class
        BufferedReader reader = null;
        int total = 0;
        try {
           // BufferedReader reader = new BufferedReader(new FileReader("sayilar.txt"));
            reader = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\ibb-staj\\week-3\\ReadingFileDemo\\src\\main\\java\\org\\example\\sayilar.txt"));
            //reader'lar dosyalardan okuma işlemlerini satır satır yapar
            String line = null; //böyle yazdığımız zaman dosyayı açtığımız zaman kayıt/satır/veri olmayabilir
        while((line = reader.readLine()) !=null) { //okuyacak data varsa oku, okuyabiliyorsan true değeri dönecek
            //burada yiner readLine'ın altını çiziyor ya throws IOException yazarsın ya da catch açarsın
            total += Integer.valueOf(line); //satırlarımızda sayılar var ama onlar string olarak geliyor.Integer.valurOf ile herhangi bir değeri int e çevirebiliyoruz
        }
        System.out.println("Toplam = " + total);
        } catch (FileNotFoundException e) { //FileNotFoundException = fileName de verilen dosyayı bulamazsan hatası
            //throw new RuntimeException(e);
            e.printStackTrace();
        } catch (Exception e) { //IOExcepiton e) de yazılabilir ama bu tür operasyonlarla uğraşmayıp (spesifik bir hata yoksa) sadece (Exception e) ile geriye kalan tüm exceptionları bununla çözeceğim denilebilir
            e.printStackTrace(); //FilenotFoundException exceptionların base'i
        } finally {
            try{
                reader.close();
            }catch (Exception exception){}
        }
        //kodu tam yazmamıza rağmen FileReader ın altını çizdi. Unhandled exception hatası verdi
        //bazı classlar ı illa try-catch in içine alacaksın veya onu başkası kullanacaksa methodun,
        //add exception to method signature hatası ile public static void main(String[] args) throws FileNotFoundException {'ı fırlatacağını söyle ki
        //diğer taraf/onu kullanan kişi try-catch içine almasını gerektiğini bilsin
        // yada surround with try/catch seçeneğini kullanmak


 



    }
}