
// Given a random integer array A of size N. Find and print the pair of elements in the array which sum to 0.
// Array A can contain duplicate elements.
// While printing a pair, print the smaller element first.
// That is, if a valid pair is (6, -6) print "-6 6". There is no constraint that out of 5 pairs which have to be printed in 1st line. You can print pairs in any order, just be careful about the order of elements in a pair.
// Input format :
// Line 1 : Integer N (Array size)
// Line 2 : Array elements (separated by space)
// Output format :
// Line 1 : Pair 1 elements (separated by space)
// Line 2 : Pair 2 elements (separated by space)
// Line 3 : and so on
// Constraints :
// 1 <= N <= 10^6
// Ai contains all non-zero values
// Sample Input:
// 5
// 2 1 -2 2 3
// Sample Output :
// -2 2
// -2 2

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
        PairSum(arr, n);
    }

    public static void PairSum(int[] input, int size) {
        HashMap<Integer, Integer> negMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> posMap = new HashMap<Integer, Integer>();
        int noOfZeros = 0;

        for (int e : input) {
            if (e == 0) {
                noOfZeros++;
            } else if (e < 0) {
                if (negMap.containsKey(e)) {
                    int temp = negMap.get(e);
                    negMap.put(e, temp + 1);
                } else {
                    negMap.put(e, 1);
                }
            } else if (e > 0) {
                if (posMap.containsKey(e)) {
                    int temp = posMap.get(e);
                    posMap.put(e, temp + 1);
                } else {
                    posMap.put(e, 1);
                }
            }
        }

        // Print (0, 0) pairs
        for (int i = 0; i < noOfZeros * noOfZeros; i++) {
            System.out.println("0 0");
        }

        for (int negK : negMap.keySet()) {
            int posK = -1 * negK;
            if (posMap.containsKey(posK)) {
                int negV = negMap.get(negK);
                int posV = posMap.get(posK);

                for (int i = 0; i < negV * posV; i++) {
                    System.out.println(negK + " " + posK);
                }
            }
        }

    }
}
