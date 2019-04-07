
// Given an array with N elements, you need to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in strictly increasing order.
// Input Format
// Line 1 : An integer N 
// Line 2 : Elements of arrays separated by spaces
// Output Format
// Line 1 : Length of longest subsequence
// Input Constraints
// 1 <= n <= 10^3
// Sample Input :
// 6
// 5 4 11 1 16 8
// Sample Output 1 :
// 3
// Sample Output Explanation
// Length of longest subsequence is 3 i.e. (5,11,16) or (4,11,16).
// Sample Input 2:
// 3
// 1 2 2
// Sample Output 2 :
// 2

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
        System.out.println(lis(arr));
    }

    public static int lis(int arr[]) {
        int[] output = new int[arr.length];
        output[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            int res = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    int tempRes = output[j] + 1;
                    if (tempRes > res)
                        res = tempRes;
                }
            }
            output[i] = res;
        }
        int max = 0;
        for (int v : output) {
            if (max < v)
                max = v;
        }
        return max;
    }
}