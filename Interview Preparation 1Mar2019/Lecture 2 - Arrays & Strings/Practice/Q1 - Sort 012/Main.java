
// You are given an integer array containing only 0s, 1s and 2s. Write a solution to sort this array using one scan only.
// You need to change in the given array itself. So no need to return or print anything.
// Input format :
// Line 1 : Integer n (Array Size)
// Line 2 : Array elements (separated by space)
// Output Format :
// Updated array elements (separated by space)
// Constraints :
// 1 <= n <= 10^6
// Sample Input:
// 7
// 0 1 2 0 2 0 1
// Sample Output:
// 0 0 0 1 1 2 2

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

        System.out.println("Before Sorting");
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();

        System.out.println("After Sorting");
        sort012(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void sort012(int[] arr) {
        int[] counts = new int[3];
        for (int e : arr) {
            counts[e]++;
        }
        for (int i = 0, k = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                arr[k++] = i;
            }
        }
    }
}
