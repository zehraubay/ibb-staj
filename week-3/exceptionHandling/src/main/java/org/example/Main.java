package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try { //try ile aşağıdaki kod çalışmaya çalışır olurda kodlardan birinde hata varsa o zaman catch bloğuna gider
            int[] sayilar = new int[]{1, 2, 3, 4, 5};
           // System.out.println(sayilar[5]); //exception hatası verecek
            System.out.println(sayilar[2]);
        } catch (StringIndexOutOfBoundsException exception) { //hata varsa catch in içindeki değişkene parametre olarak geçilir
            // exception'ımız ArrayIndexOutOfBoundsException
            System.out.println(exception);
            //System.out.println("Hata oluştu");
            //kodlarımızdan ya try çalışır ya da catch
        }catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(exception);
        }catch (Exception exception) { // diğer iki catch çalışmadığı zaman onların dışında bir hata varsa bunu yap gibi
            System.out.println("Loglandı " + exception);
        }
        finally { //en son çalışacak blok. ister try ister catch den biri çalışsın finnally her zaman çaalışmak zorunda
            System.out.println("Ben her türlü çalışırım");
        } //Bütün exception'lar bir inheritance yapısına sahiptir ama hepsi exception classs'ından ihheritance edilir

        // catch(ArrayIndexOutOfBoundsException exception) olarak da yazabiliriz
        //catch(StringIndexOutOfBoundsException exception) verirsek finally çalışacak ama bu hata verecek çünkü string bir ifademiz yok
    }
}