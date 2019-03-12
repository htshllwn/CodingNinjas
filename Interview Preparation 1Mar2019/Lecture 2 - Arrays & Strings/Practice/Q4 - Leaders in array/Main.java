// Given an integer array A of size n. Find and print all the leaders present in the input array. An array element A[i] is called Leader, if all the elements following it (i.e. present at its right) are less than or equal to A[i].
// Print all the leader elements separated by space and in the same order they are present in the input array.
// Input Format :
// Line 1 : Integer n, size of array
// Line 2 : Array A elements (separated by space)
// Output Format :
//  leaders of array (separated by space)
// Constraints :
// 1 <= n <= 10^6
// Sample Input 1 :
// 6
// 3 12 34 2 0 -1
// Sample Output 1 :
// 34 2 0 -1
// Sample Input 2 :
// 5
// 13 17 5 4 6
// Sample Output 2 :
// 17 6

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

        leaders(arr);
    }

    public static void leaders(int[] input) {
        int[] comparisons = new int[input.length];
        String result = "";
        
        int max = Integer.MIN_VALUE;
        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i] > max) {
                max = input[i];
            }
            comparisons[i] = max;
        }
        
        for (int i = 0; i < input.length; i++) {
            if (input[i] >= comparisons[i]) {
                result += input[i] + " ";
            }
        }
        
        System.out.println(result);
	}
}
