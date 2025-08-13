import java.util.*;

public class AllTasks {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static final int CURRENT_YEAR = 2023;
    static int randomNumber;
    static int randomNumberResult;
    static int legalAge;
    static int motherAge;
    static int fatherAge;
    static float centimetersTall;
    static float weightKilograms;
    static float bodyMass;
    static int productConsume;
    static int howOften;
    static int sumOfAllFiveDigits;
    static  String barcode="";


    static int firstDigit;
    static int secondDigit;
    static int thirdDigit;
    static int fourthDigit;
    static int fifthDigit;
    static int sixthDigit;
    static int seventhDigit;
    static int eighthDigit;
    static int ninthDigit;

    static void methodFirstNumberFromDoubleDigitNumber() {
        firstDigit = Integer.parseInt(Integer.toString(firstDigit).substring(0, 1));
    }

    static void methodTask1() {

        System.out.println("Коя година сте роден?");
        int yearBorn = scanner.nextInt();
        int yearsOldUser = CURRENT_YEAR - yearBorn;

        if (yearBorn < 1965) {
            randomNumber = random.nextInt(1, 8);
            if (randomNumber % 2 == 0) {
                randomNumberResult = randomNumber + 1;
                methodFirstNumberFromDoubleDigitNumber();
            } else {
                firstDigit = yearsOldUser / randomNumber;
                methodFirstNumberFromDoubleDigitNumber();
            }
        }
        if (yearBorn > 1965) {
            randomNumber = random.nextInt(1, 8);
            if (randomNumber % 2 == 0) {
                firstDigit = yearsOldUser / randomNumber;
                methodFirstNumberFromDoubleDigitNumber();
            } else {
                randomNumberResult = randomNumber + 1;
                firstDigit = yearsOldUser / randomNumberResult;
                methodFirstNumberFromDoubleDigitNumber();
            }
        }
        if (yearBorn == 1965) {
            firstDigit = 0;
        }
    }

    static void methodTask2() {
        if (firstDigit == 0) {
            secondDigit = 9;
        } else {
            System.out.println("Какъв пол сте?");
            System.out.println("(1) Мъж");
            System.out.println("(2) Жена");
            System.out.println("(3) Без отговор");
            int gender = scanner.nextInt();

            if (gender == 1) {
                secondDigit = 1;
            }
            if (gender == 2) {
                secondDigit = 3;
            }
            if (gender == 3) {
                secondDigit = random.nextInt(1, 10);
            }
        }
    }

    static void methodTask3() {
        System.out.println("Пълнолетен ли сте? ");
        System.out.println("(1) Да");
        System.out.println("(2) Не");
        legalAge = scanner.nextInt();
        if (legalAge == 1) {
            thirdDigit = 0;
        } else {
            System.out.println("На колко години е майка ти?");
            motherAge = scanner.nextInt();
            System.out.println("На колко години е баща ти?");
            fatherAge = scanner.nextInt();
            if (motherAge < fatherAge) {
                thirdDigit = 1;
            }
            if (motherAge > fatherAge) {
                thirdDigit = 2;
            }
            if (motherAge == fatherAge) {
                thirdDigit = 3;
            }
        }
    }

    static void methodTask4() {
        System.out.println("Колко сантиметра си висок?");
        centimetersTall = scanner.nextFloat();
        System.out.println("Колко килограма си?");
        weightKilograms = scanner.nextFloat();
        bodyMass = weightKilograms / (centimetersTall * centimetersTall);
        if (bodyMass < 16) {
            fourthDigit = 1;
        }
        if (bodyMass >= 16 && bodyMass <= 16.99) {
            fourthDigit = 2;
        }
        if (bodyMass >= 17 && bodyMass <= 18.49) {
            fourthDigit = 3;
        }
        if (bodyMass >= 18.5 && bodyMass <= 24.99) {
            fourthDigit = 4;
        }
        if (bodyMass >= 25 && bodyMass <= 29.99) {
            fourthDigit = 5;
        }
        if (bodyMass >= 30 && bodyMass <= 34.99) {
            fourthDigit = 6;
        }
        if (bodyMass >= 35 && bodyMass <= 39.99) {
            fourthDigit = 7;
        }
        if (bodyMass >= 40) {
            fourthDigit = 8;
        }
    }

    static void methodTask5() {
        System.out.println("Какви стоки консумирате? ");
        System.out.println("(1) Плодове и зеленчуци");
        System.out.println("(2) Месо и месни продукти");
        System.out.println("(3) Цигари и алкохол");
        System.out.println("(4) Млечни продукти");
        System.out.println("(5) Захарни изделия");
        productConsume = scanner.nextInt();
        System.out.println("Колко често го купувате? ");
        System.out.println("(1) Рядко");
        System.out.println("(2) Понякога");
        System.out.println("(3) Често");
        howOften = scanner.nextInt();

        if (productConsume == 1) {
            if (howOften == 1) {
                fifthDigit = 1 + 1;
            }
            if (howOften == 2) {
                fifthDigit = 1 + 2;
            }
            if (howOften == 3) {
                fifthDigit = 1 + 3;
            }
        }
        if (productConsume == 2) {
            if (howOften == 1) {
                fifthDigit = 2 + 1;
            }
            if (howOften == 2) {
                fifthDigit = 2 + 2;
            }
            if (howOften == 3) {
                fifthDigit = 2 + 3;
            }
        }
        if (productConsume == 3) {
            if (howOften == 1) {
                fifthDigit = 3 + 1;
            }
            if (howOften == 2) {
                fifthDigit = 3 + 2;
            }
            if (howOften == 3) {
                fifthDigit = 3 + 3;
            }
        }
    }

    static void methodTask6() {
        sumOfAllFiveDigits = firstDigit + secondDigit + thirdDigit
                + fourthDigit + fifthDigit;
        if (sumOfAllFiveDigits < 10) {
            sixthDigit = sumOfAllFiveDigits;
        } else {
            int sumOfAllDigits = 0;
            int remainder;
            while (sumOfAllFiveDigits > 9 && sumOfAllFiveDigits < 100) {
                while (sumOfAllFiveDigits > 0) {
                    remainder = sumOfAllFiveDigits % 10;
                    sumOfAllDigits = sumOfAllDigits + remainder;
                    sumOfAllFiveDigits = sumOfAllFiveDigits / 10;
                }
            }
            sixthDigit = sumOfAllDigits;
        }
    }

    static void methodTask7() {
        int sumOfAllSixDigits = firstDigit + secondDigit + thirdDigit
                + fourthDigit + fifthDigit + sixthDigit;
        if (sumOfAllSixDigits > 10) {
            seventhDigit = 7;
        }
        if (sumOfAllSixDigits < 10) {
            seventhDigit = 6;
        }
        if (firstDigit < secondDigit && secondDigit < thirdDigit
                && thirdDigit < fourthDigit && fourthDigit < fifthDigit
                && fifthDigit < sixthDigit ) {
            seventhDigit = 5;
        }
        if (firstDigit == secondDigit && secondDigit == thirdDigit
                && thirdDigit == fourthDigit && fourthDigit == fifthDigit
                && fifthDigit == sixthDigit ) {
            seventhDigit = 4;
        }
        if (firstDigit % 2 == 0 && secondDigit % 2 == 0 || thirdDigit % 2 != 0) {
            seventhDigit = 3;
        }
        if (firstDigit % 2 == 0 || thirdDigit % 2 == 0 || fifthDigit % 2 == 0) {
            seventhDigit = 2;
        }
        if ((firstDigit % 2 == 0) && (thirdDigit % 2 == 0) && (fifthDigit % 2 == 0)) {
            seventhDigit = 0;
        }
        if ((firstDigit % 2 != 0) && (thirdDigit % 2 != 0) && (fifthDigit % 2 != 0)) {
            seventhDigit = 1;
        }
        else {
            seventhDigit = 9;
        }
    }
    static void methodTask8() {
        if (legalAge == 1 && bodyMass >= 30 && productConsume == 5 && howOften == 3) {
            randomNumber = random.nextInt(1, 10);
            if (randomNumber % 2 == 0) {
                randomNumberResult = randomNumber + 1;
                eighthDigit = randomNumberResult;
            }
            else eighthDigit = randomNumber;
        }
        if (legalAge == 2 && (bodyMass >= 17 && bodyMass <= 18.49) && productConsume == 1 && howOften == 1) {
            if (randomNumber % 2 == 0) {
                eighthDigit = randomNumber;
            }
            else {
                eighthDigit = randomNumber + 1;
            }
        }
        else eighthDigit = 0;
    }
    public static int maxOddNumber(List<Integer> list)
    {
        Iterator<Integer> it = list.iterator();
        int maxOddNumber = 0;
        while (it.hasNext()) {
            int number = it.next();

            if (number % 2 == 1) {
                if (number > maxOddNumber) {
                    maxOddNumber = number;
                }
            }
        }
        return maxOddNumber;
    }
    public static int maxEvenNumber(List<Integer> list)
    {
        Iterator<Integer> it = list.iterator();
        int maxEvenNumber = 0;
        while (it.hasNext()) {
            int number = it.next();

            if (number % 2 == 0) {
                if (number > maxEvenNumber) {
                    maxEvenNumber = number;
                }
            }
        }
        return maxEvenNumber;
    }
    static void methodTask9() {
        List<Integer> list = new ArrayList<>();
        list.add(firstDigit);
        list.add(secondDigit);
        list.add(thirdDigit);
        list.add(fourthDigit);
        list.add(fifthDigit);
        list.add(sixthDigit);
        list.add(seventhDigit);
        list.add(eighthDigit);
        list.forEach(e->barcode+=e);
        int A = maxOddNumber(list);
        int B = maxEvenNumber(list);

        if (A > B) {
            if (A == 9) {
                ninthDigit = 0;
            }
            else ninthDigit = A + 1;
        }
        if (A  < B) {
            if (A == 0) {
                ninthDigit = 9;
            }
            else ninthDigit = A - 1;
        }
        else ninthDigit = 0;
    }
    static void barcodeGeneration() {
        // Отделих доста часове за да оправя този баркод, но нито един вариант не проработи.
        // Как може да се направи?

        char zero = '*';
        char one = '!';
        char two = '@';
        char three = '#';
        char four = '$';
        char five = '%';
        char six = '^';
        char seven = '&';
        char eight = '/';
        char nine = '+';

        char  zeroInt = 0;
        char chFirst = (char) firstDigit;
        char chSecond = (char) secondDigit;
        char chThird = (char) thirdDigit;
        char chFouth = (char) fourthDigit;
        char chFifth = (char) fifthDigit;
        char chSixth = (char) sixthDigit;
        char chSeventh = (char) seventhDigit;
        char chEight = (char) eighthDigit;
        char chNinth = (char) ninthDigit;


        if (barcode.contains("0")) {
           barcode += barcode.replace(zeroInt,zero);
        }
        if (barcode.contains("1")) {
            barcode += barcode.replace(chFirst,one);
        }
        if (barcode.contains("2")) {
            barcode += barcode.replace(chSecond, two);
        }
        if (barcode.contains(("3"))) {
            barcode += barcode.replace(chThird, three);
        }
        if (barcode.contains(("4"))) {
            barcode += barcode.replace(chFouth, four);
        }
        if (barcode.contains(("5"))) {
            barcode += barcode.replace(chFifth, five);
        }
        if (barcode.contains(("6"))) {
            barcode += barcode.replace(chSixth, six);
        }
        if (barcode.contains(("7"))) {
            barcode += barcode.replace(chSeventh, seven);
        }
        if (barcode.contains(("8"))) {
            barcode += barcode.replace(chEight, eight);
        }
        if (barcode.contains(("9"))) {
            barcode += barcode.replace(chNinth, nine);
        }
        System.out.println(firstDigit + " " + secondDigit + " " + thirdDigit +
                " " + fourthDigit + " " + fifthDigit + " " + sixthDigit + " " + seventhDigit
                 + " " + eighthDigit + " " + ninthDigit);
        System.out.println(barcode);
    }
}
