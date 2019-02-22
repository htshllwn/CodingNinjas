// Print the following pattern for the given number of rows.
// Pattern for N = 5
//  1    2   3    4   5
//  11   12  13   14  15
//  21   22  23   24  25
//  16   17  18   19  20
//  6    7    8   9   10

// Input format : N (Total no. of rows)

// Output format : Pattern in N lines

// Sample Input :
// 4
// Sample Output :
//  1  2  3  4
//  9 10 11 12
// 13 14 15 16
//  5  6  7  8

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        printPattern(n);
    }

	/* Input
	 * n - number of rows */
	public static void printPattern(int n){

        // Write your code here
        int [][] result = new int[n][n];

        for (int i = 0, j = n - 1, k = 1; i <= j; i++, j--) {
            for (int l = 0; l < n; l++, k++) {
                result[i][l] = k;
            }
            if (i == j) break;
            for (int l = 0; l < n; l++, k++) {
                result[j][l] = k;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
	}
	
}
