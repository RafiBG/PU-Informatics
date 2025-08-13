import java.util.Random;
import java.util.Scanner;
public class HomeWork8 {
   static int coordinateX = 1;
   static int coordinateY = 1;
   static int hoursOxygen = 168;
   static int litersFuel = 90;
   static int randomNumber;
   static int randomNumberForCut;
   static int filledHoles = 0;
   static String witchHand;
   static String loadHand;
   static Scanner scanner = new Scanner(System.in);
   static Random random = new Random();
    public static void main(String[] args) {
        startMission();
        turnOn();

    }
    static void turnOn() {
        while (true) {
            String turnOnMachine = scanner.next();
            if (!turnOnMachine.equals("turnon")) {
                System.out.println("Озонобъркачка не е включена - " +
                        "включете я преди да правите каквото и да е било.");
                continue;
            }
            System.out.println("Озонобъркачка е включена.");
            activateAndDeactivateRoboHand();
            break;
        }
    }
    public static void activateAndDeactivateRoboHand() {
        loadHand = scanner.next();
        if (loadHand.equals("load")) {
             witchHand = scanner.next();
            if (witchHand.equals("A") || witchHand.equals("B") || witchHand.equals("C")) {
                litersFuel = litersFuel - 1; // може и litersFuel--
                if (witchHand.equals("A")) {
                System.out.println("Ръка " + witchHand + " е включена.");
                activateNewHandOrNot();
                }
                if (witchHand.equals("B")) {
                    System.out.println("Ръка " + witchHand + " е включена.");
                    activateNewHandOrNot();
                }
                if (witchHand.equals("C")) {
                    System.out.println("Ръка " + witchHand + " е включена.");
                    activateNewHandOrNot();
                }
            }
            else System.out.println("Не разполагате с подобно устройство.");
        }
    }

    public static void activateNewHandOrNot() {
        while (true) {
            String loadOrUnloadSecondHandOrChooseCordinate = scanner.next();
            if (loadOrUnloadSecondHandOrChooseCordinate.equals("status")) {
                statusInfo();
                continue;
            }
            if (loadOrUnloadSecondHandOrChooseCordinate.equals("moveX") ||
                    loadOrUnloadSecondHandOrChooseCordinate.equals("moveY")) {
                String handDirection = scanner.next();
                if (handDirection.equals("left") || handDirection.equals("right") ||
                        handDirection.equals("up") || handDirection.equals("down")) {
                    int handCoordinates = scanner.nextInt();
                    String loadSecondHand = scanner.next();
                    if (loadSecondHand.equals("load")) {
                        String secondHandAorB = scanner.next();
                        System.out.println("Ръка " + secondHandAorB + " е включена.");
                        litersFuel--;

                        String chooseSecondHandCoordinates = scanner.next();
                        if (chooseSecondHandCoordinates.equals("moveX") ||
                                chooseSecondHandCoordinates.equals("moveY")) {
                            String secondHandDirection = scanner.next();
                            if (secondHandDirection.equals("left") || secondHandDirection.equals("right") ||
                                    secondHandDirection.equals("up") || secondHandDirection.equals("down")) {
                                int secondHandCoordinates = scanner.nextInt();
                            }
                        }
                    }
                    int subtraction = handCoordinates - coordinateX;
                    hoursOxygen = hoursOxygen - subtraction;
                    holeIdentification();
                }
            }
            if (loadOrUnloadSecondHandOrChooseCordinate.equals("load")) {
                String secondHand = scanner.next();
                if (witchHand.equals("A") && secondHand.equals("A")) {
                    cantActivateNewHand();
                    continue;
                }
                if (witchHand.equals("B") && secondHand.equals("B")) {
                    cantActivateNewHand();
                    continue;
                }
                if (witchHand.equals("C") && secondHand.equals("C")) {
                    cantActivateNewHand();
                    continue;
                }
            }
            if (loadOrUnloadSecondHandOrChooseCordinate.equals("unload")) {
                System.out.println("Ръка " + witchHand + " е изключена успешно.");
                String loadSecondHand = scanner.next();
                String secondHand = scanner.next();
                System.out.println("Ръка " + secondHand + " е включена успешно.");
                litersFuel = litersFuel - 1;
                String handDirection = scanner.next();
                if (handDirection.equals("left") || handDirection.equals("right") ||
                        handDirection.equals("up") || handDirection.equals("down")) {
                    int handCoordinates = scanner.nextInt();
                    int subtraction = handCoordinates - coordinateX;
                    hoursOxygen = hoursOxygen - subtraction;
                    holeIdentification();
                }
            }
            break;
        }
    }

    static void holeIdentification() {
        String indentifyOrNot = scanner.next();
        if (indentifyOrNot.equals("identify")) {
            randomNumber = random.nextInt(1,6);
            System.out.println("Дупката е идентифицирана!");
            cuttingOzoneHole();
        }
    }

    static void cuttingOzoneHole() {
        while (true) {
            String cutHole = scanner.next();
            if (cutHole.equals("status")) {
                statusInfo();
                continue;
            }
            if (!cutHole.equals("cut")) {
                System.out.println("Грешка - некоректна последователност " +
                        "на използваната команда");
                continue;
            }
            randomNumberForCut = random.nextInt(1,21);
            System.out.println("Генерирах число от 1 до 20 познай го" +
                    " - за да отрежа дупката");
            while (true) {
                int guessCutNumber = scanner.nextInt();
                if (guessCutNumber != randomNumberForCut) {
                    System.out.println("Неуспешен опит пробвай пак!");
                    hoursOxygen--;
                    continue;
                }
                System.out.println("Операцията cut е изпълнена успешно.");
                fillOzoneHole();
                break;
            }
            break;
        }
    }

    static void fillOzoneHole() {
        while (true) {
            String fillHole = scanner.next();
            if (fillHole.equals("status")) {
                statusInfo();
                continue;
            }
            if (!fillHole.equals("fill")) {
                System.out.println("Грешка - некоректна последователност " +
                        "на използваната команда");
                continue;
            }
            int randomNumberForFill = random.nextInt(1,21);
            int randomFillAndCut = randomNumberForFill + randomNumberForCut;
            System.out.println("Генерирах число от 1 до 20 и го събрах с " + randomNumberForCut + " познай го" +
                    " - за да запълня дупката");
            while (true) {
                int guessFillNumber = scanner.nextInt();
                if (guessFillNumber != randomFillAndCut) {
                    System.out.println("Неуспешен опит пробвай пак!");
                    litersFuel--;
                    continue;
                }
                System.out.println("Операцията fill e изпълнена успешно.");
                finishCommand();
                break;
            }
            break;
        }
    }

    static void finishCommand() {
        while (true) {
            String finishMission = scanner.next();
            if (finishMission.equals("status")) {
                statusInfo();
                continue;
            }
            if (!finishMission.equals("finish")) {
                System.out.println("Грешка - некоректна последователност " +
                        "на използваната команда");
                continue;
            }
            if (litersFuel <= 0) {
                System.out.println("Няма гориво в резервоара, моля презареди!");
            }
            if (hoursOxygen <= 24) {
                System.out.println("Достигнахме критичен кислороден минимум!");
            }
            else {
                System.out.println("Дупка на кординати " + coordinateX + " и " + coordinateY + " e запълнена успешно." );
                System.out.println("Мисията е изпълнена успешно!");
                System.out.println("Може да провериш какъв е статуса. (status)");
                filledHoles++;
                while (true) {
                    String statusBring = scanner.next();
                    if (statusBring.equals("status")) {
                        statusInfo();
                    }
                    break;
                }
                break;
            }
        }
    }
    static void statusInfo() {
        System.out.println("Налично гориво - " + litersFuel  + " литра");
        System.out.println("Наличен кислород - " + hoursOxygen + " часа");
        System.out.println("Запълнени дупки - " + filledHoles);
    }

    static void cantActivateNewHand() {
        System.out.println("Не може да включите нова ръка.");
    }
    static void startMission() {
        System.out.println("Колко дупки искате да запълните?");
        int numberOfHoles = scanner.nextInt();
        coordinateX = random.nextInt(1,51);
        coordinateY = random.nextInt(1,51);
        while (true) {
            if (numberOfHoles == 1) {
                System.out.println("Дупка 1 - се намира на X - " + coordinateX + " и Y - " + coordinateY);
            }
            if (numberOfHoles == 2) {
                System.out.println("Дупка 1 - се намира на X - " + coordinateX + " и Y - " + coordinateY);
            }
            break;
        }
    }
}

