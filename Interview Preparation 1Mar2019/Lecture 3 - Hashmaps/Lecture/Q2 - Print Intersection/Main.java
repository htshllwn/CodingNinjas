
// Given two random integer arrays, print their intersection. That is, print all the elements that are present in both the given arrays.
// Input arrays can contain duplicate elements.
// Note : Order of elements are not important
// Input format :
// Line 1 : Integer N, Array 1 Size
// Line 2 : Array 1 elements (separated by space)
// Line 3 : Integer M, Array 2 Size
// Line 4 : Array 2 elements (separated by space)
// Output format :
// Print intersection elements in different lines
// Constraints :
// 1 <= M, N <= 10^6
// Sample Input 1 :
// 6
// 2 6 8 5 4 3
// 4
// 2 3 4 7 
// Sample Output 1 :
// 2 
// 4 
// 3
// Sample Input 2 :
// 4
// 2 6 1 2
// 5
// 1 2 3 4 2
// Sample Output 2 :
// 2 
// 2
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
        int[] arrN = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(reader.readLine());
        int[] arrM = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        intersection(arrN, arrM);
    }

    public static void intersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();

        for (int e : arr1) {
            if (map1.containsKey(e)) {
                int temp = map1.get(e);
                map1.put(e, temp + 1);
            } else {
                map1.put(e, 1);
            }
        }

        for (int e : arr2) {
            if (map2.containsKey(e)) {
                int temp = map2.get(e);
                map2.put(e, temp + 1);
            } else {
                map2.put(e, 1);
            }
        }

        for (int k : map1.keySet()) {
            if (map2.containsKey(k)) {
                int v1 = map1.get(k);
                int v2 = map2.get(k);
                int counter = v1 <= v2 ? v1 : v2;
                for (int i = 0; i < counter; i++) {
                    System.out.println(k);
                }
            }
        }

    }
}
