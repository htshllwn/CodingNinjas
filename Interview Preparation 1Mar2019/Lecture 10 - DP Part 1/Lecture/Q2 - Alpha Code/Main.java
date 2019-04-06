// Alice and Bob need to send secret messages to each other and are discussing ways to encode their messages:
// Alice: "Let’s just use a very simple code: We’ll assign ‘A’ the code word 1, ‘B’ will be 2, and so on down to ‘Z’ being assigned 26."

// Bob: "That’s a stupid code, Alice. Suppose I send you the word ‘BEAN’ encoded as 25114. You could decode that in many different ways!"

// Alice: "Sure you could, but what words would you get? Other than ‘BEAN’, you’d get ‘BEAAD’, ‘YAAD’, ‘YAN’, ‘YKD’ and ‘BEKD’. I think you would be able to figure out the correct decoding. And why would you send me the word ‘BEAN’ anyway?"

// Bob: "OK, maybe that’s a bad example, but I bet you that if you got a string of length 5000 there would be tons of different decodings and with that many you would find at least two different ones that would make sense."

// Alice: "How many different decodings?"

// Bob: "Jillions!"
// For some reason, Alice is still unconvinced by Bob’s argument, so she requires a program that will determine how many decodings there can be for a given string using her code.
// Input
// Input will consist of multiple input sets. Each set will consist of a single line of at most 5000 digits representing a valid encryption (for example, no line will begin with a 0). There will be no spaces between the digits. An input line of ‘0’ will terminate the input and should not be processed.
// Output
// For each input set, output the number of possible decodings for the input string. Print your answer taking modulo "10^9+7"
// Sample Input:
// 25114
// 1111111111
// 3333333333
// 0
// Sample Output:
// 6
// 89
// 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static int M = 1_000_000_000 + 7;

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String str = reader.readLine();
            if (str.equals("0"))
                break;
            list.add(str);
        }
        for (String s : list) {
            System.out.println(aplhaCodeCount(s));
        }
    }

    public static int aplhaCodeCount(String str) {
        // Recursive
        // int resREC = aplhaCodeCountREC(str);
        // return resREC;

        // Memoization
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int resMEM = aplhaCodeCountMEM(str, map);
        // System.out.println(map);
        // return resMEM;

        // Tabulation
        int resTAB = aplhaCodeCountTAB(str);
        return resTAB;

    }

    public static int aplhaCodeCountREC(String str) {
        int size = str.length();
        if (size == 0) {
            return 1;
        }
        if (size == 1) {
            return 1;
        }
        int output = 0;
        if (str.charAt(size - 1) != '0') {

            output = (output % M + aplhaCodeCountREC(str.substring(0, size - 1)) % M) % M;
        }
        String sub2 = str.substring(size - 2);
        int num2 = Integer.parseInt(sub2);
        if (num2 >= 10 && num2 <= 26) {
            output += aplhaCodeCountREC(str.substring(0, size - 2));
        }
        return output % 1000000007;
    }

    public static int aplhaCodeCountMEM(String str, HashMap<Integer, Integer> map) {
        int size = str.length();
        if (map.containsKey(size))
            return map.get(size);
        if (size == 0) {
            return 1;
        }
        if (size == 1) {
            return 1;
        }
        int output = 0;
        if (str.charAt(size - 1) != '0') {
            output = (output % M + aplhaCodeCountMEM(str.substring(0, size - 1), map) % M) % M;
        }
        String sub2 = str.substring(size - 2);
        int num2 = Integer.parseInt(sub2);
        if (num2 >= 10 && num2 <= 26) {
            output = (output % M + aplhaCodeCountMEM(str.substring(0, size - 2), map) % M) % M;
        }
        map.put(size, output);
        return output % M;
    }

    public static int aplhaCodeCountTAB(String str) {
        int count1 = 1;
        int count2 = 1;
        int lastDigit = -1;
        for (String strIter = str; !strIter.equals(""); strIter = strIter.substring(0, strIter.length() - 1)) {
            int part1 = Integer.parseInt("" + strIter.charAt(strIter.length() - 1));

            int count = 0;
            char c1 = 'A';
            c1 += part1 - 1;
            if (c1 >= 'A' && c1 <= 'Z') {
                count = (count % M + count1 % M) % M;
            }
            if (lastDigit != -1) {
                int part2 = part1 * 10 + lastDigit;
                char c2 = 'A';
                c2 += part2 - 1;
                if (c2 >= 'J' && c2 <= 'Z') {
                    count = (count % M + count2 % M) % M;
                }
            }
            lastDigit = part1;

            count2 = count1;
            count1 = count;
        }
        return count1 % M;
    }

}
