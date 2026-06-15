package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // createFile();

       // getFileInfo();

       readFile();

        writeFile();

    }

    public static void createFile() throws IOException {
        File file = new File("C:\\Users\\user\\IdeaProjects\\ibb-staj\\files\\student.txt");
        // Dosya yaratmak
        try {
            // file.createNewFile();
            //yoksa üretsin varsa da bu dosya var deyecek kod;
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();//hatanın detayını konsola yazdırır
        }

//        try {
//            // Hata çıkabilecek kodu buraya yaz
//        } catch (HataTipi e) {
//            // hata olursa ne yapılsın
//        } finally {
//            // hata olsa da olmasa da çalışır (opsiyonel)
//        }

//        try-catch → hatayı sen yakalarsın, metodun içinde halledersin
//        throws → hatayı üste atarsın, bu metodu çağıran halletsin

    }

    public static void getFileInfo() throws IOException {
        File file = new File("C:\\Users\\user\\IdeaProjects\\ibb-staj\\files\\student.txt");
        if (file.exists()) { //ilgili yolda dosya varsa true yoksa false
            System.out.println("File adı: " + file.getName()); //getName() dosya ismini okumaya yarıyor
            System.out.println("File path: " + file.getAbsolutePath());
            System.out.println("Can the file be written : " + file.canWrite()); //doya ya yazılabilir mi (yetki,erişim kısıtı)
            System.out.println("Can the file be read : " + file.canRead());
            System.out.println("Byte of the file : " + file.length());
        }

    }

    public static void readFile() {
        File file = new File("C:\\Users\\user\\IdeaProjects\\ibb-staj\\files\\student.txt");
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) { //okunacak satır varsa / bu işlemi yapabildiği sürece
                //bu işlemi/datayı bir yere aktarmak gerekiyor;
                String line = reader.nextLine(); //nextLine() yeni bir satır var mı diye bakıyor eğer varsa okunacak bir şey var demektir sonraki aşamaya true veriyor ve false dönene kadar bu işlemi yapacak
                System.out.println(line);
            }
            reader.close(); //dosyayı kapatmak gerek

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static void writeFile() {
        try {
            //1. yöntem:
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\user\\IdeaProjects\\ibb-staj\\files\\student.txt", true));
            writer.newLine(); // yeni satır oluşturarak sonra bir şey yaz anlamında
            //2.yöntem
            // FileWriter file = new FileWriter("C:\\Users\\user\\IdeaProjects\\ibb-staj\\files\\student.txt");
            writer.write("This is a test file");
            System.out.println("File written successfully");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //bu yapılan yazdırma işlemi üzerine yazma şeklindedir
        //append: true dosyayı ekleme formatında açabiliriz

    }
}