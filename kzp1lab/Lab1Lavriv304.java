import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Клас Lab1Lavriv304 реалізує лабораторну роботу №1
 */
public class Lab1Lavriv304 {
    /**
     * Статичний метод main є точкою входу в програму
     *
     * @param args аргументи
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ввід розміру матриці
        System.out.println("Введіть розмір матриці: ");
        int row = sc.nextInt();

        // Ввід символа заповнювача
        System.out.println("Введіть символ заповнювач: ");
        String symbol = sc.next();

        // Перевірка на валідність символа заповнювача
        if (symbol.length() != 1) {
            System.out.println("Введіть коректний символ заповнювач");
            return;
        }

        // Символ для останнього стовпця
        System.out.println("Введіть символ для останнього стовпця: ");
        String lastSymbol = sc.next();

        if (lastSymbol.length() != 1) {
            System.out.println("Введіть коректний символ для останнього стовпця");
            return;
        }

        String[][] arr = createLengthOfEachSubArr(row);
        String fileName = "Lab1.txt";

        try {
            printMatrix(arr, symbol, lastSymbol, row, fileName);
        } catch (IOException e) {
            throw new RuntimeException("Сталася помилка під час запису в файл: " + e.getMessage());
        }
    }

    /**
     * Метод який генерує зубчастий масив (виводить в консоль і записує в файл)
     */
    public static void printMatrix(String[][] arr, String symbol, String lastSymbol, int row, String file) throws IOException {
        System.out.println("Результат матриці: ");

        try (FileWriter writer = new FileWriter(file)) {
            for (int i = 0; i < row; i++) {
                int indexJ = 0;

                for (int j = 0; j < row; j++) {
                    if (j % 2 == 1) {
                        // Якщо останній стовпець — використовуємо інший символ
                        if (j == row - 1) {
                            arr[i][indexJ] = lastSymbol;
                        } else {
                            arr[i][indexJ] = symbol;
                        }

                        writer.write(arr[i][indexJ] + " ");
                        System.out.print(arr[i][indexJ] + " ");
                        indexJ++;
                    } else {
                        writer.write("  ");
                        System.out.print("  ");
                    }
                }
                System.out.println();
                writer.write("\n");
            }

            writer.flush();
        }
    }

    /**
     * Метод який знаходить для кожного підмасива довжину
     */
    public static String[][] createLengthOfEachSubArr(int row) {
        String[][] arr = new String[row][];

        for (int i = 0; i < row; i++) {
            int length = 0;
            for (int j = 0; j < row; j++) {
                if (j % 2 == 1) {
                    length++;
                }
            }
            arr[i] = new String[length];
        }

        return arr;
    }
}