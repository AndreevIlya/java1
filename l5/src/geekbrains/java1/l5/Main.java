package geekbrains.java1.l5;

public class Main {

    public static void main(String[] args) {
	    Employee[] employees = new Employee[5];
	    employees[0] = new Employee("Василий Алдонин","Генеральный директор",
                "aldo@nin.ru","+7 (123) 123 45 67",120000,62);
        employees[1] = new Employee("Иван Пивовар","Стажер-технолог",
                "pivo@var.ru","+7 (321) 321 54 76",36000,21);
        employees[2] = new Employee("Петр Поддубный","Старший технолог",
                "under@oak.ru","+7 (964) 510 99 99",99000,52);
        employees[3] = new Employee("Алина Веселая","Бухгалтер",
                "alina@joy.ru","+7 (903) 777 16 26",80000,28);
        employees[4] = new Employee("Илья Андреев","Программист",
                "katauri@yandex.ru","+7 (926) 357 67 33",90000,31);

        System.out.println("Сотрудники старше 40 лет:");
        for (Employee employee : employees){
            if (employee.getAge() > 40) employee.getEmployeeInfo();
            System.out.println();
        }
    }
}
