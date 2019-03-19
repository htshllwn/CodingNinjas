// You are given with an array (of size N) consisting of positive and negative integers that contain numbers in random order.
// Write a program to return true if there exists a sub-array whose sum is zero else, return false.
// Input Format :
// Line 1 : An Integer N i.e. size of array 
// Line 2 : N integers, elements of the array (separated by space)
// Output Format :
// true or false
// Constraints :
// 1 <= N <= 10^5
// Sample Input 1 :
// 6 
// 7 1 3 -4 5 1
// Sample Output 1 :
// true
// Sample Input 2 :
// 5 
// -6 7 6 2 1
// Sample Output 2 :
// false

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        System.out.println(subarraySumTo0(arr));
    }

    public static boolean subarraySumTo0(int[] input) {
        int c_sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            c_sum += input[i];

            if (c_sum == 0) {
                return true;
            }

            if (map.containsKey(c_sum)) {
                return true;
            }

            map.put(c_sum, i);
        }

        return false;
    }
}
