import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class HomeWork10 {
    static Scanner scanner = new Scanner(System.in);
    static int numbers[];
    static int countPositiveNumbers;
    public static void main(String[] args) {
        startTheProgram();
        menuForChoice();
    }

    static void startTheProgram() {
        System.out.println("Въведете колко на брой числа ще въвеждате.");
        int sizeOfArray = scanner.nextInt();

        numbers = new int[sizeOfArray];
        System.out.println("Въведи " + sizeOfArray + " числа които да са между -100 и 100 :");

        for (int i = 0; i < sizeOfArray; i++) {
            numbers[i] = scanner.nextInt();

            if (numbers[i] >= -100 && numbers[i] <= 100) {
                continue;
            }
            System.out.println("Може да въвеждате само числа между -100 и 100");
            System.exit(0);  // Отказах се да отделям още време в това да го завъртя затова го прекратих с exit.
        }
    }

    static void menuForChoice() {
        while (true) {
            System.out.println("Меню с опции: ");
            System.out.println("1. Извеждане на положителните числа, както и техният брой");
            System.out.println("2. Извеждане на отрицателните числа, както и техният брой");
            System.out.println("3. Извеждане на сумата (сбора) на положителните числа");
            System.out.println("4. Извеждане на сумата (сбора) на отрицателните числа");
            System.out.println("5. Извеждане на второто най-голямо число");
            System.out.println("6. Извеждане на числото, което е с максимална разлика от средната стойност на" +
                    "въведените числа");
            System.out.println("7. Извеждане сумата от абсолютната стойност на въведените числа");
            System.out.println("8. Извеждане сумата на всички числа кратни на 3, но по-големи от 15");
            System.out.println("9. Извеждане сумите на всеки два съседни елемента");
            System.out.println("10. Извеждане на модата на числата");
            System.out.println("11. Визуализирай въведените числа");
            System.out.println("12. Изход");

            String numberOfChoice = scanner.next();

            switch (numberOfChoice) {
                case "1":
                    positiveNumbersAndTheCount();
                    break;
                case "2":
                    negativeNumbersAndTheCount();
                    break;
                case "3":
                    sumOfAllPositiveNumbers();
                    break;
                case "4":
                    sumOfAllNegativeNumbers();
                    break;
                case "5":
                    outputSecondLargestNumber();
                    break;
                case "6":
                    findLargestDifference();
                    break;
                case "7":
                    sumOfAbsoluteValue();
                    break;
                case "8":
                    sumsAllNumbersThatAreMultiples();
                    break;
                case "9":
                    theSumsOfAnyTwoAdjacentElements();
                    break;
                case "10":
                    theFashionOfNumbers();
                    break;
                case "11":
                    int[] result = showTheEnteredNumbers();
                    System.out.println("Числата които си въвел: " + Arrays.toString(result));
                    break;
                case "12":
                    exit();
                    break;
                default:
                    System.err.println("Няма такава опция в менюто!");
                    break;
            }
        }
    }

    static void positiveNumbersAndTheCount() { // Task 1
        int j = 0;
        System.out.println("\nПозитивните числа в листа са: ");
        while(j < numbers.length)
        {
            if(numbers[j] >= 0) {
                System.out.format("%d ", numbers[j]);
                countPositiveNumbers++;
            }
            j++;
        }
        System.out.println("\nБроя на позитивните числа: " + "\n" + countPositiveNumbers);
    }

    static void negativeNumbersAndTheCount() { // Task 2

        int j = 0;
        System.out.println("\nОтрицателните числа в листа са: ");
        while(j < numbers.length)
        {
            if(numbers[j] <= 0) {
                System.out.format("%d ", numbers[j]);
                countPositiveNumbers++;
            }
            j++;
        }
        System.out.println("\nБроя на отрицателните числа: " + "\n" + countPositiveNumbers);
    }
    static void sumOfAllPositiveNumbers() {  // Task 3

        int j = 0;
        int[] positiveNumbers = new int[numbers.length];

        while(j < numbers.length)
        {
            if(numbers[j] >= 0) {
                countPositiveNumbers++;
                positiveNumbers[countPositiveNumbers] = numbers[j];
            }
            j++;
        }

        int sum = IntStream.of(positiveNumbers).sum();
        System.out.println("Сбора на всички положителни числа: " + sum);
    }

    static void sumOfAllNegativeNumbers() {  // Task 4

        int j = 0;
        int[] negativeNumbers = new int[numbers.length];

        while(j < numbers.length)
        {
            if(numbers[j] <= 0) {
                countPositiveNumbers++;
                negativeNumbers[countPositiveNumbers] = numbers[j];
            }
            j++;
        }

        int sum = IntStream.of(negativeNumbers).sum();
        System.out.println("Сбора на всички отрицателни числа: " + sum);
    }

    static void outputSecondLargestNumber() {   // Task 5
        int total = numbers.length;
        int temp;
        for (int i = 0; i < total; i++)
        {
            for (int j = i + 1; j < total; j++)
            {
                if (numbers[i] > numbers[j])
                {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.println("Второто най-голямо число в твоите въведени числа: " + numbers[total-2]);
    }

    static void findLargestDifference() { // Task 6
        int n = numbers.length;
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        int mean = sum / n;
        int maxDifference = 0;
        int result = 0;
        for (int num : numbers) {
            int difference = Math.abs(num - mean);
            if (difference > maxDifference) {
                maxDifference = difference;
                result = num;
            }
        }
        System.out.println("Число с максимална разлика: " + result);
    }

    static void sumOfAbsoluteValue() {  // Task 7
        System.out.print("Въведи колко числа ще въвеждаш: ");
        int sizeOfArray = scanner.nextInt();
        double[] array = new double[sizeOfArray];
        System.out.println("Въведи " + sizeOfArray + " числа между -100 и 100");
        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = scanner.nextDouble();
        }

        double sum = 0;
        for (double num : array) {
            sum += Math.abs(num);
        }
        System.out.println("Сбора от абсолютните числа: " + sum);
    }

    static void sumsAllNumbersThatAreMultiples() {  //Task 8
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 3 == 0 && numbers[i] > 15) {
                sum += numbers[i];
            }
        }
        System.out.println("Сумиране на всички числа кратни: " + sum);
    }

    static void theSumsOfAnyTwoAdjacentElements() { // Task 9
        int result[] = new int[numbers.length - 1];
        for (int i = 0; i < numbers.length - 1; i++) {
            result[i] = numbers[i] + numbers[i + 1];
        }
        System.out.println("Сумата на всеки два съседни елемента: " + result);
    }

    static void theFashionOfNumbers() {  // Task 10
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int fashionOfNumbers = 0;
        int maximumFrequency = 0;
        for (int num : numbers) {
            int frequency = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, frequency);
            if (frequency > maximumFrequency) {
                maximumFrequency = frequency;
                fashionOfNumbers = num;
            }
        }
        System.out.println("Най-повтярано число: " + fashionOfNumbers);
    }

    static int[] showTheEnteredNumbers() { // Task 11
        {
            int[] copiedNumbers = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                copiedNumbers[i] = numbers[i];
            }
            return copiedNumbers;
        }
    }
    static void exit(){  // Task 12
        System.err.println("Програмата приключи!");
        System.exit(0);
    }
}
