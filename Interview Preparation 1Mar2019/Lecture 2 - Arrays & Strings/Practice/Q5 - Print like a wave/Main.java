// Given a two dimensional n*m array, print the array in a sine wave order. i.e. print the first column top to bottom, next column bottom to top and so on.
// Note : Print the elements separated by space.
// Input format :
// n, m, array elements (separated by space)
// Sample Input :
// 3 4 1 2 3 4 5 6 7 8 9 10 11 12
// Sample Output :
// 1 5 9 10 6 2 3 7 11 12 8 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        String[] text = reader.readLine().trim().split("\\s");

        int n = Integer.parseInt(text[0]);
        int m = Integer.parseInt(text[1]);
        int[][] arr = new int[n][m];
        int t = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(text[t++]);
            }
        }

        printArray(arr);
        wavePrint(arr);
    }

    public static void wavePrint(int input[][]) {
        int i = -1, c = 1;
        for (int j = 0; j < input[0].length; j++) {
            for (int k = 0; k < input.length; k++) {
                i += c;
                System.out.print(input[i][j] + " ");
            }
            i += c;
            c = -c;
        }
	}

    public static void printArray(int[][] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
