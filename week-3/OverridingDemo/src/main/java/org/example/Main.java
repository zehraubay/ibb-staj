package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//      Employee employee = new Employee("Zehra", "Bilgi İşlem", 30000);
//      employee.showInfos();

//      Manager manager = new Manager("Zehra","Bilgi İşlem", 3000);
//      manager.showInfos();

        Employee employee2 = new Manager("Zehra", "Bilgi İşlem", 3000);
        employee2.showInfos();

        // Yukarıda bilgilerin 3 farklı şekilde yazılması gösterilmiştir.

        BaseKrediManager[] krediManagers = new BaseKrediManager[]{new OgretmenKrediManager(), new OgrenciKrediManager(), new TarimKrediManager()};

        for (BaseKrediManager krediManager : krediManagers) {
            System.out.println(krediManager.hesapla(1000));
        }


    }
}