
// You are given with an array of integers and an integer K. Write a program to find and print all pairs which have difference K.
// Best solution takes O(n) time. And take difference as absolute.
// Input Format :
// Line 1 : Integer n, Size of array
// Line 2 : Array elements (separated by space)
// Line 3 : K
// Output format :
// Print pairs in different lines (pair elements separated by space). In a pair, smaller element should be printed first.
// (Order of different pairs is not important)
// Constraints :
// 1 <= n <= 5000
// Sample Input 1 :
// 4 
// 5 1 2 4
// 3
// Sample Output 1 :
// 2 5
// 1 4
// Sample Input 2 :
// 4
// 4 4 4 4 
// 0
// Sample Output 2 :
// 4 4
// 4 4
// 4 4
// 4 4
// 4 4
// 4 4

import java.util.ArrayList;
import java.util.HashMap;

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
        findPairsDifferenceK(arr, k);
    }

    public static void findPairsDifferenceK(int[] input, int k) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer, HashMap<Integer, String>> pairs = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int v = input[i];
            if (map.containsKey(v)) {
                map.get(v).add(i);
            } else {
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(i);
                map.put(v, tempList);
            }
        }
        for (int i = 0; i < input.length; i++) {
            int v = input[i];
            int calcVal = v - k;
            if (map.containsKey(calcVal)) {
                for (int j : map.get(calcVal)) {
                    if (i != j) {
                        int lowerIndex = i < j ? i : j;
                        int higherIndex = i > j ? i : j;
                        int newValue = input[j];
                        int lowerValue = v < newValue ? v : newValue;
                        int higherValue = v > newValue ? v : newValue;
                        String str = lowerValue + " " + higherValue;
                        if (pairs.containsKey(lowerIndex)) {
                            if (pairs.get(lowerIndex).containsKey(higherIndex)) {
                                // Pair already present
                            } else {
                                pairs.get(lowerIndex).put(higherIndex, str);
                            }
                        } else {
                            HashMap<Integer, String> tempMap = new HashMap<>();
                            tempMap.put(higherIndex, str);
                            pairs.put(lowerIndex, tempMap);
                        }
                    }
                }
            }
        }
        for (int v1 : pairs.keySet()) {
            for (int v2 : pairs.get(v1).keySet()) {
                System.out.println(pairs.get(v1).get(v2));
            }
        }
    }
}
