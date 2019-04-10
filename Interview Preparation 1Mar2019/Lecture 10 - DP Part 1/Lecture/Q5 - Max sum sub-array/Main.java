
// Given an integer array containing both negative and positive integers. Find and return the sum of contiguous sub-array with maximum sum.
// Input Format :
// Line 1: Integer N, size of input array
// Line 2: N integers, elements of input array (separated by space)
// Output Format :
// Maximum Sum of the contiguous sub-array
// Contraints :
// 1 = N = 1000
// -100 = A[i] <= 100
// Sample Input 1:
// 3
// 1 2 3
// Sample Output 1:
// 6
// Sample Input 2:
// 4
// -1 -2 -3 -4
// Sample Output 2:
// -1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findSum(arr, n));
    }

    public static int findSum(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(-1, sum);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            map.put(i, sum);
        }
        int res = Integer.MIN_VALUE;
        for (int j = 1; j <= arr.length; j++) {
            for (int i = j - 1; i < arr.length; i++) {
                int tempSum = map.get(i) - map.get(i - j);
                if (tempSum > res)
                    res = tempSum;
            }
        }
        return res;
    }
}
