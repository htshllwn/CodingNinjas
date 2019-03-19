
// You are given with an array of integers that contain numbers in random order. Write a program to find the longest possible sub sequence of consecutive numbers using the numbers from given array.
// You need to return the output array which contains consecutive elements. Order of elements in the output is not important.
// Best solution takes O(n) time.
// If two arrays are of equal length return the array whose index of smallest element comes first.
// Input Format :
// Line 1 : Integer n, Size of array
// Line 2 : Array elements (separated by space)
// Constraints :
// 1 <= n <= 10^5
// Sample Input 1 :
// 13
// 2 12 9 16 10 5 3 20 25 11 1 8 6 
// Sample Output 1 :
// 8 9 10 11 12
// Sample Input 2 :
// 7
// 15 13 23 21 19 11 16
// Sample Output 2 :
// 15 16

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
        ArrayList<Integer> result = longestSubsequence(arr);
        for (int v : result) {
            System.out.println(v);
        }
    }

    public static ArrayList<Integer> longestSubsequence(int[] arr) {
        HashMap<Integer, Boolean> map = new LinkedHashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int v : arr) {
            map.put(v, false);
        }
        for (int e : map.keySet()) {
            if (!map.get(e)) {
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(e);
                map.put(e, true);
                for (int i = 1; map.containsKey(e + i); i++) {
                    tempList.add(e + i);
                    map.put(e + i, true);
                }
                if (result.size() < tempList.size()) {
                    result = tempList;
                }
            }
        }
        return result;
    }
}
