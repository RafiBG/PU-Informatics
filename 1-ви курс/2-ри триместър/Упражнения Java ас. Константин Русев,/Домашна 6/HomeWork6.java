import java.util.Scanner;
public class HomeWork6 {
    public static class AllTasks{
       static Scanner sc = new Scanner(System.in);
       static int howManyPans;
       static int howManyPots;
       static int howManyCentimetersWide;
       static int howManyCentimetersLong;
       static int squareFootageSquareMeters;
       static int howManyCentimetersHigh;
       static int howManyCooksWork;
       static int howManyWaitersWork;
       static int allStaff;
       static int minTemperature;
       static int maxTemperature;
       static int moneyInBankAccount;
       static int moneyDailyTurnover;
       static int allMoney;
       static String chefName;
       static String managerName;
       static String timeYouOpen;
       static String timeYouClose;
       static String haveFridge;
       static String haveGasStove;
       static String haveCombiOven;
       static String haveElectricGrill;
       static String haveHood;
       static String eatChoice;
       static String portionSize;
       static String typeOfRoasting;
       static String kindOfVegetarian;
       static String kindOFSweet;
       static String answerFollowUpQuestions;
       static String addictedToSugar;
       static String iceCreamFlavor;
        static void methodTask1() {
            System.out.println("Колко тигана има в кухнята?");
            howManyPans = sc.nextInt();
            System.out.println("Колко тенджери има в кухнята?");
            howManyPots = sc.nextInt();
            System.out.println("Колко сантиметра е широка кухнята?");
            howManyCentimetersWide = sc.nextInt();
            System.out.println("Колко сантиметра е дълга кухнята?");
            howManyCentimetersLong = sc.nextInt();
            System.out.println("Колко сантиметра е висока кухнята?");
            howManyCentimetersHigh = sc.nextInt();
            sc.nextLine();
            System.out.println("Как се казва главният готвач?");
            chefName = sc.nextLine();
            System.out.println("Колко готвачи работят в кухнята?");
            howManyCooksWork = sc.nextInt();
            System.out.println("Колко сервитьори работят в ресторанта?");
            howManyWaitersWork = sc.nextInt();
            sc.nextLine();
            System.out.println("Как се казва отговорника на сосовете?");
            managerName = sc.nextLine();
            System.out.println("Каква е минималната температура в кухнята?");
            minTemperature = sc.nextInt();
            System.out.println("Каква е максималната температура в кухнята?");
            maxTemperature = sc.nextInt();
            sc.nextLine();
            System.out.println("Колко парички имате в банковата си сметка?");
            moneyInBankAccount = sc.nextInt();
            sc.nextLine();
            System.out.println("Колко парички е дневният оборот на ресторанта ви?");
            moneyDailyTurnover = sc.nextInt();
            System.out.println("В колко часа отваряте?");     // Нямам представа защо не спазва реда
            timeYouOpen = sc.nextLine();                      // въпрос отговор въпрос отговор. Работеше преди както би трябвало.
            System.out.println("В колко часа затваряте?");    // Изкарва двата въпроса и след това дава две полета за попълване
            timeYouClose = sc.nextLine();
            sc.nextLine();
            System.out.println("Желаете ли да отговаряте на опционални въпроси? (Y/N)");
            String yesOrNo = sc.nextLine();

            allStaff = howManyCooksWork + howManyWaitersWork;
            squareFootageSquareMeters = howManyCentimetersLong * howManyCentimetersWide;
            allMoney = moneyDailyTurnover + moneyInBankAccount;

            if (yesOrNo.equals("Y")) {
                System.out.println("Разполагате ли с хладилник?");
                haveFridge = sc.nextLine();
                System.out.println("Разполагате ли с газов котлон?");
                haveGasStove = sc.nextLine();
                System.out.println("Разполагате ли с конвектомат?");
                haveCombiOven = sc.nextLine();
                System.out.println("Разполагате ли с електрическа скара?");
                haveElectricGrill = sc.nextLine();
                System.out.println("Разполагате ли с аспиратор?");
                haveHood = sc.nextLine();
                System.out.println("Всички въпроси са зададени.");
                answerFollowUpQuestions = "Y";
            }
            if (yesOrNo.equals("N")) {
                haveFridge = "N";
                haveGasStove = "N";
                haveCombiOven = "N";
                haveElectricGrill = "N";
                haveHood = "N";
                System.out.println("Всички въпроси са зададени.");
            }
        }
        static void methodOrderSuccessful() {
            System.out.println("Вашата поръчка е взета, моля изчакайте!");
            System.out.println("Вашата поръчка е изпълнена успешно. Благодаря ви, че хапнахте при нас");
        }
        static void methodOrderFailed() {
            System.out.println("Вашата поръчка е взета, моля изчакайте!");
            System.out.println("Ресторантът не може да изпълни вашата поръчка. Започваме процедура по самоунищожение.");
            System.out.println("Благодаря ви, че хапнахте при нас");
        }
        static void methodTask2() {
            System.out.println("Какво ще хапнали?");
            System.out.println("(1) Месно ястие");
            System.out.println("(2) Вегетарианско ястие");
            System.out.println("(3) Десерт");
            eatChoice = sc.nextLine();
            if (eatChoice.equals("1")) {
                System.out.println("Колко голяма порция предпочитате?");
                System.out.println("(1) малка  - 450 грама");
                System.out.println("(2) средна - 750 грама");
                System.out.println("(3) голяма - 950 грама");
                portionSize = sc.nextLine();
                System.out.println("Каква разновидност на изпичане желаете?");
                System.out.println("(1) RARE");
                System.out.println("(2) MEDIUM");
                System.out.println("(3) WELL DONE");
                typeOfRoasting = sc.nextLine();

                if (typeOfRoasting.equals("1")) {
                    if (haveGasStove.equals("N") && haveElectricGrill.equals("Y") &&
                            (36 >= minTemperature && 48 >= maxTemperature && minTemperature >= maxTemperature)) {
                        methodOrderSuccessful();
                    } else {
                        methodOrderFailed();
                    }
                }
                if (typeOfRoasting.equals("2")) {
                    if (haveCombiOven.equals("Y") || allStaff == 5 || chefName.equals("Иван")) {
                        methodOrderSuccessful();
                    } else {
                        methodOrderFailed();
                    }
                }
                if (typeOfRoasting.equals("3")) {
                    if ((timeYouOpen.equals("22") || timeYouOpen.equals("22:00") ||
                            managerName.equals("Петър") || managerName.equals("Радо"))) {
                        if ((howManyPans == 3 || howManyPots == 2) || squareFootageSquareMeters == 45) {
                            methodOrderSuccessful();
                        } else {
                            methodOrderFailed();
                        }
                    }
                    else {
                        methodOrderFailed();
                    }
                }
            }
            if (eatChoice.equals("2")) {
                System.out.println("Какъв вид вегатарианско желаете?");
                System.out.println("(1) Вегатарианско");
                System.out.println("(2) Веганско");
                System.out.println("(3) Пескатерианско");
                kindOfVegetarian = sc.nextLine();
                if (kindOfVegetarian.equals("1")) {
                    if (haveCombiOven.equals("N") || haveElectricGrill.equals("N") ||
                            haveHood.equals("N")) {
                        methodOrderSuccessful();
                    } else {
                        methodOrderFailed();
                    }
                }
                if (kindOfVegetarian.equals("2")) {
                    if (haveFridge.equals("Y") && chefName.equals("Манол") &&
                            (howManyCooksWork >= 3 && howManyCooksWork <= 10) && howManyWaitersWork != 7) {
                        methodOrderSuccessful();
                    }
                    else {
                        methodOrderFailed();
                    }
                }
                if (kindOfVegetarian.equals("3")) {
                    if (haveElectricGrill.equals("Y") || answerFollowUpQuestions.equals("Y")) {
                        if (squareFootageSquareMeters < 13 || allMoney < 158000) {
                            methodOrderSuccessful();
                        }
                        else {
                            methodOrderFailed();
                        }
                    }
                    else {
                        methodOrderFailed();
                    }
                }
            }
            if (eatChoice.equals("3")) {
                System.out.println("Какъв вид десерт желаете?");
                System.out.println("(1) Торта");
                System.out.println("(2) Сладолед");
                kindOFSweet = sc.nextLine();
                System.out.println("Пристрастен ли сте към захарта?");
                addictedToSugar = sc.nextLine();
                if (kindOFSweet.equals("1")) {
                    if (haveFridge.equals("Y") && timeYouClose.equals("19") && haveHood.equals("N") &&
                            (moneyInBankAccount >= 15000 && moneyInBankAccount <= 50000) || chefName.equals("Румен"))  {
                        methodOrderSuccessful();
                    }
                    else {
                        methodOrderFailed();
                    }
                }
                if (kindOFSweet.equals("2")) {
                    System.out.println("Какъв вкус на сладоледа желаете?");
                    System.out.println("(1) Ягода");
                    System.out.println("(2) Банан");
                    System.out.println("(3) Ванилия");
                    iceCreamFlavor = sc.nextLine();
                    if (addictedToSugar.equals("N") || iceCreamFlavor.equals("Ягода")) {
                        methodOrderSuccessful();
                    }
                    else {
                        methodOrderFailed();
                    }
                }
                else {
                    methodOrderFailed();
                }
            }
        }
    }
    public static void main(String[] args) {
        AllTasks.methodTask1();
        AllTasks.methodTask2();
    }
}
