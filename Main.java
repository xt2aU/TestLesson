public static void main(String[] args) {
    //Создание нового объекта класса Employee
    Employee employee = new Employee("Иванов Иван Иванович", "Менеджер", "ivanov@example.com", "123-456-7890", 50000.0, 30);
    //Вывод в консоль информации об объекте класса Employee
    employee.printInfo();

    // Создание массива из 5-ти сотрудников
    Employee[] employees = new Employee[5];

    employees[0] = new Employee("Иванов Иван Иванович", "Менеджер", "ivanov@example.com", "123-456-7890", 50000.0, 30);
    employees[1] = new Employee("Петров Петр Петрович", "Разработчик", "petrov@example.com", "234-567-8901", 60000.0, 28);
    employees[2] = new Employee("Сидоров Сидор Сидорович", "Аналитик", "sidorov@example.com", "345-678-9012", 55000.0, 35);
    employees[3] = new Employee("Кузнецов Кузьма Кузьмич", "Тестировщик", "kuznetsov@example.com", "456-789-0123", 45000.0, 25);
    employees[4] = new Employee("Смирнов Сергей Сергеевич", "Дизайнер", "smirnov@example.com", "567-890-1234", 52000.0, 32);
}