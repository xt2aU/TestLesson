class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class ArrayProcessor {

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4x4");
        }

        int sum = 0;

        // Проход по всем элементам массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]");
                }
            }
        }

        return sum;
    }

    public static void processAndPrintResult(String[][] array, String arrayName) {
        try {
            int result = processArray(array);
            System.out.println("Сумма элементов массива " + arrayName + ":" + result);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
