
// Given the code to print number from 1 to n in increasing order recursively. But it contains few bugs, that you need to rectify such that all the test cases should pass.
// Input Format :
// Integer n
// Output Format :
// Numbers from 1 to n (separated by space)
// Constraints :
// 1 <= n <= 10000
// Sample Input :
//  6
// Sample Output :
// 1 2 3 4 5 6

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int n = Integer.parseInt(reader.readLine());
        print(n);
    }

    public static void print(int n) {
        if (n == 1) {
            System.out.print(n + " ");
        } else {
            print(n - 1);
            System.out.print(n + " ");
        }
    }
}