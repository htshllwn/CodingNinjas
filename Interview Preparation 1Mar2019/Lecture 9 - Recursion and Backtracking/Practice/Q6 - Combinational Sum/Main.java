// Given an array of integers A and an integer B. Find and return all unique combinations in A where the sum of elements is equal to B.
// Elements of input array can be repeated any number of times.
// One combination should be saved in increasing order. Order of different combinations doesn't matter.
// Note : All numbers in input array are positive integers.
// Input Format :
// Line 1 : Integer n
// Line 2 : n integers (separated by space)
// Line 3 : Integer B (i.e. sum)
// Output Format :
// Combinations in different lines
// Contraints :
// 1<= N <=1000
// Sample Input 1 :
// 4
// 7 2 6 5
// 16
// Sample Output 1 :
// 2 2 2 2 2 2 2 2 
// 2 2 2 2 2 6 
// 2 2 2 5 5 
// 2 2 5 7 
// 2 2 6 6 
// 2 7 7 
// 5 5 6
// Sample Input 2 :
// 4
// 2 4 6 8
// 8
// Sample Output 2 :
// 2 2 2 2 
// 2 2 4 
// 2 6 
// 4 4 
// 8 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(reader.readLine());
        ArrayList<ArrayList<Integer>> result = combinationSum(arr, k);
        for (ArrayList<Integer> list : result) {
            for (int v : list) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        combinationSum(arr, sum, 0, new ArrayList<Integer>(), list);
        return list;
    }

    public static void combinationSum(int[] arr, int sum, int currSum, ArrayList<Integer> currList,
            ArrayList<ArrayList<Integer>> list) {
        if (sum == currSum) {
            Collections.sort(currList);
            list.add((ArrayList) currList.clone());
            return;
        }
        if (currSum > sum || arr.length < 1) {
            return;
        }
        currList.add(arr[0]);
        combinationSum(arr, sum, currSum + arr[0], currList, list);
        currList.remove(new Integer(arr[0]));
        combinationSum(Arrays.copyOfRange(arr, 1, arr.length), sum, currSum, currList, list);
    }
}
