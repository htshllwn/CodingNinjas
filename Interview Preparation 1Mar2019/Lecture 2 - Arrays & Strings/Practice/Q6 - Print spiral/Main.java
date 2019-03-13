// Given an N*M 2D array, print it in spiral form. That is, first you need to print the 1st row, then last column, then last row and then first column and so on.
// Print every element only once.
// Input format :
// Line 1 : N and M, No. of rows & No. of columns (separated by space) followed by N*M  elements in row wise fashion.
// Sample Input :
// 4 4 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
// Sample Output :
// 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

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
        spiralPrint(arr);
    }

    public static void spiralPrint(int matrix[][]){
        int iCounter = matrix.length - 1;
        int jCounter = matrix[0].length;
        int ic = 1, jc = 1;
        int i = 0, j = -1;
        
        while (jCounter > 0 && iCounter >= 0) {
            for (int k = 0; k < jCounter; k++) {
                j += jc;
                System.out.print(matrix[i][j] + " ");
            }
            for (int k = 0; k < iCounter; k++) {
                i += ic;
                System.out.print(matrix[i][j] + " ");
            }
            ic = -ic;
            jc = -jc;
            jCounter -= 1;
            iCounter -= 1;

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
