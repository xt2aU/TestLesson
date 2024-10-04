package Lesson1;

import java.util.Scanner;

public class Lesson1 {
    public static void main(String[] args) {
    arrayCreator();
    }

    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign() {
        int a = 3;
        int b = 1;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printColor() {
        int value = 5;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    private static void compareNumbers() {
        int a = 10;
        int b = 7;
        boolean compare = (a >= b);
        if (compare) {
            System.out.println("a >=b");
        } else {
            System.out.println("a < b");
        }
    }

    private static boolean checkSumAdd() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число");
        int a = sc.nextInt();
        System.out.println("Введите второе число");
        int b = sc.nextInt();
        int sum = a + b;
        boolean inRange = sum >= 10 && sum <= 20;
        return inRange;
    }

    private static void checkModul() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int a = sc.nextInt();
        if (a >= 0) {
            System.out.println("Вы ввели положительное число");
        } else {
            System.out.println("Вы ввели отрицательное число");
        }
    }

    private static boolean checkModulReturn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int a = sc.nextInt();
        boolean modul = a < 0;
        return modul;
    }

    private static void printSeveralString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String str = sc.nextLine();
        System.out.println("Введите количество повторений");
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    public static boolean isLeapYear() {
    Scanner sc = new Scanner(System.in);
    int year = sc.nextInt();
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public static void arrayInverter() {
        int[] array = {0,1,1,0,0,1,0,1,1,0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            }
            else if (array[i] == 1) {
                array[i] = 0;
            }
            }
        }
    public static void arrayFill() {
        int[] array= new int[100];
        for (int i = 1; i <= array.length; i++) {
            array[i] = i;
        }
    }
    public static void arrayModifier() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6 ) {
                array[i] *= 2;
            }
        }
    }
    public static void arrayFillDiagonal() {
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - 1 - i] = 1;
        }
                }
    public static void arrayCreator() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину массива");
        int len = sc.nextInt();
        System.out.println("Введите значение ячейки");
        int iniitialValue = sc.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = iniitialValue;
        }

    }
    }


