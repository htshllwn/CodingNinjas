// Given an array of length N and an integer x, you need to find if x is present in the array or not. Return true or false.
// Do this recursively.
// Input Format :
// Line 1 : An Integer N i.e. size of array
// Line 2 : N integers which are elements of the array, separated by spaces
// Line 3 : Integer x
// Output Format :
// true or false
// Constraints :
// 1 <= N <= 10^3
// Sample Input :
// 3
// 9 8 10
// 8
// Sample Output :
// true

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
        int x = Integer.parseInt(reader.readLine());
        System.out.println(checkNumber(arr, x));
    }

    public static boolean checkNumber(int input[], int x) {
        if (input.length > 1) {
            if (input[0] == x)
                return true;
            else
                return checkNumber(Arrays.copyOfRange(input, 1, input.length), x);
        } else {
            return input[0] == x;
        }
    }
}