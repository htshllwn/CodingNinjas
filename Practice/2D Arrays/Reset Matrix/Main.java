// Given an m x n matrix of 0s and 1s, 
// if an element is 0, set its entire 
// row and column to 0. Do it in place.
// Note : You don't need to print the matrix. 
// Just change in the given input.

// Input format :

// Line 1 : No. of rows & No. of columns 
// (separated by space)

// Line 2 : Row 1 elements (separated by space)

// Line 3 : Row 2 elements (separated by space)

// Line 4 : and so on

// Sample Input 1 :
// 3 3
// 1 0 1
// 1 1 1 
// 1 1 1
// Sample Output 1 :
// 0 0 0
// 1 0 1
// 1 0 1

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] input = { { 1, 0, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        printArray(input);
        makeRowsCols0(input);
        printArray(input);
    }

    public static void makeRowsCols0(int[][] input) {
        // Write your code here
        List<int[]> changes = new ArrayList<int[]>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 0) {
                    changes.add(new int[] { i, j });
                }
            }
        }
        for (int[] row : changes) {
            resetRowNCol(input, row[0], row[1]);
        }
    }

    public static void resetRowNCol(int[][] input, int i, int j) {
        for (int x = 0; x < input[i].length; x++) {
            input[i][x] = 0;
        }
        for (int x = 0; x < input.length; x++) {
            input[x][j] = 0;
        }
    }

    public static void printArray(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
