// Print the following pattern for the given number of rows.
// Assume N is always odd.
// Note : There is space after every star.
// Pattern for N = 7
// *
//  * *
//   * * *
//    * * * *
//   * * *
//  * *
// *
// Input format :
// Integer N (Total no. of rows)
// Output format :
// Pattern in N lines
// Sample Input :
// 11
// Sample Output :
// *
//  * *
//   * * *
//    * * * *
//     * * * * *
//      * * * * * *
//     * * * * *
//    * * * *
//   * * *
//  * *
// *

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int n = Integer.parseInt(reader.readLine());
        
        printArrowPattern(n);
    }

    public static void printArrowPattern(int n) {
        int mid = (n / 2) + 1;
        int midSpaces = n / 2;
        for (int i = 1; i <= n; i++) {
            int j = i > mid ? 2 * mid - i : i;
            int noOfSpaces = midSpaces - (mid - j);
            for (int x = 1; x <= noOfSpaces; x++) {
                System.out.print(" ");
            }
            for (; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
