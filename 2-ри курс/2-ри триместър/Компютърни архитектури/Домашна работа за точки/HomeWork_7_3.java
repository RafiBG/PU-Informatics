import java.util.Scanner;
public class HomeWork_7_3 {
    //Примерни данни за тестване:    под това е отговара след равно които трябва да изкара
    //11 23 33 45 5 -44 -30 -22 -11     = 396
    static int size = 9;
    static int[] numbers = new int[size];
    static int counter = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;

        for (int i = 0; i < size; i++) {
            input = scanner.nextInt();
            processElement(input, -0b1011, i);
        }

        int result = 0;
        for (int j = size - 1; j >= 0; j--) {
            int temp = j + numbers[j];  //Той пита за това -temp от къде идва асемблер 46 ред neg rdi   Писа ми 23 точки
            temp = temp < 0 ? -temp : temp << 1;  // If temp is less than 0, set temp to its negation; otherwise, shift the bits in temp left by 1 (equivalent to multiplying by 2)
            result += temp;
        }
        System.out.println(result+9);
    }
    static void processElement(int element, int value, int index) {
        element ^= value;  // Perform bitwise XOR operation on element and value, and store the result in element
        element += counter;
        element = -element;
        numbers[index] = element;
        counter--;
    }
}

