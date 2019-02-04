package geekbrains.java1.l5;

public class Employee {
    private String name;
    private String office;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String office, String email, String phone, int salary, int age){
        this.name = name;
        this.office = office;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void getEmployeeInfo(){
        System.out.printf("%s %s:\nE-mail: %s\n" +
                "Номер телефона: %s\nЗарплата: %d\nВозраст: %d",office, name, email,
                phone, salary, age);
    }
    public int getAge(){
        return age;
    }
}
