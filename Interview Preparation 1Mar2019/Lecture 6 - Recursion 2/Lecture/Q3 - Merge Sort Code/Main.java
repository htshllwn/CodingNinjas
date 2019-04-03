
// Sort an array A using Merge Sort.
// Change in the input array itself. So no need to return or print anything.
// Input format :
// Line 1 : Integer n i.e. Array size
// Line 2 : Array elements (separated by space)
// Output format :
// Array elements in increasing order (separated by space)
// Constraints :
// 1 <= n <= 1000
// Sample Input:
// 6 
// 2 6 8 5 4 3
// Sample Output:
// 2 3 4 5 6 8

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
        mergeSort(arr);
        for (int v : arr)
            System.out.print(v + " ");
        System.out.println();
    }

    public static void mergeSort(int[] input) {
        mergeSort(input, 0, input.length - 1);
    }

    public static void mergeSort(int[] input, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid + 1, end);
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end) {
        int[] newArr = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int x = -1;
        while (i <= mid && j <= end) {
            if (input[i] <= input[j]) {
                newArr[++x] = input[i++];
            } else {
                newArr[++x] = input[j++];
            }
        }
        while (i <= mid) {
            newArr[++x] = input[i++];
        }
        while (j <= end) {
            newArr[++x] = input[j++];
        }
        for (int v : newArr) {
            input[start++] = v;
        }
    }
}
