
// Given an array, find and return the length of longest subarray containing equal number of 0s and 1s.
// Input Format :
// Line 1 : Integer N, size of array
// Line 2 : Array elements (separated by space)
// Output Format :
// Length of longest subarray
// Contraints :
// 1<= N <=10^6
// Sample Input 1 :
// 6 
// 1 0 0 1 1 1
// Sample Output 1 :
// 4    
// Sample Input 2 :
// 10 
// 1 1 1 0 0 0 1 1 0 0
// Sample Output 2 :
// 10

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
        System.out.println(max(arr));
    }

    public static int max(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            count += arr[i] == 1 ? 1 : -1;
            if (map.containsKey(count)) {
                int tempIndex = map.get(count);
                if (i > tempIndex) {
                    map.put(count, i);
                }
            } else {
                map.put(count, i);
            }
        }

        int noOfOnes = 0;
        int noOfZeros = 0;
        for (int i = 0; i < arr.length; i++) {
            int diff = noOfOnes - noOfZeros;
            if (map.containsKey(diff)) {
                int largestIndex = map.get(diff);
                int length = largestIndex - i + 1;
                max = length > max ? length : max;
            }
            if (arr[i] == 1) {
                noOfOnes++;
            } else {
                noOfZeros++;
            }
        }

        return max;
    }

}
