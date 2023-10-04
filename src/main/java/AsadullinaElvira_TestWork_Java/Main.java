package main.java.AsadullinaElvira_TestWork_Java;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String message1 = "Привет";
        saySomething(message1);
        Stream.generate(() -> "*").limit(15).forEach(System.out::print);
        printMessage("");

        String message2 = "Вячеслав";
        sayHelloToSomebody(message2);
        Stream.generate(() -> "*").limit(15).forEach(System.out::print);
        printMessage("");

        getMultipleOfThreeNumbers();
    }

    /** Составить алгоритм: если введенное число больше 7, то вывести “Привет”. */
    public static void saySomething(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean isInt = false;
        while (!isInt) {
            printMessage("Введите целое число: ");
            if (sc.hasNextInt()) {
                isInt = true;
                int number = sc.nextInt();
                if (number > 7) {
                    printMessage(msg);
                }
            } else {
                printMessage("Введено не целое число. Попробуйте снова.");
                sc.next();
            }
        }
    }

    /** Составить алгоритм: если введенное имя совпадает с Вячеслав, то вывести “Привет, Вячеслав”,
     * если нет, то вывести "Нет такого имени". */
    public static void sayHelloToSomebody(String msg) {
        Scanner sc = new Scanner(System.in);
        printMessage("Введите имя: ");
        String name = sc.nextLine();
        if (name.equals("Вячеслав")) {
            printMessage("Привет, " + msg);
        } else {
            printMessage("Нет такого имени");
        }
    }

    /** Составить алгоритм: на входе есть числовой массив, необходимо вывести элементы массива кратные 3 */
    public static void getMultipleOfThreeNumbers() {
        int[] myArr = {};
        Scanner sc = new Scanner(System.in);
        boolean isArr = false;
        while (!isArr) {
            try {
                printMessage("Введите целые числа через пробел: ");
                String input = sc.nextLine();
                myArr = Arrays.stream(input.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                isArr = true;
            } catch (Exception e) {
                printMessage("Необходимо ввести целые числа. Попробуйте снова.");
            }
        }

        int[] newArr = IntStream.of(myArr).filter(item -> item % 3 == 0).toArray();
        if (newArr.length == 0) {
            printMessage("В массиве нет чисел, кратных трем.");
        } else {
            System.out.print("Числа в массиве, кратные трем: ");
            printMessage(Arrays.toString(newArr).replaceAll("\\[|\\]", ""));
        }
    }

    public static void printMessage(String msg) {
        System.out.println(msg);
    }
}
