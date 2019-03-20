// Given an integer array, find and return the minimum distance between indexes of an element and its repetition.
// Input Format :
// Line 1 : Integer N, Size of array
// Line 2 : Elements of the array (separated by space)
// Output Format :
// Print the minimum distance 
// Contraints :
// 1<= N <=10^6
// Sample Input 1:
// 6
// 1 3 1 5 4 3
// Sample Output 1:
// 2
// Sample Input 2:
// 7
// 5 47 82 4 4 6 2 
// Sample Output 2:
// 1

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
        System.out.println(minDistance(arr));
    }

    public static int minDistance(int[] arr) {
        HashMap<Integer, Integer> occurences = new HashMap<Integer, Integer>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            if (occurences.containsKey(v)) {
                int lastOccurence = occurences.get(v);
                int distance = i - lastOccurence;
                min = distance < min ? distance : min;
            }
            occurences.put(v, i);
        }

        return min;
    }
}
