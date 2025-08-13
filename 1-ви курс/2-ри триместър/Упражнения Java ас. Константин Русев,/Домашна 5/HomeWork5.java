import java.util.Scanner;
public class HomeWork5 {
    static void methodTask1And2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Първо име");
        String userName = sc.nextLine();
        System.out.println("Фамилия");
        String surName = sc.nextLine();
        System.out.println("Уникален идентификатор");
        String uniqueIdentifier = sc.nextLine();
        System.out.println("Възраст");
        String age = sc.nextLine();

        System.out.println("Мазе бот v1 на вашите услуги"); // Task 1
        System.out.println("Добре дошъл в мазето на баба: " + userName + " " + surName);
        System.out.println("Ти се индентифицира с номер: " + uniqueIdentifier);
        System.out.println("Ти си на: " + age + " години");
    }
    static void methodTheRestOfTheTasks(){
        String applesWine = "ябълково вино";
        String smokedMeat = "пушено месо";
        String plumMarmalade = "сливов мармалад";
        String pickledPeppers = "мариновани чушки";
        String piggyBank = "прасенце касичка";

        int appleWineQuantity = 10;
        int smokedMeatQuantity = 5;
        int plumMarmaladeQuantity = 9;
        int pickledPeppersQuantity = 4;
        float piggyBankQuantity = 184.35F;

        String itemSignatureAppleWine = "C7544_10";
        String itemSignatureSmokedMeat = "M7441_5";
        String itemSignaturePlumMarmalade = "S6491_9";
        String itemSignaturePickledPappers = "P7485_4";
        String itemSignaturePiggyBank = "B6584_184.35";

        System.out.println("Отчет за продуктите в мазето");
        System.out.println("=================================================================");
        System.out.println("|Продукт               |Брой          |Нов сериен номер         |");
        System.out.println("=================================================================");
        System.out.println("|" + applesWine + "         |" + appleWineQuantity + "            |" + itemSignatureAppleWine + "                 |");
        System.out.println("|" + smokedMeat + "           |" + smokedMeatQuantity + "             |" + itemSignatureSmokedMeat + "                  |");
        System.out.println("|" + plumMarmalade + "       |" + plumMarmaladeQuantity + "             |" + itemSignaturePlumMarmalade + "                  |");
        System.out.println("|" + pickledPeppers + "      |" + pickledPeppersQuantity + "             |" + itemSignaturePickledPappers + "                  |");
        System.out.println("|" + piggyBank + "      |" + piggyBankQuantity  + "        |" + itemSignaturePiggyBank + "             |");
        System.out.println("=================================================================");
    }
    public static void main(String[] args) {
        methodTask1And2();         // Task 1 and 2
        methodTheRestOfTheTasks(); // Task 3,4,5,6,7
    }
}
