
// Given an array A and an integer K, print all subsets of A which sum to K.
// Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
// Note : The order of subsets are not important. Just print them in different lines.
// Input format :
// Line 1 : Size of input array
// Line 2 : Array elements separated by space
// Line 3 : K 
// Sample Input:
// 9 
// 5 12 3 17 1 18 15 3 17 
// 6
// Sample Output:
// 3 3
// 5 1

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
        int k = Integer.parseInt(reader.readLine());
        printSubsetsSumTok(arr, k);

    }

    public static void printSubsetsSumTok(int input[], int k) {
        printSubsetsSumTok(input, k, 0, "");
    }

    public static void printSubsetsSumTok(int input[], int k, int sum, String res) {
        if (k == sum) {
            System.out.println(res.trim());
            return;
        }
        if (input.length == 0) {
            return;
        }
        int firstElement = input[0];
        int[] newInput = Arrays.copyOfRange(input, 1, input.length);
        printSubsetsSumTok(newInput, k, sum + firstElement, res + firstElement + " ");
        printSubsetsSumTok(newInput, k, sum, res);
    }
}