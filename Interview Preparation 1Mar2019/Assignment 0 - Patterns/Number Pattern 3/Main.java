// Print the following pattern
// Pattern for N = 4
// 4 4 4 4 4 4 4 
// 4 3 3 3 3 3 4 
// 4 3 2 2 2 3 4 
// 4 3 2 1 2 3 4 
// 4 3 2 2 2 3 4 
// 4 3 3 3 3 3 4 
// 4 4 4 4 4 4 4 
// Input Format :
// N (Total no. of rows)
// Output Format :
// Pattern in N lines
// Sample Input 1 :
// 5
// Sample Output 1 :
// 5 5 5 5 5 5 5 5 5 
// 5 4 4 4 4 4 4 4 5 
// 5 4 3 3 3 3 3 4 5 
// 5 4 3 2 2 2 3 4 5 
// 5 4 3 2 1 2 3 4 5 
// 5 4 3 2 2 2 3 4 5 
// 5 4 3 3 3 3 3 4 5 
// 5 4 4 4 4 4 4 4 5 
// 5 5 5 5 5 5 5 5 5 

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
        int max = 2 * n - 1;
        int p = n;
        for (int i = 1; i <= max; i++) {
            int x = n + 1;
            int jMax = i > n ? max - i : i - 1;
            int kMax = i > n ? 2 * i - max : max - 2 * (i - 1);
            for (int j = 1; j <= jMax; j++) {
                System.out.print(--x + " ");
            }
            for (int k = 1; k <= kMax; k++) {
                System.out.print(p + " ");
            }
            for (int j = 1; j <= jMax; j++) {
                System.out.print(x++ + " ");
            }
            System.out.println();
            p += i >= n ? 1 : -1;
        }
	}
}
