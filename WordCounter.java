import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        // Создаем массив с набором слов
        String[] words = {
                "dark", "blue", "red", "white", "dark", "green",
                "dark", "white", "red", "blue", "orange", "yellow",
                "pink", "red", "green", "white", "yellow"
        };

        // Используем HashSet для хранения уникальных слов
        Set<String> uniqueWords = new HashSet<>();
        // Используем HashMap для подсчета повторений
        Map<String, Integer> wordCount = new HashMap<>();

        // Проходим по массиву и заполняем коллекции
        for (String word : words) {
            uniqueWords.add(word);
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Выводим уникальные слова
        System.out.println("Уникальные слова: " + uniqueWords);

        // Выводим количество повторений каждого слова
        System.out.println("Количество повторений каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}