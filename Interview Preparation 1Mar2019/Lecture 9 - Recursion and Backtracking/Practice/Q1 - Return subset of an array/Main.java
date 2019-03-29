// Given an integer array (of length n), find and return all the subsets of input array.
// Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
// Note : The order of subsets are not important.
// Input format :

// Line 1 : Size of array

// Line 2 : Array elements (separated by space)

// Sample Input:
// 3
// 15 20 12
// Sample Output:
// [] (this just represents an empty array, don't worry about the square brackets)
// 12 
// 20 
// 20 12 
// 15 
// 15 12 
// 15 20 
// 15 20 12 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[][] result = subsets(arr);
        for (int[] a : result) {
            for (int v : a) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static int[][] subsets(int input[]) {
        if (input.length == 1) {
            return new int[][] { { input[0] } };
        }
        int firstElement = input[0];
        int[][] subSol = subsets(Arrays.copyOfRange(input, 1, input.length));
        int[][] result = new int[subSol.length * 2 + 1][];
        int i = 0;
        result[i++] = new int[] { firstElement };
        for (int[] arr : subSol) {
            result[i++] = arr;
            int[] temp = new int[arr.length + 1];
            temp[0] = firstElement;
            for (int j = 1, k = 0; j < temp.length; j++) {
                temp[j] = arr[k++];
            }
            result[i++] = temp;
        }
        return result;
    }
}
