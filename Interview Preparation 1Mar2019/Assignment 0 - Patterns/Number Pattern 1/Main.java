// Print the following pattern
// Pattern for N = 4
//     1
//    23
//   345
//  4567
// Input Format :
// N (Total no. of rows)
// Output Format :
// Pattern in N lines
// Sample Input :
// 5
// Sample Output :
//       1
//      23
//     345
//    4567
//   56789

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int n = Integer.parseInt(reader.readLine());
        printPattern(n);
    }

    public static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n - 1; j >= i; j--) {
                System.out.print(" ");
            }
            int x = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(x++);
            }
            System.out.println();
        }
    }
}
