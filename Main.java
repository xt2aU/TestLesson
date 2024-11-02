public class Main {

public static void main(String[] args) {
        // Массив 4x4
        String[][] array4x4 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Массив 5x5
        String[][] array5x5 = {
                {"1", "2", "3", "4", "5"},
                {"6", "7", "8", "9", "10"},
                {"11", "12", "13", "14", "15"},
                {"16", "17", "18", "19", "20"},
                {"21", "22", "23", "24", "25"}
        };

        // Массив 4x4 с символами
        String[][] arrayWithSymbols = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "a", "11", "12"},
                {"13", "14", "15", "16"}
        };

        //Массив 5х5 с символами
        String[][] array5x5WithSymbols = {
                {"1", "2", "3", "4", "5"},
                {"6", "7", "n", "9", "10"},
                {"11", "12", "13", "14", "15"},
                {"16", "17", "18", "19", "a"},
                {"21", "22", "23", "24", "25"}
        };

        // Обработка массива 4x4
        ArrayProcessor.processAndPrintResult(array4x4, "array 4x4");

        // Обработка массива 5x5
        ArrayProcessor.processAndPrintResult(array5x5, "array 5x5");

        // Обработка массива 4x4 с символами
        ArrayProcessor.processAndPrintResult(arrayWithSymbols, "array with symbols");

        //Обработка массива 5х5 с символами
        ArrayProcessor.processAndPrintResult(array5x5WithSymbols, "array with symbols");
    }
}