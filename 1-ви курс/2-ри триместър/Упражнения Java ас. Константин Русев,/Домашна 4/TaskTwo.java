public class TaskTwo {
    public static void main(String[] args) {
        int x = 100;
        System.out.println("Step 1 (x declatation and initialization): " + x);
        System.out.println("Step 2 (addition): " + (x += 6));
        System.out.println("Step 3 (subtraction): " + (x -= 4));
        System.out.println("Step 4 (multiplication): " + (x *= 4));
        System.out.println("Step 5 (division): " + (x /= 27));
        System.out.println("Step 6 (modulus division): " + (x %= 7));
    }
}
