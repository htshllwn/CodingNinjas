
// Given an N*N integer square matrix, rotate it by 90 degrees in anti-clockwise direction.
// Try using it without any extra space.
// Note : You just need to change in the given input itself. No need to return or print anything.
// Input format :
// Line 1 : Integers N
// Next N lines : N integers, elements of one row (separated by space)
// Output Format :
// Updated matrix
// Constraints :
// 1 <= N <= 1000
// Sample Input :
// 3
// 1 2 3
// 4 5 6
// 7 8 9
// Sample Output :
// 3  6  9 
// 2  5  8 
// 1  4  7

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int n = Integer.parseInt(reader.readLine().trim());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(reader.readLine().trim().split("\\s")).mapToInt(Integer::parseInt).toArray();
        }
        rotate(arr);
        printArray(arr);
    }

    public static void rotate(int input[][]) {
        int n = input.length;
        int firstIndex = 0;
        int lastIndex = n - 1;
        int x = n;

        while (x > 1) {
            int i1 = firstIndex, j1 = firstIndex;
            int i2 = lastIndex, j2 = firstIndex;
            int i3 = lastIndex, j3 = lastIndex;
            int i4 = firstIndex, j4 = lastIndex;
            for (int k = 0; k < lastIndex - firstIndex; k++) {
                int temp = input[i4][j4];
                input[i4][j4] = input[i3][j3];
                input[i3][j3] = input[i2][j2];
                input[i2][j2] = input[i1][j1];
                input[i1][j1] = temp;
                i1++;
                j2++;
                i3--;
                j4--;
            }
            firstIndex += 1;
            lastIndex -= 1;
            x -= 2;
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
