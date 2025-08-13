import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class HomeWork11 {
    static Scanner scanner = new Scanner(System.in);
    static int[] numbers;
    static int[] numbersFromBegging;

    public static void main(String[] args) {

        startTheProgram();
        menuChoice();
    }

    static void menuChoice() {

        System.out.println("Меню с опции: ");
        System.out.println("1. Сортиране на въведените числа във възходящ ред");
        System.out.println("2. Сортиране на въведените числа в низходящ ред");
        System.out.println("3. Търсене на позиция на конкретно число");
        System.out.println("4. Разбъркване на числата");
        System.out.println("5. Изчисляване на сбора на всички числа");
        System.out.println("6. Намиране на най-голямото число");
        System.out.println("7. Намиране на най-малкото число");
        System.out.println("8. Намиране средно-аритметично на числата");
        System.out.println("9. Проверка за симетричност на масива от числа");
        System.out.println("10. Обръщане на масива от числа");
        System.out.println("11. Визуализирай въведените числа");
        System.out.println("12. Изход");

        int numberOfChoice = scanner.nextInt();

        switch (numberOfChoice) {
            case 1 -> sortNumbersAscending(numbers);
            case 2 -> sortNumbersDescending();
            case 3 -> findNumber(numbers);
            case 4 -> shuffleNumbers();
            case 5 -> sumOfAllNumbersInArray();
            case 6 -> largestNumberInArray();
            case 7 -> smallestNumberInArray();
            case 8 -> calculateAverageInArray();
            case 9 -> checkIfSymmetry();
            case 10 -> reverseNumbersInArray();
            case 11 -> showTheEnteredNumbers();
            case 12 -> exit();
            default -> System.err.println("Няма такава опция в менюто!");
        }
    }

    static void startTheProgram() {
        System.out.println("Въведете колко на брой числа ще въвеждате.");
        int sizeOfArray = scanner.nextInt();

        numbers = new int[sizeOfArray];
        System.out.println("Въведи " + sizeOfArray + " числа които да са между 0 и 100 :");

        for (int i = 0; i < sizeOfArray; i++) {
            System.out.printf("Веведи число (%d): ", i + 1);
            numbers[i] = scanner.nextInt();

            if (numbers[i] >= 0 && numbers[i] <= 100) {
                continue;
            }
            System.out.println("Може да въвеждате само числа между 0 и 100");
            System.exit(0);
        }
        numbersFromBegging = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersFromBegging[i] = numbers[i];
        }
    }

    public static void printArray(int[] numbers) {  // Used in Task 2,4,9
        for (int number : numbers) {
            System.out.printf("%d, ", number);
        }
        System.out.println();
    }


    static void sortNumbersAscending(int[] numbers) {  // Task 1
        int tempVar;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length - 1; j > i ; j--) {
                if (numbers[j-1] > numbers[j]) {
                    tempVar = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = tempVar;
                }
            }
        }
        printArray(numbers);

        menuChoice();
    }

    static void sortNumbersDescending() {  // Task 2
        int tempVar;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length - 1; j > i ; j--) {
                if (numbers[j-1] < numbers[j]) {
                    tempVar = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = tempVar;
                }
            }
        }
        printArray(numbers);

        menuChoice();
    }

    public static void findNumber(int[] numbers) {   // Task 3 Part 1
        System.out.print("Веведи числото което търсиш: ");
        int numberToFind = scanner.nextInt();
        int numberToFindIndex = linearSearch(numbers, numberToFind);

        if (numberToFindIndex == -1) {
            System.out.printf("Числото: %d не е намерено! \n", numberToFind);

            menuChoice();
        }
        else {
                    System.out.printf("Числото: %d e намерено в списък: %d, и на позиция: %d \n",
                    numberToFind, numberToFindIndex, numberToFindIndex + 1);

                    menuChoice();
        }
    }

    public static int linearSearch(int[] numbers, int numberToFind) {   // Task 3 Part 2
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == numberToFind) {
                return index;
            }
        }

        return -1;
    }

        static void shuffleNumbers() { // Task 4
            Random rand = new Random();

            for (int i = 0; i < numbers.length; i++) {
                int randomSwap = rand.nextInt(numbers.length);
                int temp = numbers[randomSwap];
                numbers[randomSwap] = numbers[i];
                numbers[i] = temp;
            }

            printArray(numbers);
            menuChoice();
        }

        static void sumOfAllNumbersInArray() {  // Task 5
            int sum = IntStream.of(numbers).sum();
            System.out.println("Сумата от всички числа: " + sum);

            menuChoice();
        }

        static void largestNumberInArray() {  // Task 6
            int largest = numbers[0];

            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] > largest) {
                    largest = numbers[i];
                }
            }

            System.out.println("Най-голямото число: " + largest);
            menuChoice();
        }

        static void smallestNumberInArray() {  // Task 7
            int smallest = numbers[0];


            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] < smallest) {
                    smallest = numbers[i];
                }
            }

            System.out.println("Най-малкото число: " + smallest);
            menuChoice();
        }

        static void calculateAverageInArray() {  // Task 8
            int sum = IntStream.of(numbers).sum();
            float average = sum / numbers.length;
            System.out.println("Средно-аритметично: " + average);
            menuChoice();
        }

        static void checkIfSymmetry() {  // Task 9
            boolean isSymmetric = true;

            for (int i = 0; i < numbers.length / 2; i++) {
                if (numbers[i] != numbers[numbers.length - i - 1]) {
                    isSymmetric = false;
                    break;
                }
            }

            if (isSymmetric) {
                System.out.println("Симетрично е");
                printArray(numbers);
                menuChoice();
            } else {
                System.out.println("Не е симетрично");
                printArray(numbers);
                menuChoice();
            }
        }

        static void reverseNumbersInArray() {  // Task 10
            System.out.println("Обърнатите числа:");
            for (int i = numbers.length-1; i >= 0; i--) {
                System.out.print(numbers[i] + " ");
            }
        }

        static void showTheEnteredNumbers () { // Task 11 Part 1
            {
                int[] copiedNumbers = new int[numbersFromBegging.length];
                for (int i = 0; i < numbersFromBegging.length; i++) {
                    copiedNumbers[i] = numbersFromBegging[i];
                }
                System.out.println("Числата които си въвел в началото");
                printArray(numbersFromBegging);

                menuChoice();
            }
        }

        static void exit () { // Task 12
            System.err.println("Програмата приключи!");
            System.exit(0);
        }
    }
