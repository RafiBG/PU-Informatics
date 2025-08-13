import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HomeWork9 {
    public static Scanner scanner = new Scanner(System.in);
    static Map<Character, String> map = new HashMap<>();
    static char[] chars;
    static String word;
    public static void main(String[] args) {
        morzhanskyCode();
    }
    static void morzhanskyCode() {


        word = scanner.nextLine();
        chars = word.toCharArray();

        map.put('a', "@(");
        map.put('b', "!@");
        map.put('c', "(");
        map.put('d', "@!");
        map.put('e', "(-");
        map.put('f', "!-");
        map.put('g', "&");
        map.put('h', "!%");
        map.put('i', "!");
        map.put('j', ".!");
        map.put('k', "!<");
        map.put('l', "!!");
        map.put('m', "^^");
        map.put('n', "%");
        map.put('o', "()");
        map.put('p', "!^@");
        map.put('q', "!.@");
        map.put('r', "@<");
        map.put('s', ")(");
        map.put('t', "/_");
        map.put('u', "^>");
        map.put('v', "<!>");
        map.put('w', "><");
        map.put('x', "<>");
        map.put('y', ".=.");


        for (int i = 0; i < chars.length; i++) {
            System.out.print(map.get(chars[i]));
            }
        }
    }
