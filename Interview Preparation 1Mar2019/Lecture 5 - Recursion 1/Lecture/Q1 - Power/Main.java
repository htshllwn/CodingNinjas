
// Write a program to find x to the power n (i.e. x^n). Take x and n from the user. You need to return the answer.
// Do this recursively.
// Input format :
// Two integers x and n (separated by space)
// Output Format :
// x^n (i.e. x raise to the power n)
// Constraints :
// 1 <= x <= 30
// 0 <= n <= 30
// Sample Input 1 :
//  3 4
// Sample Output 1 :
// 81
// Sample Input 2 :
//  2 5
// Sample Output 2 :
// 32

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        System.out.println(power(arr[0], arr[1]));
    }

    public static int power(int x, int n) {
        if (n == 0)
            return 1;
        return x * power(x, n - 1);
    }
}
