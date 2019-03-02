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
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int n = Integer.parseInt(reader.readLine());
        printPattern(n);
    }

    public static void printPattern(int n) {
        int[][] result = new int[n][n];
        int i = 0, j = 1;
        int incrementor = n - 1;
        int alternator = 1;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                result[i][y] = j++;
            }
            i += incrementor * alternator;
            incrementor--;
            alternator = -alternator;
        }
        printArray(result);
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
