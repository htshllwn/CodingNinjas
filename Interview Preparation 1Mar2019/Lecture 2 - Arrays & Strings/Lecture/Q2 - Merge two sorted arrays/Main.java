
// Given two sorted arrays of Size M and N respectively, 
// merge them into a third array such that the third array is also sorted.
// Input Format :
//  Line 1 : Size of first array i.e. M
//  Line 2 : M elements of first array separated by space
//  Line 3 : Size of second array i.e. N
//  Line 2 : N elements of second array separated by space
// Output Format :
// M + N integers i.e. elements of third sorted array separated by spaces.
// Constraints :
// 1 <= M, N <= 10^6
// Sample Input :
// 5
// 1 3 4 7 11
// 4
// 2 4 6 13
// Sample Output :
// 1 2 3 4 4 6 7 11 13 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int m = Integer.parseInt(reader.readLine());

        int[] mArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        int n = Integer.parseInt(reader.readLine());

        int[] nArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        int[] result = merge(mArr, nArr);

        for (int e : result) {
            System.out.print(e + " ");
        }
    }

    public static int[] merge(int arr1[], int arr2[]) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr2[j] > arr1[i]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        if (i == arr1.length) {
            while (j < arr2.length) {
                result[k++] = arr2[j++];
            }
        }
        if (j == arr2.length) {
            while (i < arr1.length) {
                result[k++] = arr1[i++];
            }
        }

        return result;
    }
}
