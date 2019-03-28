// Given two integers m & n, calculate and return their multiplication using recursion. You can only use subtraction and addition for your calculation. No other operators are allowed.
// Input format : m and n (in different lines)

// Sample Input :
// 3 
// 5
// Sample Output -
// 15

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int m = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        System.out.println(multiplyTwoIntegers(m, n));
    }

    public static int multiplyTwoIntegers(int m, int n) {
        if (n == 0)
            return 0;
        return m + multiplyTwoIntegers(m, n - 1);
    }
}
