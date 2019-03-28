
// Write a recursive function that returns the sum of the digits of a given integer.
// Sample Input :
// 12345
// Sample Output :
// 15

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int n = Integer.parseInt(reader.readLine());
        System.out.println(sumOfDigits(n));
    }

    public static int sumOfDigits(int input) {
        if (input == 0)
            return 0;
        return input % 10 + sumOfDigits(input / 10);
    }
}
