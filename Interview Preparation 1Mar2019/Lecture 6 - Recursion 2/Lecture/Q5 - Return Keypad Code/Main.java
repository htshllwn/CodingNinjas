
// Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
// Return empty string for numbers 0 and 1.
// Note : The order of strings are not important.
// Input Format :
// Integer n
// Output Format :
// All possible strings in different lines
// Constraints :
// 1 <= n <= 10^6
// Sample Input:
// 23
// Sample Output:
// ad
// ae
// af
// bd
// be
// bf
// cd
// ce
// cf

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int n = Integer.parseInt(reader.readLine());
        for (String s : keypad(n))
            System.out.println(s);
    }

    public static String[] keypad(int n) {
        if (n == 0)
            return new String[] { "" };
        ArrayList<String> list = new ArrayList<>();
        HashMap<Integer, String[]> map = new HashMap<>();
        map.put(2, new String[] { "a", "b", "c" });
        map.put(3, new String[] { "d", "e", "f" });
        map.put(4, new String[] { "g", "h", "i" });
        map.put(5, new String[] { "j", "k", "l" });
        map.put(6, new String[] { "m", "n", "o" });
        map.put(7, new String[] { "p", "q", "r", "s" });
        map.put(8, new String[] { "t", "u", "v" });
        map.put(9, new String[] { "w", "x", "y", "z" });

        if (map.containsKey(n % 10)) {
            String[] temp = map.get(n % 10);
            for (String s : temp) {
                String[] subres = keypad(n / 10);
                for (String t : subres) {
                    list.add(t + s);
                }
            }
        } else {
            return new String[] { "" };
        }
        String result[] = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
