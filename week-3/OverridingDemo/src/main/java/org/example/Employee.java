package org.example;

public class Employee {
    private String name;
    private String department;
    private int salary;

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void showInfos(){
        System.out.println("Bilgiler...");
        System.out.println("İsim: " + name);
        System.out.println("Departman: " + department);
        System.out.println("Maaş: " + salary);
    }

//    public String getName() {
//        return name;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public int getSalary() {
//        return salary;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public void setSalary(int salary) {
//        this.salary = salary;
//    }
//
}
