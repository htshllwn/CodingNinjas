// Print the following pattern for the given number of rows.
// Pattern for N = 3
//      1
//     232
//    34543
// Input format :
// Integer N (Total no. of rows)
// Output format :
// Pattern in N lines
// Sample Input :
// 5
// Sample Output :
//        1
//       232
//      34543
//     4567654
//    567898765

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int n = Integer.parseInt(reader.readLine());
        printTriangle(n);
    }

    public static void printTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.print(i);
            int x = i + 1;
            for (int j = i - 1; j > 0; j--) {
                System.out.print(x++);
            }
            for (int y = x - 2; y >= i; y--) {
                System.out.print(y);
            }
            System.out.println();
        }
    }
}
