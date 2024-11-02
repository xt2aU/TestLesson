import java.util.*;

class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Метод для добавления записи
    public void add(String surname, String phoneNumber) {
        if (!phoneBook.containsKey(surname)) {
            phoneBook.put(surname, new ArrayList<>());
        }
        phoneBook.get(surname).add(phoneNumber);
    }

    // Метод для поиска номера телефона по фамилии
    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, Collections.emptyList());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи
        phoneBook.add("Ivanov", "123-456-7890");
        phoneBook.add("Petrov", "987-654-3210");
        phoneBook.add("Petrov", "555-555-5555");
        phoneBook.add("Sidorov", "555-555-5555");
        phoneBook.add("Kozlov", "111-222-3333");
        phoneBook.add("Kozlov", "444-555-6666");

        // Ищем номера телефонов по фамилии
        System.out.println("Ivanov: " + phoneBook.get("Ivanov"));
        System.out.println("Petrov: " + phoneBook.get("Petrov"));
        System.out.println("Sidorov: " + phoneBook.get("Sidorov"));
        System.out.println("Kozlov: " + phoneBook.get("Kozlov"));
        System.out.println("Kozabaranov: " + phoneBook.get("Kozabaranov")); // Фамилия отсутствует
    }
}