
// Sort an array A using Quick Sort.
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
        quickSort(arr);
        for (int v : arr)
            System.out.print(v + " ");
        System.out.println();
    }

    public static void quickSort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    public static void quickSort(int[] input, int start, int end) {
        if (start >= end)
            return;
        int c = partition(input, start, end);
        quickSort(input, start, c - 1);
        quickSort(input, c + 1, end);
    }

    public static int partition(int[] input, int start, int end) {
        int i = start, j = end;

        int count = 0;
        for (int x = start; x <= end; x++) {
            if (input[start] > input[x])
                count++;
        }
        int pivot = start + count;
        swap(input, start, pivot);

        while (i <= pivot - 1 && j >= pivot + 1) {
            while (input[i] < input[pivot])
                i++;
            while (input[j] >= input[pivot])
                j--;
            if (i >= pivot || j <= pivot)
                break;
            else
                swap(input, i, j);
        }

        return pivot;
    }

    public static void swap(int[] input, int i, int j) {
        // System.out.println(i + ", " + j);
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
