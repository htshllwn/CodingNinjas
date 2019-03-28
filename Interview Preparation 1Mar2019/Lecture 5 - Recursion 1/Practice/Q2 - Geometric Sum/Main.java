
// Given k, find the geometric sum i.e.
// 1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k) 
// using recursion. Return the answer.
// Sample Input :
// 3
// Sample Output :
// 1.875

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int n = Integer.parseInt(reader.readLine());
        System.out.println(findGeometricSum(n));
    }

    public static double findGeometricSum(int k) {
        if (k == 0)
            return 1;
        return 1 / (Math.pow(2, k)) + findGeometricSum(k - 1);
    }
}
