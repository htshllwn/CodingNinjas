
// Given an integer n, count and return the number of zeros that are present in the given integer using recursion.
// Input Format :
// Integer n
// Output Format :
// No. of 0s
// Sample Input :
// 10204
// Sample Output
// 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int n = Integer.parseInt(reader.readLine());
        System.out.println(countZerosRec(n));
    }

    public static int countZerosRec(int input) {
        if (input == 0)
            return 0;
        int n = input % 10;
        int c = 0;
        if (n == 0)
            c = 1;
        return c + countZerosRec(input / 10);
    }
}
