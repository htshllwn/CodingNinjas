
// Given the code to find out and return the number of digits present in a number recursively. But it contains few bugs, that you need to rectify such that all the test cases should pass.
// Input Format :
// Integer n
// Output Format :
// Count of digits
// Constraints :
// 1 <= n <= 10^6
// Sample Input :
//  156
// Sample Output :
// 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int n = Integer.parseInt(reader.readLine());
        System.out.println(count(n));
    }

    public static int count(int n) {
        if (n == 0) {
            return 0;
        }
        int smallAns = count(n / 10);
        return smallAns + 1;
    }
}
