
// You are given with an array of integers that contain numbers in random order. Write a program to find and return the number which occurs maximum times in the given input.
// If more than one element occurs same number of times in the input, return the element which is present in the input first.
// Input Format :
// Line 1 : An Integer N i.e. size of array
// Line 2 : N integers which are elements of the array, separated by spaces
// Output Format :
// Most frequent element
// Constraints :
// 1 <= N <= 10^5
// Sample Input 1 :
// 13
// 2 12 2 11 12 2 1 2 2 11 12 2 6 
// Sample Output 1 :
// 2
// Sample Input 2 :
// 3
// 1 4 5
// Sample Output 2 :
// 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        System.out.println(maxFrequencyNumber(arr));
    }

    public static int maxFrequencyNumber(int[] arr) {

        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int e : arr) {
            if (map.containsKey(e)) {
                int tempCount = map.get(e);
                map.put(e, tempCount + 1);
            } else {
                map.put(e, 1);
            }
        }
        int max = -1;
        int maxInt = arr[0];
        for (int k : map.keySet()) {
            int c = map.get(k);
            if (c > max) {
                max = c;
                maxInt = k;
            }
        }
        return maxInt;

    }
}
